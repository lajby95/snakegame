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
        return pickups.remove(i);
    }
}
