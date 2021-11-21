package translator.Impl;

import domain.dto.PhotoClassDTO;
import domain.dto.SharedImagesDTO;
import domain.persistance.PhotoClass;
import domain.persistance.SharedImages;
import domain.persistance.photoDotUser;
import repo.persistance.PhotoClassRepo;
import repo.persistance.SharedImagesRepo;
import repo.persistance.photoDotUserRepo;
import translator.ShareImagesTranslator;

public class SharedImagesTranslatorImpl implements ShareImagesTranslator {
    private final SharedImagesRepo sharedImagesRepo;
    private final PhotoClassRepo sharedphotos;
    private final photoDotUserRepo shareduser;



    public SharedImagesTranslatorImpl(SharedImagesRepo sharedImagesRepo, PhotoClassRepo sharedphotos, photoDotUserRepo shareduser) {
        this.sharedImagesRepo = sharedImagesRepo;
        this.sharedphotos = sharedphotos;
        this.shareduser = shareduser;
    }

    public SharedImagesTranslatorImpl(SharedImagesRepo sharedImagesRepo) {
        this.sharedImagesRepo = sharedImagesRepo;
        this.sharedphotos = null;
        this.shareduser = null;
    }

    public SharedImagesTranslatorImpl(PhotoClassRepo sharedphotos) {
        this.sharedphotos = sharedphotos;
        this.sharedImagesRepo = null;
        this.shareduser = null;
    }

    @Override
    public SharedImagesDTO create(SharedImagesDTO sharedImagesDTO) {
        try{
            PhotoClass shareimage = sharedphotos.getOne(sharedImagesDTO.getPictureiD());
            photoDotUser sharedusers = shareduser.getOne(sharedImagesDTO.getUsrID());
            return new SharedImagesDTO(sharedImagesRepo.save(
                    new SharedImages(
                            sharedusers,
                            shareimage
                    ))
            );

        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to save to db", e);
        }
    }
}
