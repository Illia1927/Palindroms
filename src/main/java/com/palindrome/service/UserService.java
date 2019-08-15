package com.palindrome.service;

import com.palindrome.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    Optional<List<User>> getAll();

    User add(User user);

    Optional<User> getById(Long id);

    Optional<User> getByEmail(String userEmail);
}
