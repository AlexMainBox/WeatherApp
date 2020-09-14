package com.alexapp.Controllers;

import com.alexapp.Utils.ParserPages;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class UserController {

    @FXML
    private TextField cityTextField;

    @FXML
    private Button okButton;

    @FXML
    private Text minDegreesField, nowDegreesField, maxDegreesField,errorField, infoText;

    @FXML
    private Label cityLabel;

    private void dateReset() {          //reset all field on page
        infoText.setText("");
        cityLabel.setText("");
        errorField.setText("");
        nowDegreesField.setText("");
        maxDegreesField.setText("");
        minDegreesField.setText("");
    }


    @FXML
    void initialize() {
        //Check your input date, if it's not null - add your tex to url and set infoText field.
        okButton.setOnAction(actionEvent -> {
            try {
                dateReset();
                ParserPages.setPage(cityTextField.getText());           //take your city and add to url.
                infoText.setText(ParserPages.infoText());               // set info text.
                maxDegreesField.setText(ParserPages.maxDegrees());
                minDegreesField.setText(ParserPages.minDegrees());
                cityLabel.setText(ParserPages.cityLabel());
                nowDegreesField.setText(ParserPages.nowDegreesField());

            } catch (NullPointerException | IOException e) {
                dateReset();
                errorField.setText("Error: City isn not correct,please enter the city!");
                System.out.println("Please enter the city!");

            }
        });


    }
}

