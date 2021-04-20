package com.codecool.geekofplanets.user.jdbc.service;

import com.codecool.geekofplanets.user.jdbc.model.AuthoritiesModel;

import java.util.List;

public interface AuthoritiesService {

    List<AuthoritiesModel> findAllAuthorities();
    void addNewAuthority(AuthoritiesModel authorities);
    void changeAuthority(String authority);
}
