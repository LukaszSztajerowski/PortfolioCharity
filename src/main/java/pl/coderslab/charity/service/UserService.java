package pl.coderslab.charity.service;

import pl.coderslab.charity.model.User;

public interface UserService {

    User findByUsername(String name);
    User findByUserEmail(String email);
    void createUser(User user);

}
