package com.alexapp;

import com.alexapp.Utils.SceneBuilder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Weather App
 */
public class WeatherApp extends Application {

    private static final Scene scene = SceneBuilder.getScene();

    @Override
    public void start(Stage stage) {

        stage.setTitle("Weather App");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}