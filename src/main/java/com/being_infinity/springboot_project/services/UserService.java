package com.being_infinity.springboot_project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.being_infinity.springboot_project.models.User;

@Service
public class UserService {
    private final List<User> allUsers;

    private int currId = 3;
    public UserService() {
        allUsers = new ArrayList<>();
        allUsers.add(new User(1, "John Doe", "Male", "/images/john.png"));
        allUsers.add(new User(2, "Jane Smith", "Female", "/images/jane.png"));
    }

    public UserService(List<User> allUsers) {
        this.allUsers = allUsers;
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public User getUserById(int id) {
        for (User user : allUsers) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null; // Return null if user not found
    }

    public User addNewUser(User user) {
        user.setId(currId++);
        allUsers.add(user);
        return user;
    }

    public User updateUser(int id, User updatedUser) {
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getId() == id) {
                updatedUser.setId(id); // Ensure the ID remains unchanged
                allUsers.set(i, updatedUser);
                return updatedUser;
            }
        }
        return null; // Return null if user not found
    }

    public void deleteUser(int id) {
        allUsers.removeIf(user -> user.getId() == id);
    }

}