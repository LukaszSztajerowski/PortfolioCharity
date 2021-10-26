package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class HomeController {
    private final InstitutionService institutionService;
    private final DonationService donationService;



    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutions = institutionService.getInstitutions();
        Integer bags = donationService.getBags();
        int numberOfDonations = donationService.getDonations().size();
        model.addAttribute("institutions", institutions);
        model.addAttribute("bags", bags);
        model.addAttribute("numberOfDonations", numberOfDonations);
        return "index";
    }
}
