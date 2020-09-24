package com.alexapp.controllers;

import com.alexapp.service.UserPoolService;
import com.alexapp.utils.SetRootPage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginPageController {

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button singUpButton, loginButton;

    @FXML
    private TextField emailTextField;

    @FXML
    private Text textInfo;

    @FXML
    void initialize() {
        UserPoolService userPoolService = new UserPoolService();

        //Changing root scene on "registrationPage", when you click  "singUpButton".
        singUpButton.setOnAction(actionEvent ->
                SetRootPage.setRoot("registrationPage"));

        //Changing root scene on "userPage", when you click  "loginButton".
        loginButton.setOnAction(actionEvent -> {
            if (userPoolService.logInUser(emailTextField.getText(), passwordTextField.getText())) {
                SetRootPage.setRoot("userPage");
                userPoolService.shutdownSession();
            } else textInfo.setText("Email or password not correct! Please, try again.");
        });
    }


}