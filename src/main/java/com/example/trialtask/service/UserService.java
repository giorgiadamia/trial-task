package com.example.trialtask.service;

import com.example.trialtask.model.domain.User;
import com.example.trialtask.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean create(User user) {
        boolean userFromDb = userRepository.findByEmail(user.getEmail());
        if (userFromDb) {
            return false;
        }
        userRepository.save(user);
        return true;
    }
}
