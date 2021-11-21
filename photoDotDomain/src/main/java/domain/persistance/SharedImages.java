package domain.persistance;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name ="user_photo1" )
public class SharedImages implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private photoDotUser user;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id")
    private PhotoClass photo;

    public photoDotUser getUser() {
        return user;
    }

    public PhotoClass getPhoto() {
        return photo;
    }

    public SharedImages() {
    }

    public SharedImages(photoDotUser user, PhotoClass photo) {
        this.user = user;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(photoDotUser user) {
        this.user = user;
    }

    public void setPhoto(PhotoClass photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedImages that = (SharedImages) o;
        return Objects.equals(user, that.user) && Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, photo);
    }

    @Override
    public String toString() {
        return "SharedImages{" +
                "user=" + user +
                ", photo=" + photo +
                '}';
    }
}
