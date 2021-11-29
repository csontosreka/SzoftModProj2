package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class tokenController extends StartPageController implements Initializable{

    @FXML
    private void handleTokenChange(ActionEvent event) {
        saveTokenToFile();
        SudokuApplication.currstage.show();
        Stage tokenStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        tokenStage.hide();
    }

    @FXML
    TextArea textArea;

    private void saveTokenToFile() {
        scoreToken=textArea.getText();
        try {
            new File("token.txt");
        FileWriter myWriter = new FileWriter("token.txt");
        myWriter.write(scoreToken);
        myWriter.close();}
        catch (IOException e) {
                Logger.debug(e);
            }
    }
    private void tokenFile() {
        try {
            File myObj = new File("token.txt");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter("token.txt");
                myWriter.write("notregyet");
                myWriter.close();
                Logger.debug("File created: " + myObj.getName());
                textArea.setText("notregyet");
            } else {
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    scoreToken=data;
                    Logger.debug("Token read from file: " + data);
                    textArea.setText(data);
                }
                myReader.close();
            }
        } catch (IOException e) {
            Logger.debug(e);
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        tokenFile();
    }
}