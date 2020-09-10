module com.alexapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires jsoup;

    opens com.alexapp;
    opens com.alexapp.Controllers to javafx.fxml;
    exports com.alexapp;
    exports com.alexapp.Controllers;


}