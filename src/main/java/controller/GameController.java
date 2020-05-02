package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import snake.Snake;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    Snake snake = new Snake();

    int rectSize = 13;

    int sizeX = snake.getSizeX();
    int sizeY = snake.getSizeY();

    @FXML
    private AnchorPane gameArea;

    Rectangle rectangles[][] = new Rectangle[sizeX][sizeY];

    @Override
    public void initialize(URL location, ResourceBundle resources){
        snake.placeSnake(17,17);
        initRectArray();
    }

    public GameController(){

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
}
