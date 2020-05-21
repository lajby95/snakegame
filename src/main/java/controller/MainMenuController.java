package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import results.GameResult;
import results.GameResultDao;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;

public class MainMenuController {

    String difficulty = "medium";

    GameResultDao resultDao = new GameResultDao();

    @FXML
    Button difficultyButton;

    @FXML
    TableView<GameResult> resultsTable;

    @FXML
    private TableColumn<GameResult, String> player;

    @FXML
    private TableColumn<GameResult, Integer> score;

    @FXML
    private TableColumn<GameResult, Integer> length;

    @FXML
    private TableColumn<GameResult, Integer> eaten;

    @FXML
    private TableColumn<GameResult, Integer> survived;

    @FXML
    private void initialize(){
        List<GameResult> highScoreList = resultDao.getGameResults(10);

        player.setCellValueFactory(new PropertyValueFactory<>("playerName"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        length.setCellValueFactory(new PropertyValueFactory<>("snakeLength"));
        eaten.setCellValueFactory(new PropertyValueFactory<>("numOfPickups"));
        survived.setCellValueFactory(new PropertyValueFactory<>("timeSurvived"));

        ObservableList<GameResult> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(highScoreList);

        resultsTable.setItems(observableResult);
    }

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
