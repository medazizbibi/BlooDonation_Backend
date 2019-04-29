package insat.bibiboussaid.bloodonation.Domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user")
public class JwtUser {

    @Id
    private String id;
    private String username;
    private String password;

    public JwtUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    public JwtUser(){}
}