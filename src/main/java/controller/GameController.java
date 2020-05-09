package controller;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import lombok.extern.slf4j.Slf4j;
import snake.*;

import java.net.URL;
import java.util.ResourceBundle;

@Slf4j
public class GameController implements Initializable {

    private AnimationTimer gameTimer;

    public static final double originalUpdateInterval = 300;
    double updateInterval = originalUpdateInterval;

    char dir = 'u';

    Stage stage;
    Scene scene;

    Snake snake = new Snake();

    int rectSize = 13;

    int sizeX = snake.getSizeX();
    int sizeY = snake.getSizeY();

    @FXML
    private AnchorPane gameArea;

    Rectangle rectangles[][] = new Rectangle[sizeX][sizeY];

    @Override
    public void initialize(URL location, ResourceBundle resources){
        snake.body.place(17,17);
        snake.body.extend();
        snake.body.extend();
//        snake.pickups.place(new Pickup(10, 10, "apple"));
        initRectArray();
        initGameLoop();
    }

    public void initListeners(Stage stage, Scene scene){
        this.stage = stage;
        this.scene = scene;

        this.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.UP) {
                    dir = 'u';
                } else if(event.getCode() == KeyCode.DOWN) {
                    dir = 'd';
                } else if(event.getCode() == KeyCode.LEFT) {
                    dir = 'l';
                } else if(event.getCode() == KeyCode.RIGHT) {
                    dir = 'r';
                }
            }
        });
        log.info("Keyboard listener initialized");

        stage.setWidth(510);
        stage.setHeight(580);
    }

    public void initRectArray(){
        for (int i = 0; i < snake.getSizeX(); i++) {
            for (int j = 0; j < snake.getSizeY(); j++) {
                Rectangle r = new Rectangle();
                r.setX(i*rectSize);
                r.setY(j*rectSize);
                r.setWidth(rectSize);
                r.setHeight(rectSize);
                r.setFill(Color.WHITE);
                r.setStroke(Color.DIMGREY);
                r.setStrokeWidth(1);

                gameArea.getChildren().add(r);
            }
        }
        log.info("Rectangle array initialized");
    }

    public Rectangle getRect(int posX, int posY){
        return (Rectangle)gameArea.getChildren().get(posX*sizeX+posY);
    }


    public void drawAllPickups(){
        for(Pickup p : snake.pickups.getAll()) {
            Rectangle r = getRect(p.getPos().x, p.getPos().y);
            if(p.getType().equals("apple")) {
                r.setFill(Color.RED);
            } else if(p.getType().equals("speedup")) {
                r.setFill(Color.CYAN);
            } else if(p.getType().equals("slowdown")) {
                r.setFill(Color.BLUE);
            } else if(p.getType().equals("size1")) {
                r.setFill(Color.YELLOWGREEN);
            }
        }
    }
    public void drawAllPickupsOfType(String type){
        for(Pickup p : snake.pickups.getAll(type)) {
            Rectangle r = getRect(p.getPos().x, p.getPos().y);
            r.setFill(Color.RED);
        }
    }

    public void drawBoard(){
//        int[][] board = snake.getBoard();

        gameArea.getChildren().parallelStream().forEach(r -> {
            ((Rectangle)r).setFill(Color.WHITE);
        });

        drawAllPickups();

        float shade = 0.0f;
        for (int i = 0; i < snake.body.size(); i++) {
            Color color = Color.color(shade, shade, shade);
            if(shade < 0.8f && i<5) {
                shade += 0.1f;
            }
            SnakeBodyPart part = snake.body.get(i);
            Rectangle r = getRect(part.getPos().x, part.getPos().y);
            r.setFill(color);
        }

    }

    public Boolean canPlacePickup(){
        double interval = 3;

        long currentTimestamp = System.currentTimeMillis();
        if(
                currentTimestamp >= (snake.pickups.getLastPlacementTime()+interval*1000)
                && currentTimestamp >= (snake.pickups.getLastEatenTime()+interval*1000)
        ) {
            return true;
        } else {
            return false;
        }
    }

    public void pickupEffect(Pickup p){
        if(p.getType().equals("apple")) {
            snake.body.extend();
        } else if(p.getType().equals("speedup")) {
            updateInterval = 300 * 0.5f;

            PauseTransition delay = new PauseTransition(Duration.seconds(p.getEffectDuration()));
            delay.setOnFinished(event -> {
                updateInterval = originalUpdateInterval;
            });
            delay.play();
        } else if(p.getType().equals("slowdown")) {
            updateInterval = 300 * 1.5f;

            PauseTransition delay = new PauseTransition(Duration.seconds(p.getEffectDuration()));
            delay.setOnFinished(event -> {
                updateInterval = originalUpdateInterval;
            });
            delay.play();
        } else if(p.getType().equals("size1")) {
            int originalSize = snake.body.size();
            snake.body.setSnakeLength(1);

            PauseTransition delay = new PauseTransition(Duration.seconds(p.getEffectDuration()));
            delay.setOnFinished(event -> {
                snake.body.setSnakeLength(originalSize);
            });
            delay.play();
        }
    }

    public void moveSnake(){
        snake.move();
        Pickup lastEaten = snake.popLastEaten();
        if(!lastEaten.getType().equals("empty")) {
            pickupEffect(lastEaten);
        }
    }

    private void initGameLoop(){
        gameTimer = new AnimationTimer(){
            private long lastUpdate = 0;
            @Override
            public void handle(long now){
                if(canPlacePickup()) {
                    snake.placeRandomPickup();
                }
                if(now - lastUpdate >= updateInterval*1000*1000) {
                    if(dir != snake.getDirection()) {
                        snake.setDirection(dir);
                    }
                    moveSnake();
                    drawBoard();

                    lastUpdate = now;
                }
            }
        };
        gameTimer.start();
        log.info("Game loop initialized");
    }
}
