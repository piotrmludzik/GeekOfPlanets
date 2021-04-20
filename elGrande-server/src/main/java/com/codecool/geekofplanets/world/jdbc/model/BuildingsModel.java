package com.codecool.geekofplanets.world.jdbc.model;

import com.codecool.geekofplanets.world.universe.objects.buildings.Buildings;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Component
@Setter
@Getter
@Entity
@Table(name="buildings")
public class BuildingsModel {
    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Autowired
    public BuildingsModel() {
    }

    public BuildingsModel(Buildings buildings) {
    }
}
