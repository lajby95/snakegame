package snake;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class representing a Snake.
 */
@Slf4j
public class Snake {

    /**
     * Width of map.
     */
    @Getter
    private int sizeX = 37;

    /**
     * Height of map.
     */
    @Getter
    private int sizeY = 37;

    /**
     * Points earned by player.
     */
    @Getter
    private int points = 0;

    /**
     * Is Snake dead?
     */
    @Getter
    private Boolean died = false;

    /**
     * List of pickups types that are disabled. For example, when eating a slowdown pickup, we don't want the player
     * to be able to eat another slowdown pickup while the effect is active, and we also don't want the player to
     * eat a speedup pickup, since that would mean 2 pickups affecting speed are in effect at the same time.
     */
    public ArrayList<String> pickupsDisabled = new ArrayList<String>();

    /**
     * Add points to player's points.
     *
     * @param p points (int)
     */
    public void addPoints(int p){
        points += p;
    }

//    @Getter
//    private int[][] board = new int[sizeX][sizeY];

    /**
     * Stores pickups.
     */
    public Pickups pickups = new Pickups();

    /**
     * Stores pickup that was last eaten.
     */
    private Pickup lastEatenPickup = new Pickup(new Point(0,0),"empty");

    /**
     * returns {@code lastEatenPickup}, and then places the special "empty" pickup into {@code lastEatenPickup}.
     *
     * @return {@code lastEatenPickup}
     */
    public Pickup popLastEaten(){
        Pickup p = new Pickup(lastEatenPickup);
        lastEatenPickup = new Pickup(new Point(0,0), "empty");
        return p;
    }

    /**
     * Instantiates a {@code SnakeBody}.
     */
    public SnakeBody body = new SnakeBody();

//    private Boolean snakePlaced = false;

    /**
     * Stores current direction the Snake is traveling.
     */
    @Getter
    private char direction = 'u';

    /**
     * Sets direction of the Snake.
     *
     * If {@code dirNew} is the opposite of current {@code direction}, the direction is not changed. That would allow
     * the Snake to turn around into itself, which means Game Over.
     *
     * @param dirNew new direction
     */
    public void setDirection(char dirNew){
        if(!(dirNew == 'u' || dirNew == 'd' || dirNew == 'l' || dirNew == 'r')) {
            throw new IllegalArgumentException();
        }
        char dir = getDirection();
        if(dirNew == dir) {
            return;
        }
        if(
                dirNew == 'd' && dir == 'u'
                || dirNew == 'u' && dir == 'd'
                || dirNew == 'l' && dir == 'r'
                || dirNew == 'r' && dir == 'l'
        ) {
            log.info("Can't change direction to opposite!");
            return;
        }

        this.direction = dirNew;
        String d = "";
        switch(dirNew){
            case 'u': d = "UP"; break;
            case 'd': d = "DOWN"; break;
            case 'l': d = "LEFT"; break;
            case 'r': d = "RIGHT"; break;
        }
        log.info("direction changed to {}", d);
    }

    /**
     * Constructor that places Snake onto given position.
     *
     * @param posX X coordinate
     * @param posY Y coordinate
     */
    public Snake(int posX, int posY){
//        initTable();
        place(posX, posY);
    }

    /**
     * Empty constructor.
     */
    public Snake(){
//        initTable();
    }

//    public void initTable(){
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                board[i][j] = 0;
//            }
//        }
//    }

    /**
     * Returns 2 dimensional int array of map. Values consist of:
     *
     * Empty cells = 0
     *
     * Pickups = 1
     *
     * Snake = 2
     *
     * @return int[][] array of map
     */
    public int[][] getBoard(){
        int[][] board = new int[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                board[i][j] = 0;
            }
        }

        for (Pickup p : pickups.getAll()) {
            int pX = p.getPos().x;
            int pY = p.getPos().y;
            board[pX][pY] = 1;
        }

        for(SnakeBodyPart p : body.getBody()){
            int pX = p.getPos().x;
            int pY = p.getPos().y;
            board[pX][pY] = 2;
        }

