package photoDot.test.web.sb.controller;

import com.azure.storage.blob.*;
import com.azure.storage.blob.models.BlobItem;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/file")
@CrossOrigin("*")
public class FileWriteController {
    private String azureurl = "DefaultEndpointsProtocol=https;AccountName=retryspringboot;AccountKey=q78B/cJUgK/D+woCWXGgvx8kallQdWZfPJS/WawjYdSh5CTVyXV2D+tdPVQisz8EqI81bTp6Gxlzboso05qcDA==;EndpointSuffix=core.windows.net";

    private CloudBlobContainer container(String idplusname) throws IOException, URISyntaxException, InvalidKeyException, StorageException {
        String containerName = idplusname;
        CloudStorageAccount storageAccount = CloudStorageAccount.parse(azureurl);
        CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
        CloudBlobContainer blobContainer = blobClient.getContainerReference(containerName);
        blobContainer.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());
        return blobContainer;
    }


    @GetMapping("/all")
    public List<String> listFiles(@RequestParam String idplusname) throws IOException, URISyntaxException, InvalidKeyException, StorageException {
        CloudBlobContainer container = container(idplusname);
        List<String> list = new ArrayList<>();
        for(ListBlobItem blobItem: container.listBlobs())
            list.add(blobItem.getUri().toString());
        return list;
    }

    public String storeFile(String filename, InputStream content, Long lenght, String idplusname) throws IOException, URISyntaxException, InvalidKeyException, StorageException {
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

    @PostMapping("postfile")
    public String uploadfile(@RequestParam MultipartFile file, @RequestParam String idplususer) throws IOException, URISyntaxException, InvalidKeyException, StorageException {
        String storefilemsg = "";
        storefilemsg = storeFile(file.getOriginalFilename(), file.getInputStream(), file.getSize(), idplususer);
        return file.getOriginalFilename().toString() + storefilemsg;
    }






}
