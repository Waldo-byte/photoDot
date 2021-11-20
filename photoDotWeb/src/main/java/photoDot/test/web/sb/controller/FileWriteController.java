package photoDot.test.web.sb.controller;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceAsyncClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.web.bind.annotation.*;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/file")
@CrossOrigin("*")
public class FileWriteController {

   // @Value("${azure.myblob.url}")
    private String azureurl = "BlobEndpoint=https://retryspringboot.blob.core.windows.net/;QueueEndpoint=https://retryspringboot.queue.core.windows.net/;FileEndpoint=https://retryspringboot.file.core.windows.net/;TableEndpoint=https://retryspringboot.table.core.windows.net/;SharedAccessSignature=sv=2020-08-04&ss=bfqt&srt=sco&sp=rwdlacupitfx&se=2021-12-09T01:59:16Z&st=2021-11-20T17:59:16Z&spr=https,http&sig=OoHviDFFCRcu83L0ttlwSuwXKu16vLP0RlqtnQ7I2SY%3D";

   // @Value("${azure.myblob.container}")
    private String containerName = "waldocontainer";

    private BlobContainerClient containerClient(){
        BlobServiceClient serviceClient = new BlobServiceClientBuilder()
                .connectionString(azureurl).buildClient();
        BlobContainerClient container = serviceClient.createBlobContainer(containerName);
        return container;
    }

    @GetMapping("/all")
    public String listFiles(){
        BlobContainerClient containerClient = containerClient();
        List<String> listfiles = new ArrayList<>();
        String item = null;
        for(BlobItem blobItem: containerClient.listBlobs()){
            listfiles.add(blobItem.getName());
            item = blobItem.getName();
        }
        return item;
    }





}
