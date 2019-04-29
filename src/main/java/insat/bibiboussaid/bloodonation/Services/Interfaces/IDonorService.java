package insat.bibiboussaid.bloodonation.Services.Interfaces;

import insat.bibiboussaid.bloodonation.Domain.Donor;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IDonorService {
    public List<Donor> getAll();
    public void addDonor(Donor donor);
    public void deleteDonor(String id);
    public Optional<Donor> getDonorById(String id);
    public void updateDonor(Donor donor);
    public List<Donor> findDonorsByAdressAndBloodType(String bloodType, String address);
}
