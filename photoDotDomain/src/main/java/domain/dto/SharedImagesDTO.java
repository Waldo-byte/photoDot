package domain.dto;

import domain.persistance.SharedImages;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@ApiModel(value = "ImageSharedDTO", description = "Data transfer object for shared images")
public class SharedImagesDTO {

    private Long pictureiD;
    private Long usrID;

    public SharedImagesDTO(Long pictureiD, Long usrID) {
        this.pictureiD = pictureiD;
        this.usrID = usrID;
    }

    public SharedImagesDTO(SharedImages sharedImages)
    {
        this.pictureiD = sharedImages.getPhoto().getId();
        this.usrID = sharedImages.getUser().getUserid();
    }

    public void setPictureiD(Long pictureiD) {
        this.pictureiD = pictureiD;
    }

    public void setUsrID(Long usrID) {
        this.usrID = usrID;
    }

    @ApiModelProperty(
            position = 1,
            value = "pictureID",
            name = "PictureId",
            dataType = "java.lang.Long",
            example = "0",
            required = true
    )
    public Long getPictureiD() {
        return pictureiD;
    }

    @ApiModelProperty(
            position = 1,
            value = "userID",
            name = "UserId",
            dataType = "java.lang.Long",
            example = "0",
            required = true
    )
    public Long getUsrID() {
        return usrID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedImagesDTO that = (SharedImagesDTO) o;
        return Objects.equals(pictureiD, that.pictureiD) && Objects.equals(usrID, that.usrID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pictureiD, usrID);
    }

    @Override
    public String toString() {
        return "SharedImagesDTO{" +
                "pictureiD=" + pictureiD +
                ", usrID=" + usrID +
                '}';
    }
}
