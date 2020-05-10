package main;

import controller.GameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/game.fxml"));
        Parent root = (Parent)loader.load();

        GameController controller = (GameController)loader.getController();
        Scene scene = new Scene(root);

        controller.initListeners(stage, scene, 200);      // stage és scene átadása a controllernek, hogy utána lehessen a billentyűnyomásokat figyelni

        stage.setTitle("Snake Game");
        stage.setResizable(true);

        stage.setScene(scene);
        stage.show();
    }
}
