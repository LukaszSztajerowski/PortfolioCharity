package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.RoleService;
import pl.coderslab.charity.service.UserServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @GetMapping("/admin/admins")
//    @ResponseBody
    public String adminsList(Model model){
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        List<User> userByRolesIn = userRepository.findUserByRolesIn(Arrays.asList(adminRole));
        model.addAttribute("admins",userByRolesIn );
        return "admins";
    }

    @GetMapping("/admin/addadmin/{name}")
    public String addAdminRole(@PathVariable String name, Model model){
        User byUsername = userRepository.findByName(name);
        Set<Role> roles = byUsername.getRoles();
        roles.add(roleRepository.findByName("ROLE_ADMIN"));
        return "addInstitutionForm";
    }
}
