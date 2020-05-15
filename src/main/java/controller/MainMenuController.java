package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    String difficulty = "medium";

    @FXML
    Button difficultyButton;

    public void nextDifficulty(){
        if(difficulty.equals("easy")){
            setDifficulty("medium");
        } else if(difficulty.equals("medium")){
            setDifficulty("hard");
        } else if(difficulty.equals("hard")){
            setDifficulty("easy");
        }
    }

    public void setDifficulty(String diff) {
        if( !(diff.equals("easy") || diff.equals("medium") || diff.equals("hard")) ) {
            return;
        }
        difficulty = diff;
        difficultyButton.setText("Difficulty: "+diff);
    }

    public void switchToGame(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/game.fxml"));
//        stage.setScene(new Scene(root));
//        stage.show();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/game.fxml"));
        Parent root = (Parent)loader.load();

        GameController controller = (GameController)loader.getController();
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        controller.initListeners(stage, scene, difficulty);      // stage és scene átadása a controllernek, hogy utána lehessen a billentyűnyomásokat figyelni

        stage.setTitle("Snake Game");
        stage.setResizable(true);

        stage.setScene(scene);
        stage.show();
    }
}
