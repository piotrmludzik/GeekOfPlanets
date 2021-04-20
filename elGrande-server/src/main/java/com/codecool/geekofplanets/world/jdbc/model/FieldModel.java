package com.codecool.geekofplanets.world.jdbc.model;

import com.codecool.geekofplanets.world.universe.Field;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.UUID;

@Component
@Getter
@Setter
@Entity
@Table(name="field")
public class FieldModel {
    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name="pos_x")
    private int x;

    @Column(name="pos_y")
    private int y;

    @Autowired
    public FieldModel() {
    }

    public FieldModel(Field field) {
        this.x = field.getX();
        this.y = field.getY();
    }

    public FieldModel(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
