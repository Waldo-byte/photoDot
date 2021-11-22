package domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import domain.persistance.photoDotUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@ApiModel(value="UserAccount", description = "DataTransfer object that represents the photoDotUser class")
public class CreateAccountDTO implements Serializable {

    private Long uuid;
    private String name;
    private String surname;
    private String email;
    private String password;

    public CreateAccountDTO() {
    }

    public CreateAccountDTO(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public CreateAccountDTO(photoDotUser user)
    {
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.uuid = user.getUserid();

    }

    @ApiModelProperty(
            position = 1,
            value = "User Name",
            name = "Name",
            dataType = "java.lang.String",
            example = "Jason",
            required = true
    )
    public String getName() {
        return name;
    }

    @ApiModelProperty(
            position = 2,
            value = "Surname",
            name = "Surname",
            dataType = "java.lang.String",
            example = "Stevens",
            required = true
    )
    public String getSurname() {
        return surname;
    }

    @ApiModelProperty(
            position = 3,
            value = "Email",
            name = "Email",
            dataType = "java.lang.String",
            example = "example@gmail.com",
            required = true
    )
    public String getEmail() {
        return email;
    }

    @ApiModelProperty(
            position = 4,
            value = "H-Password",
            name = "Password",
            dataType = "java.lang.String",
            example = "hashedpassword",
            required = true
    )
    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    public long getUuid() {
        return uuid;
    }

    @JsonIgnore
    public photoDotUser getUser()
    {
        return new photoDotUser(this.getName(),this.getSurname(),this.getEmail(),this.getPassword());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateAccountDTO that = (CreateAccountDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email, password);
    }

    @Override
    public String toString() {
        return "CreateAccountDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
