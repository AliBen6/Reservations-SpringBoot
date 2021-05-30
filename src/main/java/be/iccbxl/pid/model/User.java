package be.iccbxl.pid.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="users")
public class User  {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(length = 30, unique = true, nullable = false)
    private String login;
    @Column(length = 255, nullable = false)
    private String password;
    @Column(length = 60, nullable = false)
    private String firstname;
    @Column(length = 60, nullable = false)
    private String lastname;
    @Column(length = 100, nullable = false)
    private String email;
    @Column
    private String langue;

    private boolean active;

    @OneToMany(mappedBy = "artist")
    private List<ArtistType> types ;

    @Transient
    private String fullUrlImg;

    @Transient
    private String roles;

    @Transient
    private String newPassword;

    public User(String login, String password, String firstname, String lastname, String email, String langue) {
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.langue = langue;
    }


    @Override
    public String toString() {
        return login +" "+ lastname;
    }


}
