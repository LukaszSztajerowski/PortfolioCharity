package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.RoleService;
import pl.coderslab.charity.service.UserServiceImpl;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class AdminAdminsController {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @GetMapping("/admin/adminList")
//    @ResponseBody
    public String adminsList(Model model){
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        List<User> userByRolesIn = userRepository.findUserByRolesIn(Arrays.asList(adminRole));
        model.addAttribute("adminsList",userByRolesIn );
        return "adminList";
    }

    @GetMapping("/admin/addAdmin/{name}")
    public String addAdminRole(@PathVariable String name){
        User user = userRepository.findByName(name);
        user.getRoles().add(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
        return "redirect:/admin/adminList";
    }

    @GetMapping("/admin/editAdmin/{id}")
    public String editAdminForm(@PathVariable Long id, Model model){
        Optional<User> admin = userRepository.findById(id);
        if(admin.isPresent()){
            model.addAttribute("adminToEdit", userRepository.findByName(admin.get().getName()));
        return "editAdminForm";
        }
        return "adminList";
    }

    @PostMapping("/admin/editAdmin")
    public String editAdmin(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return "adminList";
        }
        userRepository.save(user);
        return "redirect:/admin/adminList";
    }

    @GetMapping("/admin/deleteAdminRole/{id}")
    public String deleteAdminRole(@PathVariable Long id){
        Optional<User> byId = userRepository.findById(id);
        if(byId.isPresent()){
            User user = userRepository.findByName(byId.get().getName());
            user.getRoles().stream().filter(x->x.getName().equals("ROLE_USER")).collect(Collectors.toSet());
            userRepository.save(user);
            return "redirect:/admin/adminList";
        }
        return "adminList";
    }

}
