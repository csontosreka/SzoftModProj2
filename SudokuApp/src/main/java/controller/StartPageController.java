package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class StartPageController extends SudokuApplication implements Initializable {
    public int[][] protectedGenFields= {
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

    public int[][] genFields= {
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

    public static int difficulty = 0;
    public static String scoreToken = "notregyet";

    @FXML
    private void handleEasyButton() throws IOException {
        Logger.debug("Starting easy level.");
        difficulty=20;
        startSudoku();
    }

    @FXML
    private void handleMediumButton() throws IOException{
        Logger.debug("Starting medium level.");
        difficulty=40;
        startSudoku();
    }

    @FXML
    private void handleHardButton() throws IOException{
        Logger.debug("Starting hard level.");
        difficulty=60;
        startSudoku();
    }

    @FXML
    private void handleTokenButton() throws IOException{
        changeToken();
    }

    public void genNewFields(){
        genFields=protectedGenFields;
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

    public void changeToken() throws IOException{
        Stage tokenStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/changeToken.fxml"));
        tokenStage.setTitle("Change User Token");
        Scene scene = new Scene(root);
        tokenStage.setScene(scene);
        tokenStage.setResizable(false);
        tokenStage.show();
        tokenStage.setOnCloseRequest(we -> SudokuApplication.currstage.show());
        tokenStage.show();
        SudokuApplication.currstage.hide();
    }

    public void startSudoku() throws IOException{
        Stage sudokuStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/SudokuBoard.fxml"));
        sudokuStage.setTitle("Sudoku!");
        sudokuStage.setScene(new Scene(root, 600, 400));
        sudokuStage.setResizable(false);
        sudokuStage.setOnCloseRequest(we -> SudokuApplication.currstage.show());
        sudokuStage.show();
        SudokuApplication.currstage.hide();
    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        try {
            File myObj = new File("token.txt");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter("token.txt");
                myWriter.write("notregyet");
                myWriter.close();
                Logger.debug("File created: " + myObj.getName());
            } else {
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    scoreToken=data;
                    Logger.debug("Token read from file: " + data);
                }
                myReader.close();
            }
        } catch (IOException e) {
            Logger.debug(e);
        }
    }
}

