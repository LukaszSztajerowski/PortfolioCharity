package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUsername(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User findByUserEmail(String email){
        return userRepository.findByEmail(email);
    }
    @Override
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (roleRepository.findByName("ROLE_USER") == null) {
            user.getRoles().add(new Role("ROLE_USER"));
        } else {
            user.getRoles().add(roleRepository.findByName("ROLE_USER"));
        }
        userRepository.save(user);
    }

    public Optional<User> readUser(Long id) {
        return userRepository.findById(id);
    }

    public void updateUser(User userToUpdate) {
        userRepository.save(userToUpdate);
    }

    public void deleteUser(Long id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            userRepository.deleteById(id);
        }
    }

    public List<User> getUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

}
