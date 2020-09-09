package com.alexapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistrationPageController {

    @FXML
    private TextField nameField;

    @FXML
    private RadioButton mailRadioButton;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    private Button singUpButton;

    @FXML
    private Button loginButton;

    @FXML
    private void initialize() {
        //Changing root scene on "loginPage", when you click  "loginButton"
        loginButton.setOnAction(actionEvent -> {
            System.out.println("Hello login page");
            WeatherApp.setRoot("loginPage");
        });
    }
}
