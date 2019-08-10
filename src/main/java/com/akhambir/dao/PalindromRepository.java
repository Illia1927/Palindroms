package com.akhambir.dao;

import com.akhambir.model.Palindromes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PalindromRepository extends JpaRepository<Palindromes, Long> {

    List<Palindromes> findAll();
}
