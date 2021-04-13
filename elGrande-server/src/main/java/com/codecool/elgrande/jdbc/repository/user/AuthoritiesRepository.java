package com.codecool.elgrande.jdbc.repository.user;

import com.codecool.elgrande.model.user.Authorities;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends CrudRepository<Authorities, Integer> {

    @Modifying
    @Query("UPDATE Authorities a SET a.authority = ?1")
    void changeAuthority(String authority);
}
