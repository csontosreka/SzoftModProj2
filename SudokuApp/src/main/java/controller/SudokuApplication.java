package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;

public class SudokuApplication extends Application {
    public static Stage currstage;
    @Override
    public void start(Stage stage) throws IOException {
        currstage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/start.fxml"));
        stage.setTitle("Best Sudoku Ever");
        Logger.debug("Loading start page.");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
