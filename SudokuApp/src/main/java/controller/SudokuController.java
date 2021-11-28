package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.tinylog.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;

public class SudokuController extends StartPageController implements Initializable {
    boolean notSentYet = true;
    long start = 0;
    long finish = 0;
    long score = 0;

    @FXML
    private TextField Index18;

    @FXML
    private TextField Index02;

    @FXML
    private TextField Index01;

    @FXML
    private TextField Index17;

    @FXML
    private TextField Index16;

    @FXML
    private TextField Index15;

    @FXML
    private TextField Index14;

    @FXML
    private TextField Index13;

    @FXML
    private TextField Index12;

    @FXML
    private TextField Index11;

    @FXML
    private TextField Index10;

    @FXML
    private TextField Index08;

    @FXML
    private TextField Index07;

    @FXML
    private TextField Index06;

    @FXML
    private TextField Index05;

    @FXML
    private TextField Index04;

    @FXML
    private TextField Index03;

    @FXML
    private TextField Index50;

    @FXML
    private TextField Index48;

    @FXML
    private TextField Index47;

    @FXML
    private TextField Index46;

    @FXML
    private TextField Index45;

    @FXML
    private TextField Index44;

    @FXML
    private TextField Index43;

    @FXML
    private TextField Index42;

    @FXML
    private TextField Index41;

    @FXML
    private TextField Index40;

    @FXML
    private TextField Index38;

    @FXML
    private TextField Index37;

    @FXML
    private TextField Index36;

    @FXML
    private TextField Index35;

    @FXML
    private TextField Index34;

    @FXML
    private TextField Index33;

    @FXML
    private TextField Index32;

    @FXML
    private TextField Index31;

    @FXML
    private TextField Index30;

    @FXML
    private TextField Index28;

    @FXML
    private TextField Index27;

    @FXML
    private TextField Index26;

    @FXML
    private TextField Index25;

    @FXML
    private TextField Index24;

    @FXML
    private TextField Index23;

    @FXML
    private TextField Index22;

    @FXML
    private TextField Index21;

    @FXML
    private TextField Index20;

    @FXML
    private TextField Index88;

    @FXML
    private TextField Index87;

    @FXML
    private TextField Index86;

    @FXML
    private TextField Index85;

    @FXML
    private TextField Index84;

    @FXML
    private TextField Index83;

    @FXML
    private TextField Index82;

    @FXML
    private TextField Index81;

    @FXML
    private TextField Index78;

    @FXML
    private TextField Index77;

    @FXML
    private TextField Index76;

    @FXML
    private TextField Index75;

    @FXML
    private TextField Index74;

    @FXML
    private TextField Index73;

    @FXML
    private TextField Index72;

    @FXML
    private TextField Index71;

    @FXML
    private TextField Index70;

    @FXML
    private TextField Index80;

    @FXML
    private TextField Index68;

    @FXML
    private TextField Index67;

    @FXML
    private TextField Index66;

    @FXML
    private TextField Index65;

    @FXML
    private TextField Index64;

    @FXML
    private TextField Index63;

    @FXML
    private TextField Index62;

    @FXML
    private TextField Index61;

    @FXML
    private TextField Index60;

    @FXML
    private TextField Index58;

    @FXML
    private TextField Index57;

    @FXML
    private TextField Index56;

    @FXML
    private TextField Index55;

    @FXML
    private TextField Index54;

    @FXML
    private TextField Index53;

    @FXML
    private TextField Index52;

    @FXML
    private TextField Index51;

