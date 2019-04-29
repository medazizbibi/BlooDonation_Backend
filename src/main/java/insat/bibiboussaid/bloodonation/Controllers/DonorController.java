package insat.bibiboussaid.bloodonation.Controllers;

import insat.bibiboussaid.bloodonation.Domain.Donor;
import insat.bibiboussaid.bloodonation.Services.Implementations.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Donor")
@CrossOrigin(origins = "http://localhost:4201")
public class DonorController {

    @Autowired
    DonorService donorService;


    //    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public List<Donor> getAll(){
        return donorService.getAll();
    }

    @PostMapping
    public void addDonor(@RequestBody Donor donor){
        donorService.addDonor(donor);
    }

    @PutMapping("/donorSpace/{id}")
    public void updateDonor(@PathVariable int id, @RequestBody Donor donor){
        donorService.updateDonor(donor);
    }

    @GetMapping("/{id}")
    public Optional<Donor> getSubscriberById(@PathVariable String id){
        return donorService.getDonorById(id);
    }

    @DeleteMapping("/donorSpace/{id}")
    public @ResponseBody void deleteDonor(@PathVariable String id){
        donorService.deleteDonor(id);
    }

    @GetMapping("/{bloodType}/{address}")
    public List<Donor> getByAddressAndBlood(@PathVariable String address, @PathVariable String bloodType){
        return donorService.findDonorsByAdressAndBloodType(address,bloodType);
    }

}
