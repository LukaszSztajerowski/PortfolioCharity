package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.persistence.GeneratedValue;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

@GetMapping("/addDonation")
    public String dontationForm(Model model){
        model.addAttribute("categories",categoryService.getCategories());
        model.addAttribute("institutions", institutionService.getInstitutions());
        model.addAttribute("donation", new Donation());
        return "donationForm";
    }

    @PostMapping("/addDonation")
    public String addDonation(@Valid Donation donation, BindingResult result, Model model){
    if (result.hasErrors()){
        return "index";
    }
    donationService.createDonation(donation);
    List<Institution> institutions = institutionService.getInstitutions();
        Integer bags = donationService.getBags();
        int numberOfDonations = donationService.getDonations().size();
        model.addAttribute("institutions", institutions);
        model.addAttribute("bags", bags);
        model.addAttribute("numberOfDonations", numberOfDonations);
        return "index";

    }


}
