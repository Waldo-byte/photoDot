package repo.persistance;

import domain.persistance.PhotoClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhotoClassRepo extends JpaRepository<PhotoClass,Long> {
    @Query("select (count(p) > 0) from PhotoClass p where p.filename = ?1")
    boolean existsByFilename(String filename);

    @Query("select p from PhotoClass p where p.user.userid = ?1")
    PhotoClass findByUser_UseridEquals(Long userid);

    PhotoClass findByPhotoid(Long photoid);




}
