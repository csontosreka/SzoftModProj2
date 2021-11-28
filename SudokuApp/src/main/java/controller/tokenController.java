package controller;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner; // Import the Scanner class to read text files
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.tinylog.Logger;
import java.io.IOException;
import java.io.FileWriter;

public class tokenController extends StartPageController implements Initializable{

    @FXML
    private void handleTokenChange(ActionEvent event) throws IOException {
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
            File myObj = new File("token.txt");
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