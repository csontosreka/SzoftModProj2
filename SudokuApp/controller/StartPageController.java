package controller;

import generators.LevelGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.tinylog.Logger;

import java.io.IOException;

public class StartPageController {

    @FXML
    private void handleEasyButton(ActionEvent event) throws IOException {
        Logger.debug("Starting easy level.");

        int N = 9, K = 20;
        LevelGenerator sudoku = new LevelGenerator(N, K);
        sudoku.fillValues();
        sudoku.printSudoku();
    }

    @FXML
    private void handleMediumButton(ActionEvent event) throws IOException{
        Logger.debug("Starting medium level.");

        int N = 9, K = 40;
        LevelGenerator sudoku = new LevelGenerator(N, K);
        sudoku.fillValues();
        sudoku.printSudoku();
    }

    @FXML
    private void handleHardButton(ActionEvent event) throws IOException{
        Logger.debug("Starting hard level.");

        int N = 9, K = 60;
        LevelGenerator sudoku = new LevelGenerator(N, K);
        sudoku.fillValues();
        sudoku.printSudoku();
    }
}
