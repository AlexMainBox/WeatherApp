package com.alexapp.controllers;

import com.alexapp.service.PoolService;
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
        PoolService poolService = new PoolService();

        //Changing root scene on "registrationPage", when you click  "singUpButton".
        singUpButton.setOnAction(actionEvent ->
                SetRootPage.setRoot("registrationPage"));

        //Changing root scene on "userPage", when you click  "loginButton".
        loginButton.setOnAction(actionEvent -> {
            if (poolService.logInUser(emailTextField.getText(), passwordTextField.getText())) {
                SetRootPage.setRoot("userPage");
                poolService.shutdownSession();
            } else textInfo.setText("Email or password not correct! Please, try again.");
        });
    }


}