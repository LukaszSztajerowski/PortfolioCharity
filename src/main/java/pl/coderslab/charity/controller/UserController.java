package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

@GetMapping("/register")
    public String registerForm(Model model){
    model.addAttribute("user", new User());
    return "registerForm";
}

@PostMapping("/register")
    public String register(@Valid User user, BindingResult result){
    if(result.hasErrors()){
        return "index";
    }
    userService.createUser(user);
    return "index";
}
}
