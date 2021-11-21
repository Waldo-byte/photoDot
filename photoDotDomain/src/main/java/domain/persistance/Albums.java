package domain.persistance;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "albums")
public class Albums implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "albumid", nullable = false)
    private Long id;

    @Column(name = "albumName")
    private String albumname;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private photoDotUser user;

    public Albums() {
    }

    public Albums(String albumname, photoDotUser user) {
        this.albumname = albumname;
        this.user = user;
    }


    public Albums(Long id, String albumname, photoDotUser user) {
        this.id = id;
        this.albumname = albumname;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public photoDotUser getUser() {
        return user;
    }

    public void setUser(photoDotUser user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Albums albums = (Albums) o;
        return Objects.equals(id, albums.id) && Objects.equals(albumname, albums.albumname) && Objects.equals(user, albums.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, albumname, user);
    }

    @Override
    public String toString() {
        return "Albums{" +
                "id=" + id +
                ", albumname='" + albumname + '\'' +
                ", user=" + user +
                '}';
    }
}
