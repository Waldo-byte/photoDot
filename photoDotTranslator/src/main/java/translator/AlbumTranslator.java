package translator;

import domain.dto.AlbumsDTO;

import java.util.List;

public interface AlbumTranslator {
    AlbumsDTO getid(Long id);
    AlbumsDTO create(AlbumsDTO albumsDTO);
    List<AlbumsDTO> getAlbums(Long id);
}
