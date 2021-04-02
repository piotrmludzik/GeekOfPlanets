package com.codecool.elgrande.jdbc.service.user;

import com.codecool.elgrande.model.user.Authorities;

import java.util.List;

public interface AuthoritiesService {

    List<Authorities> findAllAuthorities();
    Authorities getAuthorityById(int id);
    void deleteAuthorityById(int id);
    void addNewAuthority(Authorities authority);
}
