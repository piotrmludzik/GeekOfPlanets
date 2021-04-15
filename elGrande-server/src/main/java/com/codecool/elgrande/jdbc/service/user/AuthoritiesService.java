package com.codecool.elgrande.jdbc.service.user;

import com.codecool.elgrande.model.user.Authorities;

import java.util.List;

public interface AuthoritiesService {

    List<Authorities> findAllAuthorities();
    void addNewAuthority(Authorities authorities);
    void changeAuthority(String authority);
}
