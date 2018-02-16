package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller {

    // The reference of outputText will be injected by the FXML loader
    @FXML
    private TextArea outputText;

    // location and resources will be automatically injected by the FXML loader
    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    // Add a public no-args constructor
    public Controller() {
    }

    @FXML
    private void initialize()
    {
    }

    @FXML
    private void printOutput()
    {
        outputText.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
