package translator;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import domain.dto.PhotoClassDTO;
import repo.persistance.PhotoClassRepo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

public interface PhotoClassTranslator {
    PhotoClassDTO getPhoto(Long id);
    PhotoClassDTO create(PhotoClassDTO photoClassDTO);
    String getUser(Long id);
    String storeFile(String filename, InputStream content, Long lenght, String idplusname) throws URISyntaxException, StorageException, IOException, InvalidKeyException;
    CloudBlobContainer container(String idplusname) throws URISyntaxException, StorageException, InvalidKeyException;
    boolean deleteFile(String filename, String idplusname) throws URISyntaxException, InvalidKeyException, StorageException;
}
