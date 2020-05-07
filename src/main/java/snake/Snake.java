package snake;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Snake {

    @Getter
    private int sizeX = 37;
    @Getter
    private int sizeY = 37;

//    @Getter
//    private int[][] board = new int[sizeX][sizeY];

    SnakeBody snakeBody = new SnakeBody();

    public SnakeBody getBody(){
        return snakeBody;
    }

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

    public void place(int posX, int posY){
        if(posX >= sizeX || posY >= sizeY) {
            return;
        }
        snakeBody.place(posX, posY);
    }

    public void move(){
        if(snakeBody.size() > 1) {
            for (int i = snakeBody.size()-1; i >= 1; i--) {
                snakeBody.get(i).set(snakeBody.get(i-1));
            }
        }

        if(direction == 'u') {
            snakeBody.get(0).set(snakeBody.get(0).getX(), snakeBody.get(0).getY()-1);
        } else if(direction == 'd') {
            snakeBody.get(0).set(snakeBody.get(0).getX(), snakeBody.get(0).getY()+1);
        } else if(direction == 'l') {
            snakeBody.get(0).set(snakeBody.get(0).getX()-1, snakeBody.get(0).getY());
        } else if(direction == 'r') {
            snakeBody.get(0).set(snakeBody.get(0).getX()+1, snakeBody.get(0).getY());
        }

        if(snakeBody.isHeadCollidingWithAnyOtherPart()) {
            log.info("Snake Collision with itself!");
        }
    }

}
