package insat.bibiboussaid.bloodonation.Services.Implementations;

import insat.bibiboussaid.bloodonation.Domain.DonationRequest;
import insat.bibiboussaid.bloodonation.Domain.Donor;
import insat.bibiboussaid.bloodonation.Repositories.DonationRequestRepository;
import insat.bibiboussaid.bloodonation.Repositories.DonorRepository;
import insat.bibiboussaid.bloodonation.Services.Interfaces.IDonationRequestService;
import insat.bibiboussaid.bloodonation.Services.Interfaces.IDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationRequestService implements IDonationRequestService {

    @Autowired
    DonationRequestRepository requestRepository;

    @Override
    public List<DonationRequest> getAll() {
        return requestRepository.findAll();
    }

    @Override
    public void addRequest(DonationRequest request) {
        requestRepository.save(request);
    }

    @Override
    public void deleteRequest(String id) {
        requestRepository.deleteById(id);
    }

    @Override
    public Optional<DonationRequest> getRequestById(String id) {
        return requestRepository.findById(id);
    }

}
