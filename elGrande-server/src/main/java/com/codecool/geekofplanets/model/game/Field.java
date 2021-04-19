package com.codecool.geekofplanets.model.game;

import com.codecool.elgrande.model.game.actors.Player;
import com.codecool.elgrande.model.game.objects.Planet;
import com.codecool.geekofplanets.model.game.actors.Player;
import com.codecool.geekofplanets.model.game.objects.Planet;
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
public class Field {
    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="org.hibernate.id.UUIDGenerator")
    private UUID id;

    private transient Player player;
    private transient Planet planet;

    @Column(name="pos_x")
    private int x;

    @Column(name="pos_y")
    private int y;

    @Autowired
    public Field() {}

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void clearField(){
        this.player = null;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Field
                && ((Field) obj).x == this.x
                && ((Field) obj).y == this.y;
    }

    @Override
    public String toString() {
        return String.format("Coordinates[x=%d, y=%d]", x, y);
    }
}
