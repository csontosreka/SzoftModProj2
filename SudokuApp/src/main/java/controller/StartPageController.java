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

        LevelGenerator sudoku = new LevelGenerator(9, 20);
        sudoku.fillValues();
        sudoku.printSudoku();
    }

    @FXML
    private void handleMediumButton(ActionEvent event) throws IOException{
        Logger.debug("Starting medium level.");

        LevelGenerator sudoku = new LevelGenerator(9, 40);
        sudoku.fillValues();
        sudoku.printSudoku();
    }

    @FXML
    private void handleHardButton(ActionEvent event) throws IOException{
        Logger.debug("Starting hard level.");

        LevelGenerator sudoku = new LevelGenerator(9, 60);
        sudoku.fillValues();
        sudoku.printSudoku();
    }
}
