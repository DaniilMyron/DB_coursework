package com.miron.kursach.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.miron.kursach.HelloApplication;
import com.miron.kursach.models.Role;
import com.miron.kursach.models.SelectRole;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RoleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button admin_btn;

    @FXML
    private Button cashier_btn;

    @FXML
    private Button redactor_btn;

    private static SelectRole role;
    @FXML
    void initialize() {
        admin_btn.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                role = new SelectRole(Role.ADMIN);
                HelloApplication.setScene("main_activity.fxml", stage, 565,  290);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        cashier_btn.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                role = new SelectRole(Role.CASHIER);
                HelloApplication.setScene("main_activity.fxml", stage, 565,  290);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        redactor_btn.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                role = new SelectRole(Role.REDACTOR);
                HelloApplication.setScene("main_activity.fxml", stage, 565,  290);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}