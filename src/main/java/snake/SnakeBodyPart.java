package snake;

import javafx.geometry.Point2D;
import lombok.Getter;

import java.awt.*;
import java.util.Vector;

/**
 * Class representing one body part (or "tile") of the snake.
 */
public class SnakeBodyPart {

    /**
     * Point representing the position of the body part.
     */
    @Getter
    private Point pos;

    /**
     * Constructor that takes position as parameter.
     *
     * @param p Point(int x, int y)
     */
    public SnakeBodyPart(Point p) {
        this.pos = p;
    }

    /**
     * Constructor that takes SnakeBodyPart as parameter.
     *
     * @param part SnakeBodyPart
     */
    public SnakeBodyPart(SnakeBodyPart part) {
        set(part);
    }

    /**
     * Set point by Point object.
     *
     * @param p Point
     */
    public void set(Point p) {
        this.pos = p;
    }

    /**
     * Set point by x and y coordinates.
     *
     * @param x position
     * @param y position
     */
    public void set(int x, int y) {
        this.pos = new Point(x,y);
    }

    /**
     * Set part from other SnakeBodyPart object.
     *
     * @param part SnakeBodyPart
     */
    public void set(SnakeBodyPart part) {
        this.pos = part.getPos();
    }

    /**
     * Compares position to other SnakeBodyPart.
     *
     * @param other SnakeBodyPart
     * @return {@code true} if other part's X and Y coordinates match with X and Y of this, {@code false} otherwise.
     */
    public Boolean equals(SnakeBodyPart other){
        if(other.getPos().getX() == this.getPos().getX() && other.getPos().getY() == this.getPos().getY()) {
            return true;
        }
        return false;
    }

    /**
     * Compares position to pickup's position.
     *
     * @param other Pickup
     * @return {@code true} if pickup's X and Y coordinates match with X and Y of this bodypart, {@code false} otherwise.
     */
    public Boolean equals(Pickup other){
        return this.getPos().x == other.getPos().x && this.getPos().y == other.getPos().y;
    }
}
