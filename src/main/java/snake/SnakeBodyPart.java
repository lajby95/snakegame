package snake;

import lombok.Getter;

import java.util.Vector;

public class SnakeBodyPart {
    @Getter
    private int x;
    @Getter
    private int y;

    public SnakeBodyPart(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public SnakeBodyPart(SnakeBodyPart part) {
        set(part);
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void set(SnakeBodyPart part) {
        this.x = part.getX();
        this.y = part.getY();
    }

    public Boolean isCollidingWithOtherPart(SnakeBodyPart other){
        if(other.getX() == this.getX() && other.getY() == this.getY()) {
            return true;
        }
        return false;
    }
}