        return board;
    }

    /**
     * Returns Vector of positions of empty cells of map (no Snake body parts, no pickups).
     *
     * @return vector of positions of empty cells of map
     */
    public Vector<Point> getEmptyCellsOfBoard(){
        Vector<Point> cells = new Vector<Point>();

        int[][] board = getBoard();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0) {
                    cells.add(new Point(i,j));
                }
            }
        }

        return cells;
    }

    /**
     * Places snake onto given X and Y coordinates of map.
     *
     * @param posX X coordinate
     * @param posY Y coordinate
     */
    public void place(int posX, int posY){
        if(posX >= sizeX || posY >= sizeY || posX < 0 || posY < 0) {
            throw new IllegalArgumentException();
        }
        body.place(posX, posY);
    }

    /**
     * Moves Snake by 1 tile.
     *
     * direction is determined by {@code direction} variable.
     *
     * If after move, Snake head collides with any other body part, Snake dies.
     *
     * After every move, it is checked if head is at position of any pickup. If true, then pickup is eaten, and
     * points are added to player.
     *
     */
    public void move(){
        if(body.size() > 1) {
            for (int i = body.size()-1; i >= 1; i--) {
                body.get(i).set(body.get(i-1));
            }
        }

        SnakeBodyPart head = body.get(0);
        if(direction == 'u') {
            head.set(head.getPos().x, head.getPos().y-1);
        } else if(direction == 'd') {
            head.set(head.getPos().x, head.getPos().y+1);
        } else if(direction == 'l') {
            head.set(head.getPos().x-1, head.getPos().y);
        } else if(direction == 'r') {
            head.set(head.getPos().x+1, head.getPos().y);
        }

        // snake can go through edge of map to other side
        head.set(head.getPos().x % sizeX, head.getPos().y % sizeY);
        if(head.getPos().x < 0) {
            head.set(sizeX-head.getPos().x-2, head.getPos().y);
        }
        if(head.getPos().y < 0) {
            head.set(head.getPos().x, sizeY-head.getPos().y-2);
        }
        log.info("Snake head position: ({},{})", head.getPos().x, head.getPos().y);

//        log.info("------------- body parts ----------------------");
//        for (int i = 0; i < body.size(); i++) {
//            log.info(i+". bodypart: ({},{})", body.get(i).getPos().x, body.get(i).getPos().y);
//        }

        if(body.isHeadCollidingWithBody()) {
            log.info("Snake Collision with itself! Snake died!");
            died = true;
        }

        int pickupIndexCollidingWithHead = getPickupIndexCollidingWithHead();
        if(pickupIndexCollidingWithHead != -1 && !pickupsDisabled.contains(pickups.get(pickupIndexCollidingWithHead).getType())) {
            lastEatenPickup = pickups.eat(pickupIndexCollidingWithHead);
            addPoints(lastEatenPickup.getPoints());
            log.info("Snake has eaten a(n) {}", lastEatenPickup.getType());
        }
    }

    /**
     * Places random pickup to random empty cell.
     */
    public void placeRandomPickup(){
        Vector<Point> emptyCells = getEmptyCellsOfBoard();
        if(emptyCells.size() > 0) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, emptyCells.size());
            String nextRandomPickup = pickups.getNextRandomPlaceablePickup();
            if(!nextRandomPickup.equals("")) {
                pickups.place(
                        new Pickup(
                                emptyCells.get(randomIndex),
                                nextRandomPickup,
                                pickups.getEffectTimers().get(nextRandomPickup),
                                pickups.getEffectDurations().get(nextRandomPickup),
                                pickups.getPoints().get(nextRandomPickup)
                        )
                );
            }
        }

//        for (int i = 0; i < pickups.getAll().size(); i++) {
//            log.info("Pickup at ({},{})", pickups.get(i).getPos().x, pickups.get(i).getPos().y);
//        }
    }

    /**
     * @return index of pickup that is at the same position as Snake's head, returns -1 if no collision.
     */
    public int getPickupIndexCollidingWithHead(){
        int in = -1;

        Pickups ps = pickups;
        for (int i=0; i<ps.getAll().size(); i++) {
            if(
//                    body.get(0).getPos().x == ps.get(i).getPos().x && body.get(0).getPos().y == ps.get(i).getPos().y
                    body.get(0).equals(ps.get(i))
            ) {
                in = i;
            }
        }

        return in;
    }

}
