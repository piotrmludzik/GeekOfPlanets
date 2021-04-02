package com.codecool.elgrande.service;

import com.codecool.elgrande.model.Authorities;

import java.util.List;

public interface AuthoritiesService {

    List<Authorities> findAllAuthorities();
    Authorities getAuthorityById(int id);
    void deleteAuthorityById(int id);
    void addNewAuthority(Authorities authority);
}
