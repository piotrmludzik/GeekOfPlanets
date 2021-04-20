package com.codecool.geekofplanets.user.jdbc.repository;

import com.codecool.geekofplanets.user.jdbc.model.AuthoritiesModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends CrudRepository<AuthoritiesModel, Integer> {

    @Modifying
    @Query("UPDATE AuthoritiesModel a SET a.authority = ?1")
    void changeAuthority(String authority);
}
