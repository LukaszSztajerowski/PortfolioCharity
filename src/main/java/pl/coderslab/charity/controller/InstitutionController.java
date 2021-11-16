package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserServiceImpl;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class InstitutionController {
    private final InstitutionService institutionService;
    private final UserServiceImpl userService;

    @GetMapping("/admin/institutions")
    public String institutionList(){
        return "institutions";
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
        institutionService.createInstitution(institution);
        return "institution";
    }

    @GetMapping("/admin/editInstitution/{id}")
    public String editInstitutionForm(@PathVariable Long id, Model model){
        Optional<Institution> institutionByid = institutionService.readInstitution(id);
        if(institutionByid.isPresent()){
            model.addAttribute("institutionToEdit",institutionByid);
        return "editInstitutionForm";
        }
        return "institution";
    }

    @PutMapping("/admin/editInstitution/{id}")
    public String editInstitution(@Valid Institution institution, BindingResult result){
        institutionService.updateInstitution(institution);
        return "institution";
    }

    @DeleteMapping("/admin/deleteInstitution/{id}")
    public String deleteInstitutionForm(@PathVariable Long id, Model model){
        Optional<Institution> institutionByid = institutionService.readInstitution(id);
        if(institutionByid.isPresent()){
            institutionService.deleteInstitution(id);
            return "institution";
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
