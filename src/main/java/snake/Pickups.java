package snake;

import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class Pickups {

    private Vector<Pickup> pickups = new Vector<Pickup>();

    @Getter
    long lastPlacementTime;
    @Getter
    long lastEatenTime;

    @Getter
    private int pickupsEaten = 0;

    HashMap<String, Integer> maxPickupCounts = new HashMap<String, Integer>();
    HashMap<String, Integer> countOfPickups = new HashMap<String, Integer>();

    @Getter
    HashMap<String, Boolean> effectTimers = new HashMap<String, Boolean>();
    @Getter
    HashMap<String, Integer> effectDurations = new HashMap<String, Integer>();
    @Getter
    HashMap<String, Integer> Points = new HashMap<String, Integer>();

    public Pickups(){
        maxPickupCounts.put("apple", 3);
        maxPickupCounts.put("speedup", 5);
        maxPickupCounts.put("slowdown", 3);
        maxPickupCounts.put("size1", 2);

        countOfPickups.put("apple", 0);
        countOfPickups.put("speedup", 0);
        countOfPickups.put("slowdown", 0);
        countOfPickups.put("size1", 0);



        // ********** Default traits of pickups **********
        effectTimers.put("apple", false);
        effectTimers.put("speedup", true);
        effectTimers.put("slowdown", true);
        effectTimers.put("size1", true);

        effectDurations.put("apple", 0);
        effectDurations.put("speedup", 10);
        effectDurations.put("slowdown", 10);
        effectDurations.put("size1", 15);

        Points.put("apple", 100);
        Points.put("speedup", 500);
        Points.put("slowdown", 50);
        Points.put("size1", 50);
    }

    public void place(Pickup p){
        pickups.add(p);
        lastPlacementTime = System.currentTimeMillis();
        countOfPickups.put(p.getType(), countOfPickups.get(p.getType())+1);
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
        Pickup p = this.get(i);
        countOfPickups.put(p.getType(), countOfPickups.get(p.getType())-1);
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

    public String getNextRandomPlaceablePickup(){
        ArrayList<String> pickups = new ArrayList<String>();
        for(String s : maxPickupCounts.keySet()) {
            if(countOfPickups.get(s) < maxPickupCounts.get(s) ) {
                pickups.add(s);
            }
        }

        if(pickups.size() == 0) {
            return "";
        } else {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, pickups.size());
            return pickups.get(randomIndex);
        }
    }
}
