package snake;

import lombok.Getter;

public class Snake {

    @Getter
    private int sizeX = 37;
    @Getter
    private int sizeY = 37;

    private int[][] table = new int[sizeX][sizeY];

    private Boolean snakePlaced = false;

//    private int length;

    public Snake(int posX, int posY){
        initTable();
        placeSnake(posX, posY);
    }
    public Snake(){
        initTable();
    }

    public void initTable(){
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = 0;
            }
        }
    }

    public void placeSnake(int posX, int posY){
        if(snakePlaced) {
            return;
        }
        if(posX >= sizeX || posY >= sizeY) {
            return;
        }

        table[posX][posY] = 1;
        snakePlaced = true;
    }





}
