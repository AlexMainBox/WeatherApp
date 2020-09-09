package com.alexapp;

import com.alexapp.Utils.LoaderFXML;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Weather App
 */
public class WeatherApp extends Application {

    private static  Scene scene;

//     protected static Scene getScene() {
//        return scene;
//    }

    @Override
    public void start(Stage stage) {
        try {
            scene = new Scene(LoaderFXML.loadFXML("loginPage"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Weather App");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    static void setRoot(String fxml)  {
        try {
            scene.setRoot(LoaderFXML.loadFXML(fxml));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}