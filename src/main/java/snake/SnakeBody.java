package snake;

import javafx.geometry.Point2D;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.Vector;

@Slf4j
public class SnakeBody {

    private Boolean snakePlaced = false;

    @Getter
    private Vector<SnakeBodyPart> body = new Vector<SnakeBodyPart>();

    public SnakeBody(Point p){
        body.add(new SnakeBodyPart(p));
    }
    public SnakeBody(){

    }

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

    public SnakeBodyPart get(int i){
        return body.get(i);
    }
    public SnakeBodyPart getLast(){
        return body.lastElement();
    }

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

    public int size(){
        return body.size();
    }
}
