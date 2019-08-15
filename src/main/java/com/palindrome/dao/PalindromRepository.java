package com.palindrome.dao;

import com.palindrome.model.Palindromes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PalindromRepository extends JpaRepository<Palindromes, Long> {

    List<Palindromes> findAll();
}
