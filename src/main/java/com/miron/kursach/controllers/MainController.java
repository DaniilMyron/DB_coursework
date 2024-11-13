package com.miron.kursach.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.miron.kursach.HelloApplication;
import com.miron.kursach.models.Role;
import com.miron.kursach.models.SelectRole;
import com.miron.kursach.models.Ticket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button change_cashier_button;
    @FXML
    private Button change_cinemagoers_button;
    @FXML
    private Button change_info_button;
    @FXML
    private Button check_sellings_btn;
    @FXML
    private Button check_tickets_btn;
    @FXML
    private Button check_worker_btn;

    private final Role role = SelectRole.getRole();

    @FXML
    void initialize() {
        if(role != Role.REDACTOR) {
            change_info_button.setOnAction(event -> {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                try {
                    HelloApplication.setScene("change_data.fxml", stage, 500, 300);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        if(role != Role.REDACTOR) {
            change_cinemagoers_button.setOnAction(event -> {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                try {
                    HelloApplication.setScene("change_cinemagoers_data.fxml", stage, 578, 334);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        if(role != Role.REDACTOR) {
            change_cashier_button.setOnAction(event -> {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                try {
                    HelloApplication.setScene("change_cashier_data.fxml", stage, 700, 378);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        if(role != Role.CASHIER) {
            check_tickets_btn.setOnAction(event -> {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                try {
                    HelloApplication.setScene("tickets.fxml", stage, 600, 400);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        if(role != Role.CASHIER) {
            check_worker_btn.setOnAction(event -> {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                try {
                    HelloApplication.setScene("cashiers.fxml", stage, 739, 400);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        if(role != Role.CASHIER) {
            check_sellings_btn.setOnAction(event -> {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                try {
                    HelloApplication.setScene("sellings.fxml", stage, 600, 400);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}

