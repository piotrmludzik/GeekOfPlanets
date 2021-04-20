package com.codecool.geekofplanets.user.jdbc.service;

import com.codecool.geekofplanets.user.jdbc.model.AuthoritiesModel;
import com.codecool.geekofplanets.user.jdbc.repository.AuthoritiesRepository;
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
    public List<AuthoritiesModel> findAllAuthorities() {
        return (List<AuthoritiesModel>) authoritiesRepository.findAll();
    }

    @Override
    public void addNewAuthority(AuthoritiesModel authorities) {
        authoritiesRepository.save(authorities);
    }

    @Override
    public void changeAuthority(String authority) {
        authoritiesRepository.changeAuthority(authority);
    }
}
