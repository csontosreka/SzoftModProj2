package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;

public class StartPageController extends SudokuApplication{

    @FXML
    private void handleEasyButton(ActionEvent event) throws IOException {
        Logger.debug("Starting easy level.");
        startSudoku(event);
    }

    @FXML
    private void handleMediumButton(ActionEvent event) throws IOException{
        Logger.debug("Starting medium level.");
    }

    @FXML
    private void handleHardButton(ActionEvent event) throws IOException{
        Logger.debug("Starting hard level.");
    }

    public void startSudoku(ActionEvent event) throws IOException{
        Stage sudokuStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/SudokuBoard.fxml"));
        sudokuStage.setTitle("Sudoku!");
        sudokuStage.setScene(new Scene(root, 600, 400));
        sudokuStage.show();
        SudokuApplication.currstage.hide();
    }
}
