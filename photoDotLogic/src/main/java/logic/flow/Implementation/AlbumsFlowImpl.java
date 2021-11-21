package logic.flow.Implementation;

import domain.dto.AlbumsDTO;
import logic.flow.AlbumFlow;
import translator.AlbumTranslator;

public class AlbumsFlowImpl implements AlbumFlow {
    private final AlbumTranslator albumTranslator;

    public AlbumsFlowImpl(AlbumTranslator albumTranslator) {
        this.albumTranslator = albumTranslator;
    }

    @Override
    public AlbumsDTO create(AlbumsDTO albumsDTO) {
        return albumTranslator.create(albumsDTO);
    }
}
