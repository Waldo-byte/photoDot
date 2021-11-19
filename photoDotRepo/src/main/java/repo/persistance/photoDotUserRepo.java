package repo.persistance;

import domain.persistance.photoDotUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface photoDotUserRepo extends JpaRepository<photoDotUser,UUID> {
}
