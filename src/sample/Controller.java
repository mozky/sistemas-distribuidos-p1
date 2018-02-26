package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.util.Duration;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller {
    private Timeline clockTicker = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> changeClockLabels()));

    @FXML
    private Label clockLabel1, clockLabel2, clockLabel3, clockLabel4;

    @FXML
    private Slider sliderClock1, sliderClock2, sliderClock3, sliderClock4;

    private CustomClock clock1 = new CustomClock();
    private CustomClock clock2 = new CustomClock("Asia/Tokyo");
    private CustomClock clock3 = new CustomClock("America/Los_Angeles");
    private CustomClock clock4 = new CustomClock("Europe/Paris");

    // location and resources will be automatically injected by the FXML loader
    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    // Add a public no-args constructor
    public Controller() {
    }

    @FXML
    private void initialize() {
        sliderClock1.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Slider Value Changed: " + newValue.doubleValue() + ")");
            clock1.setTickSpeed(newValue.doubleValue());
        });

        sliderClock2.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Slider Value Changed: " + newValue.doubleValue() + ")");
            clock2.setTickSpeed(newValue.doubleValue());
        });

        sliderClock3.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Slider Value Changed: " + newValue.doubleValue() + ")");
            clock3.setTickSpeed(newValue.doubleValue());
        });

        sliderClock4.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Slider Value Changed: " + newValue.doubleValue() + ")");
            clock4.setTickSpeed(newValue.doubleValue());
        });

        clockTicker.setCycleCount(Timeline.INDEFINITE);
        clockTicker.play();
    }

    @FXML
    private void refreshClocks() {
        changeClockLabels();
    }

    private void changeClockLabels() {
        clockLabel1.setText(clock1.getTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        clockLabel2.setText(clock2.getTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        clockLabel3.setText(clock3.getTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        clockLabel4.setText(clock4.getTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
