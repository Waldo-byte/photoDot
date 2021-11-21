package repo.persistance;

import domain.persistance.Albums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlbumRepo extends JpaRepository<Albums,Long> {
    @Query("select a from Albums a where a.user.userid = ?1")
    List<Albums> findByUser_UseridEquals(Long userid);

}
