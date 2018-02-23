package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    // The reference of outputText will be injected by the FXML loader
    @FXML
    private TextArea clockField1;
    @FXML
    private TextArea clockField2;
    @FXML
    private TextArea clockField3;
    @FXML
    private TextArea clockField4;


    @FXML
    private TextField clockMultiplierField1;
    @FXML
    private TextField clockMultiplierField2;
    @FXML
    private TextField clockMultiplierField3;
    @FXML
    private TextField clockMultiplierField4;

    private CustomClock clock1 = new CustomClock();
    private CustomClock clock2 = new CustomClock();
    private CustomClock clock3 = new CustomClock();
    private CustomClock clock4 = new CustomClock();

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
    private void printOutput() {
        clockField1.setText(clock1.getTime(Double.parseDouble(clockMultiplierField1.getText())).toString());
        clockField2.setText(clock2.getTime(Double.parseDouble(clockMultiplierField2.getText())).toString());
        clockField3.setText(clock3.getTime(Double.parseDouble(clockMultiplierField3.getText())).toString());
        clockField4.setText(clock4.getTime(Double.parseDouble(clockMultiplierField4.getText())).toString());


    }
}
