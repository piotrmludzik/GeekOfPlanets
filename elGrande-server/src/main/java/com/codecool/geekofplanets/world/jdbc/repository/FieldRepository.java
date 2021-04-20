package com.codecool.geekofplanets.world.jdbc.repository;

import com.codecool.geekofplanets.world.jdbc.model.FieldModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends CrudRepository<FieldModel, Integer> {
}
