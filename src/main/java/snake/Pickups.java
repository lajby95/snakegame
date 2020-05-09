package snake;

import javafx.geometry.Point2D;
import lombok.Getter;

import java.awt.*;
import java.util.Vector;

public class Pickups {

    Vector<Pickup> pickups = new Vector<Pickup>();

    @Getter
    long lastPlacement;

    public Pickups(){

    }

    public void place(Point point, String type){
        pickups.add(new Pickup(point, type));
        lastPlacement = System.currentTimeMillis();
    }
    public void place(int x, int y, String type){
        pickups.add(new Pickup(new Point(x,y), type));
        lastPlacement = System.currentTimeMillis();
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
        return pickups.remove(i);
    }
}
