package com.akhambir.service;

import com.akhambir.dao.PalindromRepository;
import com.akhambir.model.Palindromes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PalindromServiceImpl implements PalindromService {

    @Autowired
    private PalindromRepository palindromRepository;

    @Override
    public Optional<List<Palindromes>> getAll() {
        return Optional.of(palindromRepository.findAll());
    }

    @Override
    public Palindromes add(Palindromes user) {
        return palindromRepository.save(user);
    }

    @Override
    public Optional<Palindromes> getById(Long id) {
        return palindromRepository.findById(id);
    }
}
