package com.codecool.elgrande.service;

import com.codecool.elgrande.model.Authorities;
import com.codecool.elgrande.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

    private final AuthoritiesRepository authoritiesRepository;

    @Autowired
    public AuthoritiesServiceImpl(AuthoritiesRepository authoritiesRepository) {
        this.authoritiesRepository = authoritiesRepository;
    }

    @Override
    public List<Authorities> findAllAuthorities() {
        return (List<Authorities>) authoritiesRepository.findAll();
    }

    @Override
    public Authorities getAuthorityById(int id) {
        Optional<Authorities> opt = authoritiesRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public void deleteAuthorityById(int id) {
        authoritiesRepository.deleteById(id);
    }

    @Override
    public void addNewAuthority(Authorities authority) {
        authoritiesRepository.save(authority);
    }
}
