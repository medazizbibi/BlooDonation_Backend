package insat.bibiboussaid.bloodonation.Services.Interfaces;

import insat.bibiboussaid.bloodonation.Domain.Donation;

import java.util.List;
import java.util.Optional;

public interface IDonationService {
    public List<Donation> getAll();
    public void addDonation(Donation donation);
    public void deleteDonation(String id);
    public Optional<Donation> getDonationById(String id);
    public void updateDonation(Donation donation);
}
