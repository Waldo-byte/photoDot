package domain.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import domain.persistance.Albums;
import domain.persistance.photoDotUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "Albums" ,description ="Data Transfer object that represents the album model")
public class AlbumsDTO implements Serializable {

    private Long id;
    private String albumname;
    private Long userid;

    public AlbumsDTO() {
    }

    public AlbumsDTO(Long id, String albumname, Long userid) {
        this.id = id;
        this.albumname = albumname;
        this.userid = userid;
    }

    public AlbumsDTO(String albumname, Long userid) {
        this.albumname = albumname;
        this.userid = userid;
    }

    public AlbumsDTO(Albums album)
    {
        this.id = album.getId();
        this.albumname = album.getAlbumname();
        this.userid = album.getUser().getUserid();
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ApiModelProperty(
            position = 1,
            value = "Album name",
            name = "Album",
            dataType = "java.lang.String",
            example = "Sunsets",
            required = true
    )
    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }


    @ApiModelProperty(
            position = 2,
            value = "Userid",
            name = "id",
            dataType = "java.lang.Long",
            example = "0",
            required = true
    )
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

//    @JsonIgnore
//    public Albums getAlbum(){
//        return new Albums(this.albumname,this.userid);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumsDTO albumsDTO = (AlbumsDTO) o;
        return Objects.equals(id, albumsDTO.id) && Objects.equals(albumname, albumsDTO.albumname) && Objects.equals(userid, albumsDTO.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, albumname, userid);
    }

    @Override
    public String toString() {
        return "AlbumsDTO{" +
                "id=" + id +
                ", albumname='" + albumname + '\'' +
                ", userid=" + userid +
                '}';
    }
}
