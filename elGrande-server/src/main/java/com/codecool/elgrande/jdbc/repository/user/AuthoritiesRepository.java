package com.codecool.elgrande.jdbc.repository.user;

import com.codecool.elgrande.model.user.Authorities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends CrudRepository<Authorities, Integer> {
}
