package domain.dto;

import domain.persistance.Albums;
import domain.persistance.PhotoClass;
import domain.persistance.photoDotUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "PhotoClass", description = "Photoclass data transfer object")
public class PhotoClassDTO implements Serializable {
    private Long photoid;
    private String filename;
    private Long user;
    private Long albums;

    public PhotoClassDTO(String filename, Long user)
    {
        this.filename = filename;
        this.user = user;
        this.albums = 0L;
    }

    public PhotoClassDTO(String filename, Long user, Long albums) {
        this.filename = filename;
        this.user = user;
        this.albums = albums;
    }

    public PhotoClassDTO(PhotoClass photoClass){
        this.photoid = photoClass.getId();
        this.filename = photoClass.getFilename();
        this.user = photoClass.getUser().getUserid();
        if(photoClass.getAlbum().getId() == null){
            this.albums = 0L;
        }
        else{
            photoClass.getAlbum().getId();
        }

    }

    public Long getPhotoid() {
        return photoid;
    }

    public void setPhotoid(Long photoid) {
        this.photoid = photoid;
    }

    @ApiModelProperty(
            position = 1,
            value = "Filename",
            name = "name",
            dataType = "java.lang.String",
            example = "this.txt",
            required = true
    )
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @ApiModelProperty(
            position = 1,
            value = "UserID",
            name = "useriD",
            dataType = "java.lang.Long",
            example = "0",
            required = true
    )
    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    @ApiModelProperty(
            position = 1,
            value = "AlbumID",
            name = "albumID",
            dataType = "java.lang.Long",
            example = "0",
            required = true
    )
    public Long getAlbums() {
        return albums;
    }

    public void setAlbums(Long albums) {
        this.albums = albums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoClassDTO that = (PhotoClassDTO) o;
        return Objects.equals(photoid, that.photoid) && Objects.equals(filename, that.filename) && Objects.equals(user, that.user) && Objects.equals(albums, that.albums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoid, filename, user, albums);
    }

    @Override
    public String toString() {
        return "PhotoClassDTO{" +
                "photoid=" + photoid +
                ", filename='" + filename + '\'' +
                ", user=" + user +
                ", albums=" + albums +
                '}';
    }
}
