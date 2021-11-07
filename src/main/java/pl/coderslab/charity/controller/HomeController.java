package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;


@Controller
@RequiredArgsConstructor
public class HomeController {
    private final InstitutionService institutionService;
    private final DonationService donationService;



    @RequestMapping("/")
    public String homeAction() {
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
