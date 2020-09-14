package com.alexapp.Utils;

import com.alexapp.WeatherApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class LoaderFXML {

    static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WeatherApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();

    }
}
