package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserServiceImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AdminInstitutionsController {
    private final InstitutionService institutionService;
    private final UserServiceImpl userService;
    private final InstitutionRepository institutionRepository;

    @GetMapping("/admin/institutions")
    public String institutionList(){
        return "institution";
    }

    @GetMapping("/admin/addInstitution")
    public String institiutionAddForm(Model model){
        model.addAttribute("institution", new Institution());
        return "addInstitutionForm";
    }

    @PostMapping("/admin/addInstitution")
    public String addInstitution(@Valid Institution institution, BindingResult result){
        if(result.hasErrors()){
        return "institution";
        }
        institution.setActive(true);
        institutionService.createInstitution(institution);
        return "redirect:/admin/institutions";
    }

    @GetMapping("/admin/editInstitution/{id}")
    public String editInstitutionForm(@PathVariable Long id, Model model){
        Optional<Institution> institutionOptionalById = institutionService.readInstitution(id);
        Institution institutionToEdit = institutionOptionalById.get();
        if(institutionOptionalById.isPresent()){
            model.addAttribute("institutionToEdit",institutionToEdit);
        return "editInstitutionForm";
        }
        return "institution";
    }

    @PostMapping("/admin/editInstitution")
    public String editInstitution(@Valid Institution institution, BindingResult result){
        if(result.hasErrors()) {
            return "institution";
        }
        institutionService.updateInstitution(institution);
        return "redirect:/admin/institutions";
    }

    @GetMapping("/admin/deleteInstitution/{id}")
    public String deleteInstitutionForm(@PathVariable Long id){
        Optional<Institution> institutionByid = institutionService.readInstitution(id);
        Institution institution = institutionByid.get();
        if(institutionByid.isPresent()){
        institution.setActive(false);
        institutionService.createInstitution(institution);
            return "redirect:/admin/institutions";
        }
        return "institution";
    }

    @ModelAttribute
    public void principalUser(Model model, Principal principal){
        model.addAttribute("principalUser", userService.findByUsername(principal.getName()));
    }

    @ModelAttribute
    public void institutions(Model model){
        model.addAttribute("institutions", institutionService.getInstitutions());
    }

}
