package insat.bibiboussaid.bloodonation.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @ManyToMany(mappedBy = "donors",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //@JsonBackReference
    List<DonationRequest> donationRequestList;

    @OneToMany(mappedBy = "personDonor",fetch = FetchType.LAZY)
    //@JsonBackReference
    List<Donation> donationsList;
}
