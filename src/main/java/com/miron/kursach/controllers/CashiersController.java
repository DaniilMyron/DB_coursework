package com.miron.kursach.controllers;

import com.miron.kursach.DB_settings.CashierService;
import com.miron.kursach.HelloApplication;
import com.miron.kursach.models.Cashier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CashiersController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button;

    @FXML
    private TableColumn<Cashier, String> cinema_adress;

    @FXML
    private TableColumn<Cashier, String> cinema_name;

    @FXML
    private TableColumn<Cashier, Integer> cinemagoer_id;

    @FXML
    private TableColumn<Cashier, String> cinemagoer_name;

    @FXML
    private TableColumn<Cashier, String> cinemagoer_number;

    @FXML
    private TableColumn<Cashier, String> cinemagoer_patronymic;

    @FXML
    private TableColumn<Cashier, String> cinemagoer_surname;

    @FXML
    private TableView<Cashier> cinemagoer_table;

    @FXML
    void initialize() {
        cinemagoer_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        cinemagoer_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        cinemagoer_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        cinemagoer_patronymic.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        cinemagoer_number.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        cinema_name.setCellValueFactory(new PropertyValueFactory<>("cinemaName"));
        cinema_adress.setCellValueFactory(new PropertyValueFactory<>("address"));

        cinemagoer_table.setItems(cashiers);

        back_button.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                HelloApplication.setScene("main_activity.fxml", stage, 565,  290);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private ObservableList<Cashier> cashiers = FXCollections.observableArrayList(
            CashierService.getCashiers());
}
