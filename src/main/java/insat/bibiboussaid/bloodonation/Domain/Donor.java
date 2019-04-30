package insat.bibiboussaid.bloodonation.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Donor {

    @Id
    public String personid;
    public int cin;

    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private int zipcode;
    private String email;
    private String username;
    private String password;
    private int phonenumber;
    private String gender;
    private String bloodtype;
    private double weight;
    private double height;

    @OneToMany(mappedBy = "personDonor",fetch = FetchType.LAZY)
    @JsonBackReference
    List<DonationRequest> donationRequestList;
}
