package com.alexapp.Utils;

import javafx.scene.Scene;
import java.io.IOException;

public class SceneBuilder {
    private static Scene scene;

    private SceneBuilder() {
    }

    public static Scene getScene() {
        if (scene == null) {
            try {
                scene = new Scene(LoaderFXML.loadFXML("loginPage"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return scene;
    }
}
