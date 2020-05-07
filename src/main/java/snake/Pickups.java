package snake;

import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class Pickups {

    Vector<Pickup> pickups = new Vector<Pickup>();

    public Pickups(){

    }

    public void add(int posX, int posY, String type){
        pickups.add(new Pickup(posX, posY, type));
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
