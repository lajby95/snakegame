package snake;

import lombok.Getter;

public class Snake {

    @Getter
    private int sizeX = 37;
    @Getter
    private int sizeY = 37;

    @Getter
    private int[][] board = new int[sizeX][sizeY];

    SnakeBody snakeBody = new SnakeBody();

    public SnakeBody getBody(){
        return snakeBody;
    }

    private Boolean snakePlaced = false;

    private char direction = 'u';

    public void setDirection(char dir){
        if(dir == 'u' || dir == 'd' || dir == 'l' || dir == 'r') {
            this.direction = dir;
        }
    }

    public Snake(int posX, int posY){
        initTable();
        place(posX, posY);
    }
    public Snake(){
        initTable();
    }

    public void initTable(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 0;
            }
        }
    }

    public void place(int posX, int posY){
        if(snakePlaced) {
            return;
        }
        if(posX >= sizeX || posY >= sizeY) {
            return;
        }
        snakeBody.addPart(posX, posY);
        snakePlaced = true;
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
            System.out.println("UTKOZES "+Math.random());
        } else {
            System.out.println("nem utkozik "+Math.random());
        }
    }

}
