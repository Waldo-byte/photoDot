package translator.Impl;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.*;
import domain.dto.AlbumsDTO;
import domain.dto.CreateAccountDTO;
import domain.dto.PhotoClassDTO;
import domain.persistance.Albums;
import domain.persistance.PhotoClass;
import domain.persistance.photoDotUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import repo.persistance.AlbumRepo;
import repo.persistance.PhotoClassRepo;
import repo.persistance.photoDotUserRepo;
import translator.PhotoClassTranslator;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan(value = "repo.persistance")
public class PhotoClassTranslatorImpl implements PhotoClassTranslator {
    private final PhotoClassRepo photoClassRepo;
    private final photoDotUserRepo photoDotUserRepo;
    private final AlbumRepo albumRepo;
    private String azureurl = "DefaultEndpointsProtocol=https;AccountName=retryspringboot;AccountKey=q78B/cJUgK/D+woCWXGgvx8kallQdWZfPJS/WawjYdSh5CTVyXV2D+tdPVQisz8EqI81bTp6Gxlzboso05qcDA==;EndpointSuffix=core.windows.net";

    @Autowired
    public PhotoClassTranslatorImpl(PhotoClassRepo photoClassRepo, repo.persistance.photoDotUserRepo photoDotUserRepo, AlbumRepo albumRepo) {
        this.photoClassRepo = photoClassRepo;
        this.photoDotUserRepo = photoDotUserRepo;
        this.albumRepo = albumRepo;
    }


    @Override
    public PhotoClassDTO getPhoto(Long id){
            PhotoClass photo = photoClassRepo.getOne(id);
            try{
                return new PhotoClassDTO(photo);
            }
            catch (Exception e)
            {
                throw new RuntimeException(e.toString());
            }

    }

    @Override
    public PhotoClassDTO create(PhotoClassDTO photoClassDTO) {
        try{
            boolean exists = photoClassRepo.existsByFilename(photoClassDTO.getFilename());
            if(exists)
            {
                throw new RuntimeException("File already exists");
            }
            else{
                photoDotUser photoDotUser = photoDotUserRepo.getOne(photoClassDTO.getUser());
                Albums albums = albumRepo.findByAlbumnameAndUser_Userid("root", photoClassDTO.getUser());
                return new PhotoClassDTO(photoClassRepo.save(
                        new PhotoClass(
                                photoClassDTO.getFilename(),
                                photoDotUser,
                                albums
                        ))
                );

            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to save to db"+e.toString());
        }
    }

    @Override
    public String getUser(Long id) {
        try{
            photoDotUser photoDotUsers = photoDotUserRepo.getOne(id);
            return photoDotUsers.getName();
        }
        catch(Exception e){
            throw new RuntimeException("Could not find user");
        }

    }

    @Override
    public String storeFile(String filename, InputStream content, Long lenght, String idplusname) throws URISyntaxException, StorageException, IOException, InvalidKeyException {
        CloudBlockBlob blob = container(idplusname).getBlockBlobReference(filename);
        if(blob.exists())
        {
            return "File already exists";
        }
        else
        {

            blob.upload(content,lenght);
        }
        return "Upload Success";
    }

    @Override
    public CloudBlobContainer container(String idplusname) throws URISyntaxException, StorageException, InvalidKeyException {
        String containerName = idplusname;
        CloudStorageAccount storageAccount = CloudStorageAccount.parse(azureurl);
        CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
        CloudBlobContainer blobContainer = blobClient.getContainerReference(containerName);
        blobContainer.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());
        return blobContainer;
    }
    @Override
    public boolean deleteFile(String filename, String idplusname) throws URISyntaxException, InvalidKeyException, StorageException {
        CloudBlockBlob blob = container(idplusname).getBlockBlobReference(filename);
        boolean deleted = false;
        if(blob.exists())
        {
            blob.deleteIfExists();
            deleted= true;
        }
        return deleted;

    }
}
