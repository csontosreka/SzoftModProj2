package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.tinylog.Logger;

import java.io.IOException;

public class StartPageController {

    @FXML
    private void handleEasyButton(ActionEvent event) throws IOException {
        Logger.debug("Starting easy level.");
    }

    @FXML
    private void handleMediumButton(ActionEvent event) throws IOException{
        Logger.debug("Starting medium level.");
    }

    @FXML
    private void handleHardButton(ActionEvent event) throws IOException{
        Logger.debug("Starting hard level.");
    }
}
