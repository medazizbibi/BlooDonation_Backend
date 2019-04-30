package insat.bibiboussaid.bloodonation.Services.Interfaces;

import insat.bibiboussaid.bloodonation.Domain.DonationRequest;
import insat.bibiboussaid.bloodonation.Domain.Donor;

import java.util.List;
import java.util.Optional;

public interface IDonationRequestService {
    public List<DonationRequest> getAll();
    public void addRequest(DonationRequest request);
    public void deleteRequest(String id);
    public Optional<DonationRequest> getRequestById(String id);
    public List<DonationRequest> getDonationRequestsByDonorId(String id);
}
