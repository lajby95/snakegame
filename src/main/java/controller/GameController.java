package controller;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import lombok.extern.slf4j.Slf4j;
import snake.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

@Slf4j
public class GameController implements Initializable {

    private AnimationTimer gameTimer;

    public double originalUpdateInterval;
    double updateInterval = originalUpdateInterval;

    char dir = 'u';

    private int snakeLength;        // A játék végén ide tároljuk el, hogy a halálkor milyen hosszú volt a kígyó

    private long startTimestamp;
    private long endTimestamp;

    public Boolean paused = false;
    public Boolean died = false;

    Stage stage;
    Scene scene;

    Snake snake = new Snake();

    int rectSize = 13;

    int sizeX = snake.getSizeX();
    int sizeY = snake.getSizeY();

    @FXML
    private AnchorPane gameArea;

    Rectangle rectangles[][] = new Rectangle[sizeX][sizeY];

    @FXML
    Text pointsText;

    @FXML
    Text pausedText;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        startTimestamp = System.currentTimeMillis();
        snake.body.place(17,17);
        snake.body.setSnakeLength(10);
        initRectArray();
        initGameLoop();
    }

    public void pauseGame(){
        paused = !paused;
        if(paused) {
            gameTimer.stop();
            pausedText.setVisible(true);
        } else {
            gameTimer.start();
            pausedText.setVisible(false);
        }
    }

    public void initListeners(Stage stage, Scene scene, String difficulty){
        this.stage = stage;
        this.scene = scene;
        if(difficulty.equals("easy")) {
            this.originalUpdateInterval = 300;
        } else if(difficulty.equals("medium")) {
            this.originalUpdateInterval = 200;
        } else if(difficulty.equals("hard")) {
            this.originalUpdateInterval = 100;
        } else {
            this.originalUpdateInterval = 200;
        }
        this.updateInterval = originalUpdateInterval;

        this.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(died) {
                    return;
                }
                if(event.getCode() == KeyCode.UP) {
                    dir = 'u';
                } else if(event.getCode() == KeyCode.DOWN) {
                    dir = 'd';
                } else if(event.getCode() == KeyCode.LEFT) {
                    dir = 'l';
                } else if(event.getCode() == KeyCode.RIGHT) {
                    dir = 'r';
                } else if(event.getCode() == KeyCode.ESCAPE) {
                    pauseGame();
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
            if(snake.pickupsDisabled.contains(p.getType())) {
                continue;
            }
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

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                Rectangle r = getRect(i,j);
                r.setFill(Color.WHITE);
            }
        }

        drawAllPickups();

        for (int i = 0; i < snake.body.size(); i++) {
            SnakeBodyPart part = snake.body.get(i);
            Rectangle r = getRect(part.getPos().x, part.getPos().y);
            if(i%3==0) {
                r.setFill(Color.BLACK);
            } else if(i%3==1 || i%3==2) {
                r.setFill(Color.DARKGREEN);
            }
        }

    }

    public void pickupEffect(Pickup p){
        if(p.getType().equals("apple")) {
            snake.body.extend();
        } else if(p.getType().equals("speedup")) {
            snake.pickupsDisabled.add("slowdown");
            snake.pickupsDisabled.add("speedup");
            updateInterval = originalUpdateInterval * 0.5f;

            PauseTransition delay = new PauseTransition(Duration.seconds(p.getEffectDuration()));
            delay.setOnFinished(event -> {
                updateInterval = originalUpdateInterval;
                snake.pickupsDisabled.remove("slowdown");
                snake.pickupsDisabled.remove("speedup");
            });
            delay.play();
        } else if(p.getType().equals("slowdown")) {
            snake.pickupsDisabled.add("slowdown");
            snake.pickupsDisabled.add("speedup");
            updateInterval = originalUpdateInterval * 1.5f;

            PauseTransition delay = new PauseTransition(Duration.seconds(p.getEffectDuration()));
            delay.setOnFinished(event -> {
                updateInterval = originalUpdateInterval;
                snake.pickupsDisabled.remove("slowdown");
                snake.pickupsDisabled.remove("speedup");
            });
            delay.play();
        } else if(p.getType().equals("size1")) {
            snake.pickupsDisabled.add("apple");
            snake.pickupsDisabled.add("size1");
            int originalSize = snake.body.size();
            snake.body.setSnakeLength(1);

            PauseTransition delay = new PauseTransition(Duration.seconds(p.getEffectDuration()));
            delay.setOnFinished(event -> {
                snake.body.setSnakeLength(originalSize);
                snake.pickupsDisabled.remove("apple");
                snake.pickupsDisabled.remove("size1");
            });
            delay.play();
        }
    }

    public void moveSnake(){
        snake.move();
        if(snake.body.isHeadCollidingWithBody()) {
            try {
                die();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Pickup lastEaten = snake.popLastEaten();
        if(!lastEaten.getType().equals("empty")) {
            pickupEffect(lastEaten);
        }
    }

    public void switchToGameOverWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/gameover.fxml"));
        try {
            Parent root = (Parent)loader.load();
            GameOverController controller = (GameOverController)loader.getController();
            Scene scene = new Scene(root);

            int timeSurvivedSeconds = Math.round((float)(endTimestamp-startTimestamp)/1000);
            log.info("Time survived in seconds: {}", timeSurvivedSeconds);

            GameResult result = new GameResult();
            result.setNumOfPickups(snake.pickups.getPickupsEaten());
            result.setScore(snake.getPoints());
            result.setSnakeLength(snakeLength);
            result.setTimeSurvived(timeSurvivedSeconds);

            controller.init(result);      // eredmény átadása a GameOver controllernek

            stage.setTitle("Game Over!");
            stage.setResizable(false);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void die() throws IOException {
        died = true;
        endTimestamp = System.currentTimeMillis();
        snakeLength = snake.body.size();
        gameTimer.stop();

        float dieAnimationInterval = 2000/(float)snake.body.size();

        AnimationTimer dieTimer = new AnimationTimer(){
            private long lastUpdate = 0;
            @Override
            public void handle(long now){
                if(now - lastUpdate >= dieAnimationInterval*1000*1000) {
                    if(snake.body.size() > 1) {
                        snake.body.shrink();
                        drawBoard();
                    } else {
                        this.stop();
                        switchToGameOverWindow();
                    }
                    lastUpdate = now;
                }
            }
        };
        dieTimer.start();
    }

    private void initGameLoop(){
        gameTimer = new AnimationTimer(){
            private long lastUpdate = 0;
            @Override
            public void handle(long now){
                if(now - lastUpdate >= updateInterval*1000*1000) {
                    if(dir != snake.getDirection()) {
                        snake.setDirection(dir);
                    }
                    moveSnake();
                    drawBoard();

                    lastUpdate = now;

                    pointsText.setText(Integer.toString(snake.getPoints()));
                }
                if(snake.pickups.canPlacePickup()) {
                    snake.placeRandomPickup();
                }
            }
        };
        gameTimer.start();
        log.info("Game loop initialized");
    }
}
