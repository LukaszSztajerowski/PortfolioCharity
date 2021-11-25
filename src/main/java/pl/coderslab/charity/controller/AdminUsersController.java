package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.RoleService;
import pl.coderslab.charity.service.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AdminUsersController {
    private final UserServiceImpl userServiceImpl;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @GetMapping("/admin/usersList")
    public String usersList(){
        return "usersList";
    }

    @GetMapping("/admin/admin/addAdmin/{name}")
    public String addAdmin(@PathVariable String name){
        User user = userServiceImpl.findByUsername(name);
        Role roleAdmin = roleRepository.findByName("ROLE_ADMIN");
        user.getRoles().add(roleAdmin);
        userServiceImpl.updateUser(user);
        return "redirect:/admin/usersList";
    }

    @GetMapping("/admin/editUser/{id}")
    public String editAdminForm(@PathVariable Long id, Model model){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User userToEdit = user.get();
            model.addAttribute("userToEdit", userToEdit);
            return "editAdminForm";
        }
        return "usersList";
    }

    @PostMapping("/admin/editUser")
    public String editAdmin(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return "usersList";
        }
        userRepository.save(user);
        return "redirect:/admin/usersList";
    }

    @GetMapping("/admin/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            User userToDeactivate = user.get();
            userToDeactivate.setActive(false);
            userServiceImpl.updateUser(userToDeactivate);
        return "redirect:/admin/usersList";
        }
        return "usersList";
    }

    @ModelAttribute
    public void users(Model model){

        model.addAttribute("usersList",userServiceImpl.getUsers());
    }
}
