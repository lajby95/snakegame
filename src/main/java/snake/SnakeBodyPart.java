package snake;

import javafx.geometry.Point2D;
import lombok.Getter;

import java.awt.*;
import java.util.Vector;

public class SnakeBodyPart {
    @Getter
    private Point pos;

    public SnakeBodyPart(Point p) {
        this.pos = p;
    }
    public SnakeBodyPart(SnakeBodyPart part) {
        set(part);
    }

    public void set(Point p) {
        this.pos = p;
    }
    public void set(int x, int y) {
        this.pos = new Point(x,y);
    }
    public void set(SnakeBodyPart part) {
        this.pos = part.getPos();
    }

    public Boolean equals(SnakeBodyPart other){
        if(other.getPos().getX() == this.getPos().getX() && other.getPos().getY() == this.getPos().getY()) {
            return true;
        }
        return false;
    }

    public Boolean equals(Pickup other){
        return this.getPos().x == other.getPos().x && this.getPos().y == other.getPos().y;
    }
}
