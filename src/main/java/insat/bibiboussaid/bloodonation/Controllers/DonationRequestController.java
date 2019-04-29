package insat.bibiboussaid.bloodonation.Controllers;

import insat.bibiboussaid.bloodonation.Domain.DonationRequest;
import insat.bibiboussaid.bloodonation.Domain.Donor;
import insat.bibiboussaid.bloodonation.Services.Implementations.DonationRequestService;
import insat.bibiboussaid.bloodonation.Services.Implementations.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Request")
@CrossOrigin(origins = "http://localhost:4201")
public class DonationRequestController {

    @Autowired
    DonationRequestService requestService;

    //    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public List<DonationRequest> getAll(){
        return requestService.getAll();
    }

    @PostMapping
    public void addrequest(@RequestBody DonationRequest donationRequest){
        requestService.addRequest(donationRequest);
    }


    @GetMapping("/{id}")
    public Optional<DonationRequest> getRequestById(@PathVariable String id){
        return requestService.getRequestById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable String id){
        requestService.deleteRequest(id);
    }

}
