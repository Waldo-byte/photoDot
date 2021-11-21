package repo.persistance;

import domain.persistance.PhotoClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoClassRepo extends JpaRepository<PhotoClass,Long> {
}
