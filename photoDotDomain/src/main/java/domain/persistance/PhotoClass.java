package domain.persistance;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phototable")
public class PhotoClass implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "photoid", nullable = false)
    private Long photoid;

    @Column(name = "filename", nullable = false)
    private String filename;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private photoDotUser user;

    @ManyToOne
    @JoinColumn(name = "albumid")
    private Albums album;

    public PhotoClass(String filename, photoDotUser photoDotUser) {
        this.filename=filename;
        this.user = photoDotUser;
    }

    public Albums getAlbum() {
        return album;
    }

    public void setAlbum(Albums album) {
        this.album = album;
    }

    public void setPhotoid(Long photoid) {
        this.photoid = photoid;
    }

    public void setUser(photoDotUser user) {
        this.user = user;
    }

    public Long getPhotoid() {
        return photoid;
    }

    public photoDotUser getUser() {
        return user;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getId() {
        return photoid;
    }

    public void setId(Long photoid) {
        this.photoid = photoid;
    }

    public PhotoClass(Long photoid, String filename, photoDotUser user) {
        this.photoid = photoid;
        this.filename = filename;
        this.user = user;
    }
}
