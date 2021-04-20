package com.codecool.geekofplanets.world.universe;


import com.codecool.geekofplanets.world.universe.actors.Player;
import com.codecool.geekofplanets.world.universe.objects.Planet;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Field {
    private Player player;
    private Planet planet;
    private int x;
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
