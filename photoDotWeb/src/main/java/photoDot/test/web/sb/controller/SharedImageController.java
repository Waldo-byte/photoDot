package photoDot.test.web.sb.controller;


import domain.dto.SharedImagesDTO;
import logic.flow.SharedImagesFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/photos/shared-images")
@CrossOrigin("*")
public class SharedImageController {
    private final SharedImagesFlow sharedImagesFlow;

    @Autowired
    public SharedImageController(SharedImagesFlow sharedImagesFlow) {
        this.sharedImagesFlow = sharedImagesFlow;
    }

    @PostMapping("/share")
    public SharedImagesDTO create(@RequestParam Long usrid,@RequestParam Long photoid){
        SharedImagesDTO sharedImagesDTO = sharedImagesFlow.create(new SharedImagesDTO(photoid,usrid));
        return sharedImagesDTO;
    }
}
