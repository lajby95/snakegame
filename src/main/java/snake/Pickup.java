package snake;

import lombok.Getter;

import java.awt.*;

/**
 * Class representing a pickup for Snake
 */
public class Pickup {

    /**
     * Position of pickup
     */
    @Getter
    private Point pos;

    /**
     * Type of pickup
     *
     * e.g.: apple, slowdown, speedup, etc.
     */
    @Getter
    private String type;

    /**
     * Stores if pickup has effect that lasts X seconds
     */
    @Getter
    private Boolean effectTimer = false;

    /**
     * If {@code effectTimer} is true, duration stores how many seconds the effect lasts
     */
    @Getter
    private int effectDuration = 10;

    /**
     * Stores the amount of points the player gets upon eating this pickup
     */
    @Getter
    private int points;

    /**
     * Constructor that takes position and type as parameters
     *
     * @param p position
     * @param type of pickup
     */
    public Pickup(Point p, String type){
        this.pos = p;
        this.type = type;
    }

    /**
     * Constructor that takes following as parameters:
     *
     * @param p position
     * @param type of pickup
     * @param effectTimer Boolean
     * @param effectDuration duration of pickup's effect
     * @param points points for pickup
     */
    public Pickup(Point p, String type, Boolean effectTimer, int effectDuration, int points){
        this.pos = p;
        this.type = type;
        this.effectTimer = effectTimer;
        this.effectDuration = effectDuration;
        this.points = points;
    }

    /**
     * Constructor that takes other {@code Pickup} as parameter
     *
     * @param other Pickup
     */
    public Pickup(Pickup other){
        this.pos = other.getPos();
        this.type = other.getType();

        this.effectTimer = other.getEffectTimer();
        this.effectDuration = other.getEffectDuration();
        this.points = other.getPoints();
    }

}
