package insat.bibiboussaid.bloodonation.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Donation {

    @Id
    private String donationId;

    private String donationDate;
    private String firstName;
    private String lastName;
    private String bloodType;
    private String phoneNumber;
    private String medicalCenter;
    private String donorId;

    @ManyToOne(fetch= FetchType.LAZY)
    @JsonManagedReference
    private Donor personDonor;
}
