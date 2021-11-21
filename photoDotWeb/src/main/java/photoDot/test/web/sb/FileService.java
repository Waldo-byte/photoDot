package photoDot.test.web.sb;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

@Service
public class FileService {

//    private String azureurl = "DefaultEndpointsProtocol=https;AccountName=retryspringboot;AccountKey=q78B/cJUgK/D+woCWXGgvx8kallQdWZfPJS/WawjYdSh5CTVyXV2D+tdPVQisz8EqI81bTp6Gxlzboso05qcDA==;EndpointSuffix=core.windows.net";
//
//    private CloudBlobContainer container(String idplusname) throws IOException, URISyntaxException, InvalidKeyException, StorageException {
//        String containerName = idplusname;
//        CloudStorageAccount storageAccount = CloudStorageAccount.parse(azureurl);
//        CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
//        CloudBlobContainer blobContainer = blobClient.getContainerReference(containerName);
//        blobContainer.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());
//        return blobContainer;
//    }
//
//    public String storeFile(String filename, InputStream content, Long lenght, String idplusname) throws IOException, URISyntaxException, InvalidKeyException, StorageException {
//        CloudBlockBlob blob = container(idplusname).getBlockBlobReference(filename);
//        if(blob.exists())
//        {
//            return "File already exists";
//        }
//        else
//        {
//            blob.upload(content,lenght);
//        }
//        return "Upload Success";
//    }
}
