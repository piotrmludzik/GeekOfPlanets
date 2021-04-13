package com.codecool.elgrande.user.jdbc.service;

import com.codecool.elgrande.user.jdbc.repository.AuthoritiesRepository;
import com.codecool.elgrande.user.model.user.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService{

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
    public void addNewAuthority(Authorities authorities) {
        authoritiesRepository.save(authorities);
    }

    @Override
    public void changeAuthority(String authority) {
        authoritiesRepository.changeAuthority(authority);
    }
}
