package org.example.Spring_Boot_3_1_1.service;

import org.example.Spring_Boot_3_1_1.model.User;
import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getAllUsers();
    void delete(Long id);
    void update(User user);

}