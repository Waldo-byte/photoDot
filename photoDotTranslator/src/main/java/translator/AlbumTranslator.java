package translator;

import domain.dto.AlbumsDTO;

public interface AlbumTranslator {
    AlbumsDTO getid(Long id);
    AlbumsDTO create(AlbumsDTO albumsDTO);
}
