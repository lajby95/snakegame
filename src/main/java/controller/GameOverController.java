package controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class GameOverController {

    private int score;

    @FXML
    Text scoreText;

    public void init(int score){
        this.score = score;
        scoreText.setText(Integer.toString(score));
    }


}
