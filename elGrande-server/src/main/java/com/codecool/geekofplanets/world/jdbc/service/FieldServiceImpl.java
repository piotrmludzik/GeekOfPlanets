package com.codecool.geekofplanets.world.jdbc.service;

import com.codecool.geekofplanets.world.jdbc.model.FieldModel;
import com.codecool.geekofplanets.world.jdbc.repository.FieldRepository;
import com.codecool.geekofplanets.world.universe.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldServiceImpl implements FieldService{

    private final FieldRepository fieldRepository;

    @Autowired
    public FieldServiceImpl(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    @Override
    public void addNewField(Field field) {
        FieldModel newField = new FieldModel(field);
        fieldRepository.save(newField);
    }
}
