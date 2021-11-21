package logic.flow.Implementation;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import domain.dto.PhotoClassDTO;
import logic.flow.PhotoClassFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import translator.PhotoClassTranslator;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

@Transactional
@Component
@ComponentScan(value = "translator")
public class PhotoClassFlowImpl implements PhotoClassFlow {
    private final PhotoClassTranslator photoClassTranslator;

    @Autowired
    public PhotoClassFlowImpl(PhotoClassTranslator photoClassTranslator) {
        this.photoClassTranslator = photoClassTranslator;
    }

    @Override
    public PhotoClassDTO create(PhotoClassDTO photoClassDTO) {
        return photoClassTranslator.create(photoClassDTO);
    }

    @Override
    public String getName(Long id) {
        return photoClassTranslator.getUser(id);
    }

    @Override
    public String storeFile(String filename, InputStream content, Long lenght, String idplusname) throws URISyntaxException, IOException, InvalidKeyException, StorageException {
        return photoClassTranslator.storeFile(filename, content, lenght, idplusname);
    }

    @Override
    public CloudBlobContainer container(String idplusname) throws URISyntaxException, InvalidKeyException, StorageException {
        return photoClassTranslator.container(idplusname);
    }


}
