package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByName(String name);
    User findByEmail(String email);
    List<User> findUserByRolesIn(List<Role> roles);
    List<User> findAll();
    List<User> findUsersByActiveEquals(boolean active);



}
