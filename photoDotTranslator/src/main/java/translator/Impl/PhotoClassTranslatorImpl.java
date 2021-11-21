package translator.Impl;

import domain.dto.CreateAccountDTO;
import domain.dto.PhotoClassDTO;
import domain.persistance.PhotoClass;
import domain.persistance.photoDotUser;
import repo.persistance.PhotoClassRepo;
import repo.persistance.photoDotUserRepo;
import translator.PhotoClassTranslator;

import java.util.ArrayList;
import java.util.List;

public class PhotoClassTranslatorImpl implements PhotoClassTranslator {
    private final PhotoClassRepo photoClassRepo;
    private final photoDotUserRepo photoDotUserRepo;

    public PhotoClassTranslatorImpl(PhotoClassRepo photoClassRepo) {
        this.photoClassRepo = photoClassRepo;
        this.photoDotUserRepo = null;
    }

    public PhotoClassTranslatorImpl(PhotoClassRepo photoClassRepo, repo.persistance.photoDotUserRepo photoDotUserRepo) {
        this.photoClassRepo = photoClassRepo;
        this.photoDotUserRepo = photoDotUserRepo;
    }

    public PhotoClassTranslatorImpl(repo.persistance.photoDotUserRepo photoDotUserRepo) {
        this.photoDotUserRepo = photoDotUserRepo;
        this.photoClassRepo = null;
    }

    @Override
    public PhotoClassDTO getPhoto(Long id){
            PhotoClass photo = photoClassRepo.getOne(id);
            try{
                return new PhotoClassDTO(photo);
            }
            catch (Exception e)
            {
                throw new RuntimeException(e.toString());
            }

    }

    @Override
    public PhotoClassDTO create(PhotoClassDTO photoClassDTO) {
        try{
            photoDotUser photoDotUser = photoDotUserRepo.getOne(photoClassDTO.getUser());
            PhotoClass photoClass = photoClassRepo.getOne(photoClassDTO.getPhotoid());
            return new PhotoClassDTO(photoClassRepo.save(
                    new PhotoClass(
                            photoClassDTO.getFilename(),
                            photoDotUser
                    ))
            );

        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to save to db", e);
        }
    }
}
