package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        model.addAttribute("institutions", institutionService.getInstitutions());
        model.addAttribute("bags", donationService.getBags());
        model.addAttribute("numberOfDonations", donationService.getDonations().size());
        return "index";
    }

    @ModelAttribute
    public List<Institution> institutions(){
        return institutionService.getInstitutions();
    }

    @ModelAttribute
    public Integer bags(){
        return  donationService.getBags();
    }

    @ModelAttribute
    public Integer numberOfDonations(){
        return donationService.getDonations().size();
    }

}
