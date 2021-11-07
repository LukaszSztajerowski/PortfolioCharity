package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    @GetMapping("/addDonation")
    public String dontationForm(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("institutions", institutionService.getInstitutions());
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/addDonation")
    public String addDonation(@Valid Donation donation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index";
        }
        donationService.createDonation(donation);
        return "index";
    }

    @ModelAttribute
    public void institutions(Model model) {
        model.addAttribute("institutions", institutionService.getInstitutions());
    }

    @ModelAttribute
    public void bags(Model model) {
        model.addAttribute("bags", donationService.getBags());
    }

    @ModelAttribute
    public void numberOfDonations(Model model) {
        model.addAttribute("numberOfDonations", donationService.getDonations().size());
    }


}
