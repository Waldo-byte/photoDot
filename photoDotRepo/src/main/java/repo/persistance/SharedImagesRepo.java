package repo.persistance;

import domain.persistance.SharedImages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SharedImagesRepo extends JpaRepository<SharedImages, Long> {


}
