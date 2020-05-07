package snake;

import lombok.Getter;

public class Pickup {

    @Getter
    int posX;
    @Getter
    int posY;

    @Getter
    String type;

    public Pickup(int posX, int posY, String type){
        this.posX = posX;
        this.posY = posY;
        this.type = type;
    }


}
