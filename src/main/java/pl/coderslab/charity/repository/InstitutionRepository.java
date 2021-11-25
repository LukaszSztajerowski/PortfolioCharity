package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;

import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    public Institution findInstitutionById(Long id);
    public List<Institution> findInstitutionByActiveEquals(boolean active);


}
