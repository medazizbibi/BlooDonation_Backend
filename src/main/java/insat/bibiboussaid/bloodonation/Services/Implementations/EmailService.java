package insat.bibiboussaid.bloodonation.Services.Implementations;

import insat.bibiboussaid.bloodonation.Domain.EmailBody;
import insat.bibiboussaid.bloodonation.Services.Interfaces.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements IEmailService {

    @Autowired
    public JavaMailSender emailSender;

    public void sendSimpleMessage(
            EmailBody body) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(body.getTo());
        message.setSubject(body.getSubject());
        String messageBody= "Greetings, \n\nYou have a new Blood Request from a patient. Here is some informations" +
                " that you need to know : \nFull name : " + body.getFirstName()+" "+body.getLastName() +"\nBlood type : " + body.getBloodType()
                + "\nPhone number:" + body.getPhoneNumber()+"\nMedical Center : " + body.getMedicalCenter() + "\nFor more informations, visit our" +
                "\nwebsite www.bb-donation.com.\n\n Best regards.";
        message.setText(messageBody);
        emailSender.send(message);

    }
}