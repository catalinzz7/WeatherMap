package ro.mta.se.lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.mta.se.lab.controller.WeatherManager;

import java.io.IOException;
import java.net.URL;
import javafx.scene.layout.AnchorPane;

public class Main extends Application{

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

    }



    public static void main(String[] args) {
        launch(args);
    }
}
