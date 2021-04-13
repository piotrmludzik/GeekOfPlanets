package com.codecool.elgrande.user.jdbc.service;

import com.codecool.elgrande.user.model.user.Authorities;

import java.util.List;

public interface AuthoritiesService {

    List<Authorities> findAllAuthorities();
    void addNewAuthority(Authorities authorities);
    void changeAuthority(String authority);
}
