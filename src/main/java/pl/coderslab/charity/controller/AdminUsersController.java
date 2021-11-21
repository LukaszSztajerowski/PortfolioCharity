package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AdminUsersController {
    private final UserServiceImpl userServiceImpl;
    private final UserRepository userRepository;
    @GetMapping("/admin/usersList")
    public String usersList(){
        return "UsersList";
    }

    @GetMapping("/admin/editUser/{id}")
    public String editAdminForm(@PathVariable Long id, Model model){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            model.addAttribute("userToEdit", userRepository.findByName(user.get().getName()));
            return "editAdminForm";
        }
        return "UsersList";
    }

    @PostMapping("/admin/editUser")
    public String editAdmin(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return "UsersList";
        }
        userRepository.save(user);
        return "redirect:/admin/usersList";
    }

    @GetMapping("/admin/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            userRepository.delete(userRepository.findByName(user.get().getName()));
        return "redirect:/admin/usersList";
        }
        return "UsersList";
    }

    @ModelAttribute
    public void users(Model model){
        model.addAttribute("usersList",userServiceImpl.getUsers());
    }
}
