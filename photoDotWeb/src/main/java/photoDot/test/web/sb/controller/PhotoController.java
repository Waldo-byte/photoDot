package photoDot.test.web.sb.controller;


import com.microsoft.azure.storage.StorageException;
import domain.dto.PhotoClassDTO;
import logic.flow.PhotoClassFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.rmi.RemoteException;
import java.security.InvalidKeyException;


@RestController
@RequestMapping("/photos")
@ComponentScan(value = "logic.flow")
@CrossOrigin("*")
public class PhotoController {
    private final PhotoClassFlow photoClassFlow;

    @Autowired
    public PhotoController(PhotoClassFlow photoClassFlow) {
        this.photoClassFlow = photoClassFlow;
    }

    @PostMapping("upload/photo")
    public String create(@RequestParam Long usrid, @RequestParam MultipartFile file) throws IOException, URISyntaxException, InvalidKeyException, StorageException {
        String idplusname;
        String stored;
        PhotoClassDTO photoClassDTO = new PhotoClassDTO(file.getName(), usrid);
        PhotoClassDTO photoClassDTO1 =  photoClassFlow.create(photoClassDTO);
        if(photoClassDTO1 != null)
        {
            try {
                idplusname = photoClassFlow.getName(usrid);
                stored = photoClassFlow.storeFile(file.getName(),file.getInputStream(),file.getSize(),usrid+idplusname);
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
}
