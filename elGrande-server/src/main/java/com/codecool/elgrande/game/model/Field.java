package com.codecool.elgrande.game.model;

import com.codecool.elgrande.game.model.actors.Player;
import com.codecool.elgrande.game.model.objects.Planet;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Getter
@Setter
@Entity
@Table(name="field")
public class Field {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

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

    public void clearCell(){
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
