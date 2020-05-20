package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import results.GameResult;
import results.GameResultDao;

import java.io.IOException;
import java.util.List;

public class GameOverController {

    private GameResult result = new GameResult();

    @FXML
    Text scoreText;

    @FXML
    TextField playerNameInput;

    public void init(GameResult result){
        this.result = result;
        scoreText.setText(Integer.toString(result.getScore()));
    }

    @FXML
    private void submitResultAndSwitchToMainMenu(ActionEvent event) throws IOException {
        GameResultDao dao = new GameResultDao();

        result.setPlayerName(playerNameInput.getText());

        dao.insertGameResult(result);


        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainmenu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

        List<GameResult> results = dao.getGameResults(5);
        results.stream().forEach(System.out::println);
    }
}
