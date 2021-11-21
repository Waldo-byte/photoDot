package logic.flow.Implementation;

import domain.dto.AlbumsDTO;
import logic.flow.AlbumFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import translator.AlbumTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
@ComponentScan(value = "translator")
public class AlbumsFlowImpl implements AlbumFlow {
    private final AlbumTranslator albumTranslator;

    @Autowired
    public AlbumsFlowImpl(AlbumTranslator albumTranslator) {
        this.albumTranslator = albumTranslator;
    }

    @Override
    public AlbumsDTO create(AlbumsDTO albumsDTO) {
        return albumTranslator.create(albumsDTO);
    }

    @Override
    public List<AlbumsDTO> getAlbums(Long id) {
        return albumTranslator.getAlbums(id);
    }
}
