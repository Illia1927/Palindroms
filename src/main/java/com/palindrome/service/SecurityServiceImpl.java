package com.palindrome.service;

import com.palindrome.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityServiceImpl implements SecurityService {
    @Autowired
    private UserService userService;

    @Override
    public Optional<User> getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (null == auth) {
            return Optional.empty();
        }

        Object obj = auth.getPrincipal();
        String userEmail = "";

        if (obj instanceof UserDetails) {
            userEmail = ((UserDetails) obj).getUsername();
        } else {
            userEmail = obj.toString();
        }

        User u = userService.getByEmail(userEmail).orElseGet(User::new);
        return Optional.ofNullable(u);
    }
}
