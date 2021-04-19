package com.codecool.geekofplanets.user.jdbc.service;

import com.codecool.geekofplanets.user.model.Authorities;

import java.util.List;

public interface AuthoritiesService {

    List<Authorities> findAllAuthorities();
    void addNewAuthority(Authorities authorities);
    void changeAuthority(String authority);
}
