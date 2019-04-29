package insat.bibiboussaid.bloodonation.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class DonationRequest {

    @Id
    private String donationRequestId;

    private String firstName;
    private String lastName;
    private String bloodType;
    private String phoneNumber;
    private String medicalCenter;

    @OneToMany(fetch= FetchType.LAZY)
    @JsonManagedReference
    private List<Donor> requestDonors;

}
