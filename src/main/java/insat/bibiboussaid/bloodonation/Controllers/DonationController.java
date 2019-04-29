package insat.bibiboussaid.bloodonation.Controllers;

import insat.bibiboussaid.bloodonation.Domain.Donation;
import insat.bibiboussaid.bloodonation.Services.Implementations.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Donation")
@CrossOrigin(origins = "http://localhost:4201")
public class DonationController {

    @Autowired
    DonationService donationService;


    //    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public List<Donation> getAll(){
        return donationService.getAll();
    }

    @PostMapping
    public void addDonation(@RequestBody Donation donation){
        donationService.addDonation(donation);
    }

    @PutMapping("/{id}")
    public void updateDonation(@PathVariable int id, @RequestBody Donation donation){
        donationService.updateDonation(donation);
    }

    @GetMapping("/{id}")
    public Optional<Donation> getDonationById(@PathVariable String id){
        return donationService.getDonationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDonation(@PathVariable String id){
        donationService.deleteDonation(id);
    }

}
