package insat.bibiboussaid.bloodonation.Controllers;

import insat.bibiboussaid.bloodonation.Domain.Donor;
import insat.bibiboussaid.bloodonation.Domain.JwtUser;
import insat.bibiboussaid.bloodonation.Repositories.DonationRepository;
import insat.bibiboussaid.bloodonation.Repositories.DonorRepository;
import insat.bibiboussaid.bloodonation.Repositories.JwtUserRepository;
import insat.bibiboussaid.bloodonation.Security.JwtGenerator;
import insat.bibiboussaid.bloodonation.Services.Implementations.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4201")
public class TokenController {

    @Autowired
    DonorService donorService;

    private JwtGenerator jwtGenerator;
    private JwtUserRepository jwtUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public TokenController(JwtGenerator jwtGenerator,
                           JwtUserRepository jwtUserRepository) {
        this.jwtGenerator = jwtGenerator;
        this.jwtUserRepository = jwtUserRepository;
    }

    @PostMapping("/signin")
    public String generate(@RequestBody final JwtUser jwtUser){
        return jwtGenerator.generate(jwtUser);
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody Donor donor) {
        donor.setPassword(bCryptPasswordEncoder.encode(donor.getPassword()));
        donorService.addDonor(donor);
    }

    @GetMapping
    public List<JwtUser> getList(){
        return jwtUserRepository.findAll();
    }
}