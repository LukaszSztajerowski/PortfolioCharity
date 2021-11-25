package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
import pl.coderslab.charity.service.UserServiceImpl;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final UserServiceImpl userServiceImpl;

    @GetMapping("/addDonation")
    public String dontationForm(Model model,Principal principal) {

        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/addDonation")
    public String addDonation(@Valid Donation donation, BindingResult result,@AuthenticationPrincipal UserDetails customUser) {
        if (result.hasErrors()) {
            return "index";
        }
        donation.setUser(userServiceImpl.findByUserEmail(customUser.getUsername()));
        donationService.createDonation(donation);
        return "form-confirmation";
    }

    @ModelAttribute
    public void categories(Model model){
        model.addAttribute("categories", categoryService.getCategories());

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

    @ModelAttribute
    public void principalUser(Model model, Principal principal){
        model.addAttribute("principalUser", userServiceImpl.findByUserEmail(principal.getName()));
    }

}
