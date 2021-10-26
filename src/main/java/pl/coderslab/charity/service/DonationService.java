package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationRepository donationRepository;

    public void createDonation(Donation donation) {
        donationRepository.save(donation);
    }

    public Optional<Donation> readDonation(Long id) {
        return donationRepository.findById(id);
    }

    public void updateDonation(Donation donation) {
        donationRepository.save(donation);
    }

    public void deleteDonation(Long id) {
        Optional<Donation> donationById = donationRepository.findById(id);
        if (donationById.isPresent()) {
            donationRepository.deleteById(id);
        }
    }

    public List<Donation> getDonations() {
        return donationRepository.findAll();
    }
    public Integer getBags(){
        List<Donation> allDonations = donationRepository.findAll();
        Integer sum=0;
        for (Donation donation: allDonations) {
            sum = sum + donation.getQuantity();
        }
        return sum;
    }


}
