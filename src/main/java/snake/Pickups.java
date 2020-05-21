package snake;

import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class representing pickups on the map
 */
public class Pickups {

    /**
     * Vector storing all pickups currently on map
     */
    private Vector<Pickup> pickups = new Vector<Pickup>();

    /**
     * When was the last pickup placed
     */
    @Getter
    long lastPlacementTime;

    /**
     * When was the last pickup eaten.
     */
    @Getter
    long lastEatenTime;

    /**
     * How many pickups were eaten.
     */
    @Getter
    private int pickupsEaten = 0;

    /**
     * Stores upper limits that can be placed of all types of pickups.
     */
    HashMap<String, Integer> maxPickupCounts = new HashMap<String, Integer>();

    /**
     * Stores how many pickups of all types are currently on the map.
     */
    HashMap<String, Integer> countOfPickups = new HashMap<String, Integer>();

    /**
     * Stores if effectTimers are enabled for given type of pickups.
     */
    @Getter
    HashMap<String, Boolean> effectTimers = new HashMap<String, Boolean>();

    /**
     * Stores effectDurations for given type of pickups.
     */
    @Getter
    HashMap<String, Integer> effectDurations = new HashMap<String, Integer>();

    /**
     * Stores Points for given type of pickups.
     */
    @Getter
    HashMap<String, Integer> Points = new HashMap<String, Integer>();

    /**
     * Initialize properties of all types of pickups.
     */
    public Pickups(){
        maxPickupCounts.put("apple", 3);
        maxPickupCounts.put("speedup", 5);
        maxPickupCounts.put("slowdown", 3);
        maxPickupCounts.put("size1", 2);

        countOfPickups.put("apple", 0);
        countOfPickups.put("speedup", 0);
        countOfPickups.put("slowdown", 0);
        countOfPickups.put("size1", 0);



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

    /**
     * Places a Pickup {@code p} on the map. The position is stored as the object's property.
     *
     * @param p Pickup
     */
    public void place(Pickup p){
        pickups.add(p);
        lastPlacementTime = System.currentTimeMillis();
        countOfPickups.put(p.getType(), countOfPickups.get(p.getType())+1);
    }

    /**
     * Returns the i-th pickup from the vector of {@code pickups}.
     *
     * @param i index of pickup in vector of {@code pickups}
     * @return pickup
     */
    public Pickup get(int i){
        return pickups.get(i);
    }

    /**
     * Returns vector of all pickups on the map.
     *
     * @return vector of all pickups on the map
     */
    public Vector<Pickup> getAll(){
        return pickups;
    }

    /**
     * Returns all pickups placed on map of {@code type}.
     *
     * @param type of pickup
     * @return Vector of pickups
     */
    public Vector<Pickup> getAll(String type){
        Vector<Pickup> ps = new Vector<Pickup>();

        for(Pickup p : pickups){
            if(p.getType().equals(type)) {
                ps.add(p);
            }
        }

        return ps;
    }

    /**
     * Returns the amount of pickups of {@code type} placed on map.
     *
     * @param type of pickups
     * @return count of pickups of {@code type}
     */
    public int getCountOfType(String type){
        int count = 0;
        for(Pickup p : pickups){
            if(p.getType().equals(type)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Removes pickup from map (equivalent to Snake eating it), then updates time of last eaten pickup.
     *
     * @param i index of pickup to be eaten
     * @return pickup that was eaten
     */
    public Pickup eat(int i){
        lastEatenTime = System.currentTimeMillis();
        pickupsEaten++;
        Pickup p = this.get(i);
        countOfPickups.put(p.getType(), countOfPickups.get(p.getType())-1);
        return pickups.remove(i);
    }

    /**
     * Returns if pickup can be placed on map.
     *
     * Returns {@code true} if {@code interval} seconds have been passed since (last pickup placement time AND last
     * eaten time), {@code false} otherwise
     *
     * @return Boolean
     */
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

    /**
     * Creates a list of types of pickups that have not reached their specified maximum amount on the map, and then
     * returns a random type from this list.
     *
     * @return String of pickup type
     */
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
