package insat.bibiboussaid.bloodonation.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailBody {

    private String to;
    private String subject;

    private String firstName;
    private String lastName;
    private String bloodType;
    private String phoneNumber;
    private String medicalCenter;

}
