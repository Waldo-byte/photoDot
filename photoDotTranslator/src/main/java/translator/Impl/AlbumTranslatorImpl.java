package translator.Impl;

import domain.dto.AlbumsDTO;
import domain.dto.PhotoClassDTO;
import domain.persistance.Albums;
import domain.persistance.PhotoClass;
import domain.persistance.photoDotUser;
import repo.persistance.AlbumRepo;
import repo.persistance.photoDotUserRepo;
import translator.AlbumTranslator;

public class AlbumTranslatorImpl implements AlbumTranslator {
    private final AlbumRepo albumRepo;
    private final repo.persistance.photoDotUserRepo photoDotUserRepo;

    public AlbumTranslatorImpl(AlbumRepo albumRepo, repo.persistance.photoDotUserRepo photoDotUserRepo) {
        this.albumRepo = albumRepo;
        this.photoDotUserRepo = photoDotUserRepo;
    }

    public AlbumTranslatorImpl(AlbumRepo albumRepo) {
        this.albumRepo = albumRepo;
        this.photoDotUserRepo= null;
    }

    public AlbumTranslatorImpl(repo.persistance.photoDotUserRepo photoDotUserRepo) {
        this.photoDotUserRepo = photoDotUserRepo;
        this.albumRepo = null;
    }

    @Override
    public AlbumsDTO getid(Long id) {
        return null;
    }

    @Override
    public AlbumsDTO create(AlbumsDTO albumsDTO) {
        try{
            photoDotUser photoDotUser = photoDotUserRepo.getOne(albumsDTO.getId());
            Albums albums = albumRepo.getOne(albumsDTO.getId());
            return new AlbumsDTO(albumRepo.save(
                    new Albums(
                            albums.getAlbumname(),
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
