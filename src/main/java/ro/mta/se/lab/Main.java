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
        this.primaryStage = primaryStage; // connect primary stage
        mainWindow();
    }

    // main window
    public void mainWindow() {
        try {
            // view
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/WeatherView.fxml"));
            AnchorPane pane = loader.load();

            // controller
            WeatherManager mainWindowController = loader.getController();
            mainWindowController.setMain(this);

            // scene on stage
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
