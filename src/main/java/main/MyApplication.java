package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("/fxml/mainmenu.fxml"));
        stage.setTitle("Snake Game");
        stage.setResizable(true);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
