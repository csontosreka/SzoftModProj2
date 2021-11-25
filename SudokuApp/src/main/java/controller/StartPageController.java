package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;

public class StartPageController {

    @FXML
    private void handleEasyButton(ActionEvent event) throws IOException {
        Logger.debug("Starting easy level.");
        startSudoku();
    }

    @FXML
    private void handleMediumButton(ActionEvent event) throws IOException{
        Logger.debug("Starting medium level.");
    }

    @FXML
    private void handleHardButton(ActionEvent event) throws IOException{
        Logger.debug("Starting hard level.");
    }

    public void startSudoku() throws IOException{
        Stage sudokStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/SudokuBoard.fxml"));
        sudokStage.setTitle("Sudoku!");
        sudokStage.setScene(new Scene(root, 300, 275));
        sudokStage.show();

    }
}
