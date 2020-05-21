package snake;

import javafx.geometry.Point2D;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.Vector;

/**
 * Class representing Snake's body.
 */
@Slf4j
public class SnakeBody {

    /**
     * Is snake Placed?
     */
    private Boolean snakePlaced = false;

    /**
     * Vector of SnakeBodyParts.
     */
    @Getter
    private Vector<SnakeBodyPart> body = new Vector<SnakeBodyPart>();

    public SnakeBody(){

    }

    /**
     * Adds a body part to the same position as the snake body's tail, only if snake is placed.
     */
    public void extend(){
        if(!snakePlaced) {
            log.error("Snake is not placed yet, can't extend!");
            return;
        }
        if(getBody().size() == 0) {
            return;
        }
        SnakeBodyPart tail = new SnakeBodyPart(getBody().lastElement());
        body.add(tail);
        log.info("Snake extended, new size is {}", body.size());
    }

    /**
     * If Snake's length is more than 1, Snake's last body part is removed (only if snake is placed).
     */
    public void shrink(){
        if(!snakePlaced) {
            log.error("Snake is not placed yet, can't extend!");
            return;
        }
        if(body.size() <= 1) {
            return;
        }
        body.remove(body.lastElement());
    }

    /**
     * Places Snake body at X and Y position of map, with 1 bodypart.
     *
     * @param x position
     * @param y position
     */
    public void place(int x, int y){
        if(snakePlaced) {
            log.error("Snake is already placed!");
            return;
        }
        SnakeBodyPart newTail = new SnakeBodyPart(new Point(x,y));
        body.add(newTail);
        snakePlaced = true;
        log.info("Snake placed to ({},{})", x, y);
    }

    /**
     * Returns element of index i from Vector of body parts.
     *
     * @param i index of body part
     * @return element of body
     */
    public SnakeBodyPart get(int i){
        return body.get(i);
    }

    /**
     * Returns last element of snake body.
     *
     * @return SnakeBodyPart, last element of body
     */
    public SnakeBodyPart getLast(){
        return body.lastElement();
    }

    /**
     * Returns if head's position is the same as any other body part.
     *
     * @return {@code true} if position of first body part is the same as any other body part, {@code false} otherwise
     */
    public Boolean isHeadCollidingWithBody(){
        Boolean collides = false;

        for (int i = 1; i < size(); i++) {
            if(this.get(i).equals(this.get(0))) {
                collides = true;
                break;
            }
        }

        return collides;
    }

    /**
     * Sets snake length.
     *
     * If Snake's length is lower than given parameter, Snake is extended until its length matches parameter.
     *
     * If Snake's length is higher than given parameter, Snake is shrunk until its length matches parameter.
     *
     * @param length desired length
     */
    public void setSnakeLength(int length){
        if(length < 1) {
            log.error("Can't set Snake's length to 0 or lower!");
            return;
        }
        while(body.size() != length) {
            if(body.size() < length) {
                extend();
            } else if(body.size() > length) {
                shrink();
            }
        }
    }

    /**
     * Returns length of body.
     *
     * @return length of body
     */
    public int size(){
        return body.size();
    }
}
