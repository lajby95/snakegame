package controller;

import javafx.animation.AnimationTimer;
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
import snake.Snake;
import snake.SnakeBody;
import snake.SnakeBodyPart;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    private AnimationTimer gameTimer;

    int updateInterval = 300;

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
        snake.getBody().addPart(17,17);
        snake.getBody().addPart();
        snake.getBody().addPart();
        snake.getBody().addPart();
        snake.getBody().addPart();
        snake.getBody().addPart();
        snake.getBody().addPart();
        snake.getBody().addPart();
        snake.getBody().addPart();
        snake.getBody().addPart();
        snake.getBody().addPart();
        snake.getBody().addPart();
        snake.getBody().addPart();
        snake.getBody().addPart();
        snake.getBody().addPart();
        initRectArray();
        initGameLoop();
    }

    public void initListeners(Stage stage, Scene scene){
        this.stage = stage;
        this.scene = scene;

        this.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.W) {
                    snake.setDirection('u');
                } else if(event.getCode() == KeyCode.S) {
                    snake.setDirection('d');
                } else if(event.getCode() == KeyCode.A) {
                    snake.setDirection('l');
                } else if(event.getCode() == KeyCode.D) {
                    snake.setDirection('r');
                }
            }
        });
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
    }

    public void drawBoard(){
        int[][] board = snake.getBoard();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Rectangle r = (Rectangle)gameArea.getChildren().get(i*board[0].length+j);
                r.setFill(Color.WHITE);
            }
        }

        SnakeBody snakeBody = snake.getBody();
//        System.out.println("---- PART ----");
        for (int i = 0; i < snakeBody.size(); i++) {
            SnakeBodyPart part = snakeBody.get(i);
//            System.out.println(i+". part{"+part.getX()+","+part.getY()+"}");
            Rectangle r = (Rectangle)gameArea.getChildren().get(part.getX()*board[0].length+part.getY());
            r.setFill(Color.BLACK);
        }
    }

    private void initGameLoop(){
        gameTimer = new AnimationTimer(){
            private long lastUpdate = 0;
            @Override
            public void handle(long now){
                if(now - lastUpdate >= updateInterval*1000*1000) {
                    snake.move();
                    drawBoard();

                    lastUpdate = now;
                }
            }
        };
        gameTimer.start();
    }
}
