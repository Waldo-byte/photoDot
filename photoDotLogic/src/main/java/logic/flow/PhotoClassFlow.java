package logic.flow;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import domain.dto.PhotoClassDTO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

public interface PhotoClassFlow {
    PhotoClassDTO create(PhotoClassDTO photoClassDTO);
    String getName(Long id);
    String storeFile(String filename, InputStream content, Long lenght, String idplusname) throws URISyntaxException, IOException, InvalidKeyException, StorageException;
    CloudBlobContainer container(String idplusname) throws URISyntaxException, InvalidKeyException, StorageException;
    boolean deleteFile(String filename, String idplusname) throws URISyntaxException, InvalidKeyException, StorageException;
}
