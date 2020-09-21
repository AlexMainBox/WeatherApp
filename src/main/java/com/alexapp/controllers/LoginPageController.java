package com.alexapp.controllers;

import com.alexapp.utils.SetRootPage;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginPageController {

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button singUpButton, loginButton;

    @FXML
    private CheckBox checkBox;

    @FXML
    private TextField emailTextField;

    @FXML
    void initialize() {
//        Changing root scene on "registrationPage", when you click  "singUpButton".
        singUpButton.setOnAction(actionEvent -> {
            System.out.println("Hello registration page");
            SetRootPage.setRoot("registrationPage");
        });
//        Changing root scene on "userPage", when you click  "loginButton".
        loginButton.setOnAction(actionEvent -> {
            System.out.println("Hello user page");
            SetRootPage.setRoot("userPage");
        });

    }


}