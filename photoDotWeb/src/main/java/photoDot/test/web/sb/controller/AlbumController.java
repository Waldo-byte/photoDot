package photoDot.test.web.sb.controller;

import domain.dto.AlbumsDTO;
import io.swagger.annotations.ApiParam;
import logic.flow.AlbumFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.coyote.http11.Constants.a;

@RestController
@RequestMapping("/photos/albums")
@CrossOrigin("*")
public class AlbumController {
    private final AlbumFlow albumFlow;

    @Autowired
    public AlbumController(AlbumFlow albumFlow) {
        this.albumFlow = albumFlow;
    }

    @PostMapping("/create")
    public AlbumsDTO create(@RequestParam String albumname, @RequestParam Long usrid){
        AlbumsDTO albumsDTO = albumFlow.create(new AlbumsDTO(albumname,usrid));
        return albumsDTO;
    }

    @GetMapping("/list")
    public List<AlbumsDTO> getallusrAlbums(@RequestParam Long id){
        List<AlbumsDTO> list = albumFlow.getAlbums(id);
        return list;
    }
}
