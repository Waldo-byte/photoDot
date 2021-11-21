package translator.Impl;

import domain.dto.PhotoClassDTO;
import domain.dto.SharedImagesDTO;
import domain.persistance.PhotoClass;
import domain.persistance.SharedImages;
import domain.persistance.photoDotUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import repo.persistance.PhotoClassRepo;
import repo.persistance.SharedImagesRepo;
import repo.persistance.photoDotUserRepo;
import translator.ShareImagesTranslator;

@Component
@ComponentScan(value = "repo.persistance")
public class SharedImagesTranslatorImpl implements ShareImagesTranslator {
    private final SharedImagesRepo sharedImagesRepo;
    private final PhotoClassRepo sharedphotos;
    private final photoDotUserRepo shareduser;


    @Autowired
    public SharedImagesTranslatorImpl(SharedImagesRepo sharedImagesRepo, PhotoClassRepo sharedphotos, photoDotUserRepo shareduser) {
        this.sharedImagesRepo = sharedImagesRepo;
        this.sharedphotos = sharedphotos;
        this.shareduser = shareduser;
    }


    @Override
    public SharedImagesDTO create(SharedImagesDTO sharedImagesDTO) {
        try{
            System.out.println("This far");
            Long id = sharedImagesDTO.getPictureiD();
            PhotoClass shareimage = sharedphotos.findByPhotoid(id);
            System.out.println(shareimage);
            photoDotUser sharedusers = shareduser.findByUseridIs(sharedImagesDTO.getUsrID());
            System.out.println(sharedusers);
            if(sharedusers.getUserid() == shareimage.getUser().getUserid())
            {
                return null;
            }
            else{
                return new SharedImagesDTO(sharedImagesRepo.save(
                        new SharedImages(
                                sharedusers,
                                shareimage
                        ))
                );
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to save to db "+e.toString());
        }
    }
}
