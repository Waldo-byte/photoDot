package photoDot.test.web.sb.controller;


import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.*;
import domain.dto.PhotoClassDTO;
import logic.flow.CreateAccountFlow;
import logic.flow.PhotoClassFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.RemoteException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@RestController
@RequestMapping("/photos")
@ComponentScan(value = "logic.flow")
@CrossOrigin("*")
public class PhotoController {
    private final PhotoClassFlow photoClassFlow;
    private final CreateAccountFlow createAccountFlow;

    @Autowired
    public PhotoController(PhotoClassFlow photoClassFlow, CreateAccountFlow createAccountFlow) {
        this.photoClassFlow = photoClassFlow;
        this.createAccountFlow = createAccountFlow;
    }

    private String azureurl = "DefaultEndpointsProtocol=https;AccountName=retryspringboot;AccountKey=q78B/cJUgK/D+woCWXGgvx8kallQdWZfPJS/WawjYdSh5CTVyXV2D+tdPVQisz8EqI81bTp6Gxlzboso05qcDA==;EndpointSuffix=core.windows.net";

    private CloudBlobContainer container(String idplusname) throws IOException, URISyntaxException, InvalidKeyException, StorageException {
        String containerName = idplusname;
        CloudStorageAccount storageAccount = CloudStorageAccount.parse(azureurl);
        CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
        CloudBlobContainer blobContainer = blobClient.getContainerReference(containerName);
        blobContainer.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());
        return blobContainer;
    }

    @PostMapping("upload/photo")
    public String create(@RequestParam Long usrid, @RequestParam MultipartFile file) throws IOException, URISyntaxException, InvalidKeyException, StorageException {
        String idplusname;
        String stored;
        PhotoClassDTO photoClassDTO = new PhotoClassDTO(file.getOriginalFilename(), usrid);
        PhotoClassDTO photoClassDTO1 =  photoClassFlow.create(photoClassDTO);
        if(photoClassDTO1 != null)
        {
            try {
                idplusname = createAccountFlow.getName(usrid);
                stored = photoClassFlow.storeFile(file.getOriginalFilename(),file.getInputStream(),file.getSize(),(usrid+idplusname).toLowerCase(Locale.ROOT));
                return stored;
            }
            catch (Exception e)
            {
                throw new RemoteException(e.toString());
            }
        }
        else{
            throw new RuntimeException("Photo Already exists");
        }

    }

    @GetMapping("/all")
    public List<String> listFiles(@RequestParam Long userid, @RequestParam String name) throws IOException, URISyntaxException, InvalidKeyException, StorageException {
        String idplusname = userid + name.toLowerCase(Locale.ROOT);
        CloudBlobContainer container = container(idplusname);
        List<String> list = new ArrayList<>();
        for(ListBlobItem blobItem: container.listBlobs())
            list.add(blobItem.getUri().toString());
        return list;
    }

//    @GetMapping("/Download")
//    public PhotoClassDTO download(@RequestParam Long userid, @RequestParam URI uri, @RequestParam String name) throws IOException, URISyntaxException, InvalidKeyException, StorageException {
//    CloudBlobContainer container = container(userid + name.toLowerCase(Locale.ROOT));
//    try{
//        List<String> list = new ArrayList<>();
//        for(ListBlobItem blobItem: container.listBlobs()){
//            list.add(blobItem.getUri().toString());
//            blobItem.
//        }
//
//    }
//    catch (Exception e)
//    {
//        throw new RemoteException(e.toString());
//    }
//
//    }
}
