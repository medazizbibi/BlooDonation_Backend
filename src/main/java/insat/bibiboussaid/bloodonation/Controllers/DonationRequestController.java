package insat.bibiboussaid.bloodonation.Controllers;

import insat.bibiboussaid.bloodonation.Domain.Donation;
import insat.bibiboussaid.bloodonation.Domain.DonationRequest;
import insat.bibiboussaid.bloodonation.Domain.Donor;
import insat.bibiboussaid.bloodonation.Domain.Models.EmailBody;
import insat.bibiboussaid.bloodonation.Domain.Models.Request;
import insat.bibiboussaid.bloodonation.Domain.Models.RequestToDonationModel;
import insat.bibiboussaid.bloodonation.Services.Implementations.DonationRequestService;
import insat.bibiboussaid.bloodonation.Services.Implementations.DonationService;
import insat.bibiboussaid.bloodonation.Services.Implementations.DonorService;
import insat.bibiboussaid.bloodonation.Services.Implementations.EmailService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Request")
@CrossOrigin(origins = "http://localhost:4201")
public class DonationRequestController {

    @Autowired
    DonationRequestService requestService;

    @Autowired
    DonorService donorService;

    @Autowired
    DonationService donationService;

    @Autowired
    EmailService emailService;

    //    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public List<DonationRequest> getAll(){
        return requestService.getAll();
    }

    @PostMapping
    public void addrequest(@RequestBody Request request){

        Donor donor= donorService.getDonorById(request.getPersonId()).get();

        DonationRequest donationRequest=new DonationRequest();
        donationRequest.setBloodType(request.getBloodType());
        donationRequest.setFirstName(request.getFirstName());
        donationRequest.setLastName(request.getLastName());
        donationRequest.setMedicalCenter(request.getMedicalCenter());
        donationRequest.setDonationRequestId(request.getDonationRequestId());

        List<Donor> donors= new ArrayList<>();
        donors.add(donor);
        donationRequest.setDonors(donors);
        requestService.addRequest(donationRequest);
    }

    @PostMapping("/donation")
    public void fromRequestToDonation(@RequestBody RequestToDonationModel requestToDonationModel){

        Donation donation= new Donation();
        Donor donor = donorService.getDonorById(requestToDonationModel.getPersonId()).get();
        DonationRequest donationRequest= requestService.getRequestById(requestToDonationModel.getDonationRequestId()).get();


        donation.setBloodType(donationRequest.getBloodType());
        donation.setFirstName(donationRequest.getFirstName());
        donation.setLastName(donationRequest.getLastName());
        donation.setMedicalCenter(donationRequest.getMedicalCenter());
        donation.setPersonDonor(donor);
        donation.setPhoneNumber(donationRequest.getPhoneNumber());
        donation.setDonationDate("");
        String generatedString = RandomString.make(6);
        donation.setDonationId(generatedString);
        donationService.addDonation(donation);
    }


    @GetMapping("/{id}")
    public Optional<DonationRequest> getRequestById(@PathVariable String id){
        return requestService.getRequestById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable String id){
        requestService.deleteRequest(id);
    }



    @PostMapping("/sendEmail")
    public void deleteRequest(@RequestBody EmailBody body){
    emailService.sendSimpleMessage(body);

    }

}
