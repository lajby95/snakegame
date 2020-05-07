package snake;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;

@Slf4j
public class SnakeBody {

    private Boolean snakePlaced = false;

    @Getter
    private Vector<SnakeBodyPart> body = new Vector<SnakeBodyPart>();

    public SnakeBody(int posX, int posY){
        body.add(new SnakeBodyPart(posX, posY));
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
    public void place(int x, int y){
        if(snakePlaced) {
            log.error("Snake is already placed!");
            return;
        }
        SnakeBodyPart newTail = new SnakeBodyPart(x, y);
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

    public Boolean isHeadCollidingWithAnyOtherPart(){
        Boolean collides = false;

        for (int i = 1; i < size(); i++) {
            if(this.get(i).isCollidingWithOtherPart(this.get(0))) {
                collides = true;
                break;
            }
        }

        return collides;
    }

    public int size(){
        return body.size();
    }
}
