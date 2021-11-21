package repo.persistance;

import domain.persistance.Albums;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepo extends JpaRepository<Albums,Long> {
}
