package repo.persistance;

import domain.persistance.photoDotUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface photoDotUserRepo extends JpaRepository<photoDotUser, Long> {
    @Query("select p from photoDotUser p where p.name = ?1")
    photoDotUser findByName(String name);

    @Query("select (count(p) > 0) from photoDotUser p where p.email = ?1")
    boolean existsByEmail(String email);

}
