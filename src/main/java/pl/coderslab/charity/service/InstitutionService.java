package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstitutionService {
    private final InstitutionRepository institutionRepository;

    public void createInstitution(Institution institution) {
        institutionRepository.save(institution);
    }

    public Optional<Institution> readInstitution(Long id) {
        return institutionRepository.findById(id);
    }

    public void updateInstitution(Institution institution) {
        institutionRepository.save(institution);
    }

    public void deleteInstitution(Long id) {
        Optional<Institution> institutionById = institutionRepository.findById(id);
        if (institutionById.isPresent()) {
            institutionRepository.deleteById(id);
        }
    }

    public List<Institution> getInstitutions() {
        return institutionRepository.findAll();
    }
}


