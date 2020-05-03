package snake;

import lombok.Getter;

import java.util.Vector;

public class SnakeBody {

    @Getter
    private Vector<SnakeBodyPart> body = new Vector<SnakeBodyPart>();

    public SnakeBody(int posX, int posY){
        body.add(new SnakeBodyPart(posX, posY));
    }
    public SnakeBody(){

    }

    public void addPart(){
        if(getBody().size() == 0) {
            return;
        }
        SnakeBodyPart tail = new SnakeBodyPart(getBody().lastElement());
        body.add(tail);
    }
    public void addPart(int x, int y){
        SnakeBodyPart newTail = new SnakeBodyPart(x, y);
        body.add(newTail);
    }

    public SnakeBodyPart get(int i){
        return body.get(i);
    }
    public SnakeBodyPart getLast(){
        return body.lastElement();
    }

    public int size(){
        return body.size();
    }
}
