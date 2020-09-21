package com.alexapp.utils;

import java.io.IOException;

public class SetRootPage {

    public static void setRoot(String fxml) {
        try {
            SceneBuilder.getScene().setRoot(LoaderFXML.loadFXML(fxml));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
