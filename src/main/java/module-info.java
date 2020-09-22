module com.alexapp {
    exports com.alexapp;

    requires javafx.controls;
    requires javafx.fxml;
    requires jsoup;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires com.fasterxml.classmate;
    requires net.bytebuddy;
    requires java.xml.bind;
    requires com.sun.xml.bind;


    opens com.alexapp to com.fasterxml.classmate;
    opens com.alexapp.dao to java.sql;
    opens com.alexapp.controllers to javafx.fxml;
    opens com.alexapp.service to com.fasterxml.classmate;
    opens com.alexapp.entity to org.hibernate.orm.core;
}