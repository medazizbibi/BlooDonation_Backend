package insat.bibiboussaid.bloodonation.Services.Implementations;

import insat.bibiboussaid.bloodonation.Domain.Donation;
import insat.bibiboussaid.bloodonation.Repositories.DonationRepository;
import insat.bibiboussaid.bloodonation.Services.Interfaces.IDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationService implements IDonationService {

    @Autowired
    DonationRepository donationRepository;

    @Override
    public List<Donation> getAll() {
        return donationRepository.findAll();
    }

    @Override
    public void addDonation(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public void deleteDonation(String id) {
        donationRepository.deleteById(id);
    }

    @Override
    public Optional<Donation> getDonationById(String id) {
        return donationRepository.findById(id);
    }

    @Override
    public void updateDonation(Donation donation) {
        donationRepository.save(donation);
    }
}
