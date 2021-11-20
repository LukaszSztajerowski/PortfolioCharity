package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation,Long> {
    public List<Donation> findDonationsByInstitution(Institution institution);
    public void deleteDonationsByInstitutionId(Long institutionId);
}
