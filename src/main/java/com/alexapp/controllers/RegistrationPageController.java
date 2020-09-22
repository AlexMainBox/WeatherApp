package com.alexapp.controllers;

import com.alexapp.service.PoolService;
import com.alexapp.utils.SetRootPage;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;


public class RegistrationPageController {

    @FXML
    private TextField nameField, emailField;

    @FXML
    private Text infoText;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton, singUpButton;

    @FXML
    private void initialize() {
        PoolService poolService = new PoolService();

        //Changing root scene on "loginPage", when you click  "loginButton"
        loginButton.setOnAction(actionEvent ->
                SetRootPage.setRoot("loginPage"));

        //Logic for registration page. All fields add to User entity and save in DB. Email and name - unique fields!
        singUpButton.setOnAction(actionEvent -> {
            if (poolService.addUser(nameField.getText(), passwordField.getText(), emailField.getText())) {
                infoText.setText("Creation complete. You can login in your account!");
                poolService.shutdownSession();
            } else {
                infoText.setText("Error: This login or password already exist! Try again.");
            }

        });
    }
}
