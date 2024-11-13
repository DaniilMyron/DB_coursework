module com.miron.kursach {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires java.persistence;
    requires java.transaction;
    requires org.hibernate.commons.annotations;
    requires org.hibernate.orm.core;


    opens com.miron.kursach to javafx.fxml;
    exports com.miron.kursach;
    opens com.miron.kursach.controllers to javafx.fxml;
    exports com.miron.kursach.controllers;
    exports com.miron.kursach.DB_settings;
    exports com.miron.kursach.models;
    opens com.miron.kursach.models to org.hibernate.orm.core;
    opens com.miron.kursach.DB_settings to javafx.fxml, org.hibernate.orm.core;
}