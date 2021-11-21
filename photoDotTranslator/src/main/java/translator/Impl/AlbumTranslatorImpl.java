package translator.Impl;

import domain.dto.AlbumsDTO;
import domain.dto.PhotoClassDTO;
import domain.persistance.Albums;
import domain.persistance.PhotoClass;
import domain.persistance.photoDotUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import repo.persistance.AlbumRepo;
import repo.persistance.photoDotUserRepo;
import translator.AlbumTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan(value = "repo.persistance")
public class AlbumTranslatorImpl implements AlbumTranslator {
    private final AlbumRepo albumRepo;
    private final repo.persistance.photoDotUserRepo photoDotUserRepo;

    @Autowired
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
            photoDotUser photoDotUser = photoDotUserRepo.getOne(albumsDTO.getUserid());
            return new AlbumsDTO(albumRepo.save(
                    new Albums(
                            albumsDTO.getAlbumname(),
                            photoDotUser
                    ))
            );
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to save to db " + e.toString());
        }
    }

    @Override
    public List<AlbumsDTO> getAlbums(Long id) {
        List<AlbumsDTO> list = new ArrayList<>();
        for(Albums albums: albumRepo.findByUser_UseridEquals(id))
                list.add(new AlbumsDTO(albums));
        return list;
    }

}
