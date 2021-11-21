package logic.flow;

import domain.dto.AlbumsDTO;

import java.util.List;

public interface AlbumFlow {

    AlbumsDTO create(AlbumsDTO albumsDTO);
    List<AlbumsDTO> getAlbums(Long id);
}
