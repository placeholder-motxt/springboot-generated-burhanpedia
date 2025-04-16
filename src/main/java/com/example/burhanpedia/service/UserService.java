package com.example.burhanpedia.service;

import com.example.burhanpedia.model.User;
import com.example.burhanpedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Create user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get user by id
    public User getUser(String id) {
        return userRepository.findById(id).orElse(null);  // Returning null if not found
    }

    // Update user by id
    public User updateUser(User user, String id) {
        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser != null) {
            // Update the user's information (except the id)
            existingUser.setUsername(user.getUsername());
            // Save the updated user
            return userRepository.save(existingUser);
        } else {
            // Handle user not found
            throw new RuntimeException("User not found for id: " + id);
        }
    }

    @Transactional
    public void deleteUser(String id) {
        userRepository.deleteById(id);  // Delete user by id (UUID as String)
    }
}
