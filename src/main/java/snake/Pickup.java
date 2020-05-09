package snake;

import javafx.geometry.Point2D;
import lombok.Getter;

import java.awt.*;

public class Pickup {

    @Getter
    private Point pos;

    @Getter
    private String type;

    public Pickup(Point p, String type){
        this.pos = p;
        this.type = type;
    }
    public Pickup(Pickup other){
        this.pos = other.getPos();
        this.type = other.getType();
    }

}
