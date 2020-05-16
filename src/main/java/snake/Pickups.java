package snake;

import lombok.Getter;

import java.awt.*;
import java.util.Vector;

public class Pickups {

    Vector<Pickup> pickups = new Vector<Pickup>();

    @Getter
    long lastPlacementTime;
    @Getter
    long lastEatenTime;

    @Getter
    private int pickupsEaten = 0;

    public Pickups(){

    }

    public void place(Pickup p){
        pickups.add(p);
        lastPlacementTime = System.currentTimeMillis();
    }

    public Pickup get(int i){
        return pickups.get(i);
    }

    public Vector<Pickup> getAll(){
        return pickups;
    }

    public Vector<Pickup> getAll(String type){
        Vector<Pickup> ps = new Vector<Pickup>();

        for(Pickup p : pickups){
            if(p.getType().equals(type)) {
                ps.add(p);
            }
        }

        return ps;
    }

    public int getCountOfType(String type){
        int count = 0;
        for(Pickup p : pickups){
            if(p.getType().equals(type)) {
                count++;
            }
        }

        return count;
    }

    public Pickup eat(int i){
        lastEatenTime = System.currentTimeMillis();
        pickupsEaten++;
        return pickups.remove(i);
    }

    public Boolean canPlacePickup(){
        double interval = 3;            // seconds

        long currentTimestamp = System.currentTimeMillis();
        if(
                currentTimestamp >= (this.getLastPlacementTime()+interval*1000)
                && currentTimestamp >= (this.getLastEatenTime()+interval*1000)
        ) {
            return true;
        } else {
            return false;
        }
    }
}
