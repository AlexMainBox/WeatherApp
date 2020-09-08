module com.alexapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.alexapp to javafx.fxml;
    exports com.alexapp;
}