    @FXML
    private TextField Index00;
    public boolean checkBoard(char[][] board){
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current_val = board[i][j];
                if(current_val != '.'){
                    if(!seen.add(current_val + "found in row" + i ) ||
                            !seen.add(current_val + "found in column" + j ) ||
                            !seen.add(current_val + "found in submatrix" + i/3 + j/3 ) )
                        return false;
                }
            }
        }
        return true;
    }
    @FXML
    void onActionReset(ActionEvent event) {
        loadDefaultSud();
    }

    void loadDefaultSud() {
        TextField[][] myTextFields = {
                {Index00, Index01, Index02, Index03, Index04, Index05, Index06, Index07, Index08},
                {Index10, Index11, Index12, Index13, Index14, Index15, Index16, Index17, Index18},
                {Index20, Index21, Index22, Index23, Index24, Index25, Index26, Index27, Index28},
                {Index30, Index31, Index32, Index33, Index34, Index35, Index36, Index37, Index38},
                {Index40, Index41, Index42, Index43, Index44, Index45, Index46, Index47, Index48},
                {Index50, Index51, Index52, Index53, Index54, Index55, Index56, Index57, Index58},
                {Index60, Index61, Index62, Index63, Index64, Index65, Index66, Index67, Index68},
                {Index70, Index71, Index72, Index73, Index74, Index75, Index76, Index77, Index78},
                {Index80, Index81, Index82, Index83, Index84, Index85, Index86, Index87, Index88},
        };

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(genFields[i][j] == 0) myTextFields[i][j].setText("");
                else myTextFields[i][j].setText(String.valueOf(genFields[i][j]));
            }
        }
    }

    void sendScore() throws IOException {
        HttpPost post = new HttpPost("http://localhost/SudokuWeb/submitscore.php");

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("scoretoken", scoreToken));
        urlParameters.add(new BasicNameValuePair("score", String.valueOf(score)));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {
            Logger.debug(EntityUtils.toString(response.getEntity()));
        }
    }

    @FXML
    void onActionCheckBoard(ActionEvent event) {
        TextField[][] myTextFields = {
                {Index00, Index01, Index02, Index03, Index04, Index05, Index06, Index07, Index08},
                {Index10, Index11, Index12, Index13, Index14, Index15, Index16, Index17, Index18},
                {Index20, Index21, Index22, Index23, Index24, Index25, Index26, Index27, Index28},
                {Index30, Index31, Index32, Index33, Index34, Index35, Index36, Index37, Index38},
                {Index40, Index41, Index42, Index43, Index44, Index45, Index46, Index47, Index48},
                {Index50, Index51, Index52, Index53, Index54, Index55, Index56, Index57, Index58},
                {Index60, Index61, Index62, Index63, Index64, Index65, Index66, Index67, Index68},
                {Index70, Index71, Index72, Index73, Index74, Index75, Index76, Index77, Index78},
                {Index80, Index81, Index82, Index83, Index84, Index85, Index86, Index87, Index88},
        };
        char[][] matrix = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current_val = '0';
                if (!myTextFields[i][j].getText().isEmpty()) current_val = myTextFields[i][j].getText().charAt(0);
                matrix[i][j] = current_val;
            }
        }
        if(checkBoard(matrix)){
            finish = System.currentTimeMillis();
            long timeElapsed = finish - start;
            score = (150000 - timeElapsed);
            if(notSentYet) {
                try {
                    sendScore();
                }
                catch(IOException e) {
                    System.out.println(e);
                }
                notSentYet = false;
                Alert error = new Alert(Alert.AlertType.WARNING);
                error.setTitle("Winner");
                error.setContentText("You Win! Score: " + score);
                error.showAndWait();
                Stage sudokuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                SudokuApplication.currstage.show();
                sudokuStage.hide();
            }
            else {
                Alert error = new Alert(Alert.AlertType.WARNING);
                error.setTitle("You can't submit your score anymore!");
                error.setContentText("You have to start a new game to submit one!");
                error.showAndWait();
            }
        }else {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Loser");
            error.setContentText("Incorrect!");
            error.showAndWait();
        }
    }

    @FXML
    void onActionSolve(ActionEvent event) {
        notSentYet=false;
        loadDefaultSud();
        TextField[][] myTextFields = {
                {Index00, Index01, Index02, Index03, Index04, Index05, Index06, Index07, Index08},
                {Index10, Index11, Index12, Index13, Index14, Index15, Index16, Index17, Index18},
                {Index20, Index21, Index22, Index23, Index24, Index25, Index26, Index27, Index28},
                {Index30, Index31, Index32, Index33, Index34, Index35, Index36, Index37, Index38},
                {Index40, Index41, Index42, Index43, Index44, Index45, Index46, Index47, Index48},
                {Index50, Index51, Index52, Index53, Index54, Index55, Index56, Index57, Index58},
                {Index60, Index61, Index62, Index63, Index64, Index65, Index66, Index67, Index68},
                {Index70, Index71, Index72, Index73, Index74, Index75, Index76, Index77, Index78},
                {Index80, Index81, Index82, Index83, Index84, Index85, Index86, Index87, Index88},
        };
        int[][] matrix = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int current_val = 0;
                if (!myTextFields[i][j].getText().isEmpty()) matrix[i][j]  = Integer.valueOf(myTextFields[i][j].getText());
                else matrix[i][j] = current_val;
                Logger.debug(current_val);
            }
        }
        if(SolveSudoku(matrix, 9)){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    System.out.print(matrix[i][j]);
                    myTextFields[i][j].setText(Integer.toString(matrix[i][j]));
                }
                System.out.println();
            }
        }
    }
    public static boolean SolveSudoku(int[][] matrix, int n) {
        int rowIndex = -1;
        int columnIndex = -1;
        int i = 0;
        int j = 0;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowIndex = i;
                    columnIndex = j;
                    break;
                }
            }
            if (rowIndex != -1) {
                break;
            }
        }
        if (i == n && j == n) {
            return true;
        } else {
            for (int value = 1; value < 10; value++) {
                if (IsSafe(matrix, value, rowIndex, columnIndex, n)) {
                    matrix[rowIndex][columnIndex] = value;
                    if (!SolveSudoku(matrix, n)) {
                        matrix[rowIndex][columnIndex] = 0;
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static boolean IsSafe(int[][] matrix, int value, int rowIndex, int columnIndex, int n) {
        //row check
        for (int j = 0; j < 9; j++) {
            if (matrix[rowIndex][j] == value) {
                return false;
            }
        }
        //column check
        for (int i = 0; i < 9; i++) {
            if (matrix[i][columnIndex] == value) {
                return false;
            }
        }
        //submatrix check
        int baseRowIndex = rowIndex - (rowIndex % 3);
        int baseColumnIndex = columnIndex - (columnIndex % 3);
        for (int i = baseRowIndex; i < baseRowIndex + 3; i++) {
            for (int j = baseColumnIndex; j < baseColumnIndex + 3; j++) {
                if (matrix[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        Logger.debug("Started game with token: " + scoreToken);
        Logger.debug("Current score: " + score);
        start = System.currentTimeMillis();
        genNewFields();
        loadDefaultSud();
    }
}
