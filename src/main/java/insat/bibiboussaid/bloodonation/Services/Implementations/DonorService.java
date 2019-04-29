package insat.bibiboussaid.bloodonation.Services.Implementations;

import insat.bibiboussaid.bloodonation.Domain.Donor;
import insat.bibiboussaid.bloodonation.Repositories.DonorRepository;
import insat.bibiboussaid.bloodonation.Services.Interfaces.IDonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonorService implements IDonorService {

    @Autowired
    DonorRepository donorRepository;

    @Override
    public List<Donor> getAll() {
        return donorRepository.findAll();
    }

    @Override
    public void addDonor(Donor donor) {
        donorRepository.save(donor);
    }

    @Override
    public void deleteDonor(String id) {
        donorRepository.deleteById(id);
    }

    @Override
    public Optional<Donor> getDonorById(String id) {
        return donorRepository.findById(id);
    }

    @Override
    public void updateDonor(Donor donor) {
        donorRepository.save(donor);
    }

    @Override
    public List<Donor> findDonorsByAdressAndBloodType(String bloodType, String address) {
        return donorRepository.findDonorsByAddressAndBloodtype(bloodType,address);
    }
}
