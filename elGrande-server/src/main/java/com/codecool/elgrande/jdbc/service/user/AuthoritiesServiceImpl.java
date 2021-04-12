package com.codecool.elgrande.jdbc.service.user;

import com.codecool.elgrande.jdbc.repository.user.AuthoritiesRepository;
import com.codecool.elgrande.model.user.Authorities;
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
}
