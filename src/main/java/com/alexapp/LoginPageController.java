package com.alexapp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginPageController {

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button singUpButton;

    @FXML
    private Button loginButton;

    @FXML
    private CheckBox checkBox;

    @FXML
    private TextField emailTextField;

    @FXML
    private void singUpButtonAction() {
        singUpButton.setOnAction(actionEvent -> {
            System.out.println("Hello registration page");
            App.setRoot("registrationPage");
        });
    }


}