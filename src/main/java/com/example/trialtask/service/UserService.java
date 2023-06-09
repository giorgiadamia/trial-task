package com.example.trialtask.service;

import com.example.trialtask.model.domain.Roles;
import com.example.trialtask.model.domain.User;
import com.example.trialtask.model.dto.UserDto;
import com.example.trialtask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User is not exist");
        }
        return user;
    }

    public void create(User user) {
        User userFromDb = userRepository.findByEmail(user.getEmail());
        if (userFromDb != null) {
            throw new EntityNotFoundException("User with this email is already exist");
        }

        user.setRoles(Collections.singleton(Roles.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void updateName(User user, UserDto userDto) {
        user.setName(userDto.getName());
        userRepository.save(user);
    }

    public UserDto showUser(User user) {
        return new UserDto(user.getName(), user.getEmail(), user.getQuotes());
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
