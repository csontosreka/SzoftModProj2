package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.Random;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;

public class StartPageController extends SudokuApplication{
    public static int[][] genFields= {
            {3, 2, 9, 6, 5, 7, 8, 4, 1},
            {7, 4, 5, 8, 3, 1, 2, 9, 6},
            {6, 1, 8, 2, 4, 9, 3, 7, 5},
            {1, 9, 3, 4, 6, 8, 5, 2, 7},
            {2, 7, 6, 1, 9, 5, 4, 8, 3},
            {8, 5, 4, 3, 7, 2, 6, 1, 9},
            {4, 3, 2, 7, 1, 6, 9, 5, 8},
            {5, 8, 7, 9, 2, 3, 1, 6, 4},
            {9, 6, 1, 5, 8, 4, 7, 3, 2},
    };

    @FXML
    private void handleEasyButton(ActionEvent event) throws IOException {
        Logger.debug("Starting easy level.");
        genNewFields(20);
        startSudoku(event);
    }

    @FXML
    private void handleMediumButton(ActionEvent event) throws IOException{
        Logger.debug("Starting medium level.");
        genNewFields(50);
        startSudoku(event);
    }

    @FXML
    private void handleHardButton(ActionEvent event) throws IOException{
        Logger.debug("Starting hard level.");
        genNewFields(80);
        startSudoku(event);
    }

    public void genNewFields(int difficulty){
        Random rand = new Random();
        int numRowSwaps = rand.nextInt(100);
        int numColSwaps = rand.nextInt(100);
        for (int i=0; i<numRowSwaps;i++){
            int rowToSwap =  rand.nextInt(9);
            int rowToSwapWith =  ((rowToSwap)/3)*3+rand.nextInt(3);
            for (int j=0; j<9; j++){
                int temp = genFields[rowToSwap][j];
                genFields[rowToSwap][j] = genFields[rowToSwapWith][j];
                genFields[rowToSwapWith][j] = temp;
            }
        }
        for (int i=0; i<numColSwaps;i++){
            int colToSwap =  rand.nextInt(9);
            int colToSwapWith =  ((colToSwap)/3)*3+rand.nextInt(3);
            for (int j=0; j<9; j++){
                int temp = genFields[j][colToSwap];
                genFields[j][colToSwap] = genFields[j][colToSwapWith];
                genFields[j][colToSwapWith] = temp;
            }
        }

        for(int i=0; i< difficulty; i++)
        {
            int x = rand.nextInt(9);
            int y = rand.nextInt(9);
            genFields[x][y]=0;
        }
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
