package snake;

import lombok.Getter;

import java.awt.*;

public class Pickup {

    @Getter
    private Point pos;

    @Getter
    private String type;

    @Getter
    private Boolean effectTimer = false;
    @Getter
    private int effectDuration = 10;

    @Getter
    private int points;

    public Pickup(Point p, String type){
        this.pos = p;
        this.type = type;
    }
    public Pickup(Point p, String type, Boolean effectTimer, int effectDuration, int points){
        this.pos = p;
        this.type = type;
        this.effectTimer = effectTimer;
        this.effectDuration = effectDuration;
        this.points = points;
    }
    public Pickup(Pickup other){
        this.pos = other.getPos();
        this.type = other.getType();

        this.effectTimer = other.getEffectTimer();
        this.effectDuration = other.getEffectDuration();
        this.points = other.getPoints();
    }

}
