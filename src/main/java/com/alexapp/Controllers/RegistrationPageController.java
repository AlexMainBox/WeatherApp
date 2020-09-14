package com.alexapp.Controllers;

import com.alexapp.Utils.SetRootPage;
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
    }
}
