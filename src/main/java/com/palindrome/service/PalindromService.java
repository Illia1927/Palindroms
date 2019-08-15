package com.palindrome.service;

import com.palindrome.model.Palindromes;

import java.util.List;
import java.util.Optional;

public interface PalindromService {
    Optional<List<Palindromes>> getAll();

    Palindromes add(Palindromes user);

    Optional<Palindromes> getById(Long id);
}
