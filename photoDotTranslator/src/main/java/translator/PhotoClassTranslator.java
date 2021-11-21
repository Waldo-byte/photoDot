package translator;

import domain.dto.PhotoClassDTO;
import repo.persistance.PhotoClassRepo;

public interface PhotoClassTranslator {
    PhotoClassDTO getPhoto(Long id);
    PhotoClassDTO create(PhotoClassDTO photoClassDTO);
}
