package snake;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Snake {

    @Getter
    private int sizeX = 37;
    @Getter
    private int sizeY = 37;

//    @Getter
//    private int[][] board = new int[sizeX][sizeY];

    public Pickups pickups = new Pickups();

    private Pickup lastEatenPickup = new Pickup(new Point(0,0),"empty");
    public Pickup popLastEaten(){
        Pickup p = new Pickup(lastEatenPickup);
        lastEatenPickup = new Pickup(new Point(0,0), "empty");
        if(p.getType().equals("empty")) {
            log.info("lasteaten type:: {}", p.getType());
        }
        return p;
    }

    public SnakeBody body = new SnakeBody();

//    private Boolean snakePlaced = false;

    @Getter
    private char direction = 'u';

    public void setDirection(char dirNew){
        if(dirNew == 'u' || dirNew == 'd' || dirNew == 'l' || dirNew == 'r') {
            char dir = getDirection();
            if(dirNew == dir) {
                return;
            }
            if(
                    dirNew == 'd' && dir == 'u'
                    || dirNew == 'u' && dir == 'd'
                    || dirNew == 'l' && dir == 'r'
                    || dirNew == 'r' && dir == 'l'
            ) {
                log.info("Can't change direction to opposite!");
                return;
            }

            this.direction = dirNew;
            String d = "";
            switch(dirNew){
                case 'u': d = "UP"; break;
                case 'd': d = "DOWN"; break;
                case 'l': d = "LEFT"; break;
                case 'r': d = "RIGHT"; break;
            }
            log.info("direction changed to {}", d);
        }
    }

    public Snake(int posX, int posY){
//        initTable();
        place(posX, posY);
    }
    public Snake(){
//        initTable();
    }

//    public void initTable(){
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                board[i][j] = 0;
//            }
//        }
//    }

    public int[][] getBoard(){
        int[][] board = new int[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                board[i][j] = 0;
            }
        }

        for (Pickup p : pickups.getAll()) {
            int pX = p.getPos().x;
            int pY = p.getPos().y;
            board[pX][pY] = 1;
        }

        for(SnakeBodyPart p : body.getBody()){
            int pX = p.getPos().x;
            int pY = p.getPos().y;
            board[pX][pY] = 2;
        }

        return board;
    }

    public Vector<Point> getEmptyCellsOfBoard(){
        Vector<Point> cells = new Vector<Point>();

        int[][] board = getBoard();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0) {
                    cells.add(new Point(i,j));
                }
            }
        }

        return cells;
    }

    public void place(int posX, int posY){
        if(posX >= sizeX || posY >= sizeY) {
            return;
        }
        body.place(posX, posY);
    }

    public void move(){
        if(body.size() > 1) {
            for (int i = body.size()-1; i >= 1; i--) {
                body.get(i).set(body.get(i-1));
            }
        }

        SnakeBodyPart head = body.get(0);
        if(direction == 'u') {
            head.set(head.getPos().x, head.getPos().y-1);
        } else if(direction == 'd') {
            head.set(head.getPos().x, head.getPos().y+1);
        } else if(direction == 'l') {
            head.set(head.getPos().x-1, head.getPos().y);
        } else if(direction == 'r') {
            head.set(head.getPos().x+1, head.getPos().y);
        }

        if(body.isHeadCollidingWithBody()) {
            log.info("Snake Collision with itself!");
        }

        int pickupIndexCollidingWithHead = getPickupIndexCollidingWithHead();
        if(pickupIndexCollidingWithHead != -1) {
            lastEatenPickup = pickups.eat(pickupIndexCollidingWithHead);
            log.info("Snake has eaten a(n) {}", lastEatenPickup.getType());
        }
    }

    public void placeRandomPickup(){
        Vector<Point> emptyCells = getEmptyCellsOfBoard();
        if(emptyCells.size() > 0) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, emptyCells.size());
            this.pickups.place(emptyCells.get(randomIndex), "apple");
        }


//        int randomX, randomY;
//        do {
//            randomX = ThreadLocalRandom.current().nextInt(0, sizeX);
//            randomY = ThreadLocalRandom.current().nextInt(0, sizeY);
//        } while(this.body.isSnakeAt(randomX, randomY));
//        this.pickups.place(randomX, randomY, "apple");
    }

//    public Boolean isHeadCollidingWithPickup(){
//        Boolean collides = false;
//
//        for (Pickup p : pickups.getAll()) {
//            if(snakeBody.get(0).getX() == p.getPosX() && snakeBody.get(0).getY() == p.getPosY()) {
//                collides = true;
//                break;
//            }
//        }
//
//        return collides;
//    }

    public int getPickupIndexCollidingWithHead(){
        int in = -1;

        Pickups ps = pickups;
        for (int i=0; i<ps.getAll().size(); i++) {
            if(
//                    body.get(0).getPos().x == ps.get(i).getPos().x && body.get(0).getPos().y == ps.get(i).getPos().y
                    body.get(0).equals(ps.get(i))
            ) {
                in = i;
            }
        }

        log.info("in ddd  {}", in);
        return in;
    }

    public void pickupEffect(Pickup p){
        if(p.getType().equals("apple")) {
            body.extend();
        }
    }

}
