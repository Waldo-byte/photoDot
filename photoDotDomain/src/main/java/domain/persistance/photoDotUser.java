package domain.persistance;

import domain.dto.PhotoClassDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "photoDotUser3")
public class photoDotUser implements Serializable {
    @Id
    @SequenceGenerator(
            name = "usrSeq",
            sequenceName = "usrSeq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "usrSeq"
    )
    private Long userid;
    private String name;
    private String surname;
    private String email;
    private String password;

    public photoDotUser(PhotoClassDTO photoClassDTO)
    {
        this.userid = photoClassDTO.getUser();
    }

    public photoDotUser() {
    }

    public photoDotUser(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    @Column(name="id")
    public Long getUserid() {
        return userid;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "LNAME")
    public String getSurname() {
        return surname;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    @Column(name = "PASS")
    public String getPassword() {
        return password;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
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

    @Override
    public String toString() {
        return "photoDotUser{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        photoDotUser that = (photoDotUser) o;
        return Objects.equals(userid, that.userid) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, name, surname, email, password);
    }
}
