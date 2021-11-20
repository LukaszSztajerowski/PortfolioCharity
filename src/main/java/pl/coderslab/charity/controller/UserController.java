package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.apache.jasper.tagplugins.jstl.core.When;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserServiceImpl;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Set;

@Controller
@RequiredArgsConstructor

public class UserController {
    private final UserServiceImpl userServiceImpl;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping("/register")
    public String register(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "registerForm";
        }
        userServiceImpl.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }


    @GetMapping("/admincheck")
    public String admincheck(Principal principal){
        User user = userServiceImpl.findByUserEmail(principal.getName());
        if(userServiceImpl.haveRole(user)){
            return "redirect:/admin";
        }else {
            return "redirect:/";
        }
    }

}
