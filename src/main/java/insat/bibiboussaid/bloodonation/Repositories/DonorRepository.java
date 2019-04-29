package insat.bibiboussaid.bloodonation.Repositories;

import insat.bibiboussaid.bloodonation.Domain.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Observable;

@Repository
@CrossOrigin(origins = "http://localhost:4201")
public interface DonorRepository extends JpaRepository<Donor,String> {
    public List<Donor> findDonorsByAddressAndBloodtype(String bloodType, String address);

}
