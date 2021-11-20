package photoDot.test.web.sb.controller;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.ReadChannel;
import com.google.cloud.storage.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    StorageOptions storageOptions;

    {
        try {
            storageOptions = StorageOptions.newBuilder()
                    .setProjectId("natural-engine-332701")
                    .setCredentials(GoogleCredentials.fromStream(new
                            FileInputStream("src/main/resources/gcp-credentials.json"))).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Storage storage = storageOptions.getService();
    private String bucketName = "springbootapp";
    private Bucket bucket = storage.get("springbootapp");

    @GetMapping("/getall")
    public List<String> readFromFile() throws Exception {
        List<String> blobs = new ArrayList<>();
        for(Blob currentBlob: bucket.list().iterateAll(){
            Page<Blob>(currentBlob);
        }
        return next;
    }



}
