package com.palindrome.service;

import com.palindrome.model.User;

import java.util.Optional;

public interface SecurityService {
    Optional<User> getCurrentUser();
}
