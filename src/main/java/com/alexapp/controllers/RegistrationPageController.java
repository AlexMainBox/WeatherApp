package com.alexapp.controllers;

import com.alexapp.service.PoolService;
import com.alexapp.utils.SetRootPage;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class RegistrationPageController {

    @FXML
    private TextField nameField, emailField;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton femaleRadioButton, mailRadioButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton, singUpButton;

    @FXML
    private void initialize() {
        //Changing root scene on "loginPage", when you click  "loginButton"
        loginButton.setOnAction(actionEvent -> {
            System.out.println("Hello login page");
            SetRootPage.setRoot("loginPage");
        });
        //Logic for registration page. All fields add to User entity and save in DB. Email and name - unique fields!
        singUpButton.setOnAction(actionEvent -> {
            PoolService poolService = new PoolService();
            poolService.addUser(nameField.getText(), passwordField.getText(), emailField.getText());

        });
    }
}
