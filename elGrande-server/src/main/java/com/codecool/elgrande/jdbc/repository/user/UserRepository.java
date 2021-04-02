package com.codecool.elgrande.jdbc.repository.user;

import com.codecool.elgrande.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
