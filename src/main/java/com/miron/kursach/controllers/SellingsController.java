package com.miron.kursach.controllers;

import com.miron.kursach.DB_settings.SellingService;
import com.miron.kursach.HelloApplication;
import com.miron.kursach.models.Selling;
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

public class SellingsController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button;

    @FXML
    private TableColumn<Selling, Integer> cashier_id;

    @FXML
    private TableColumn<Selling, Integer> cinemagoer_id;

    @FXML
    private TableColumn<Selling, String> movie_date;

    @FXML
    private TableColumn<Selling, Integer> movie_price;

    @FXML
    private TableColumn<Selling, Integer> selling_id;

    @FXML
    private TableColumn<Selling, Integer> ticket_id;

    @FXML
    private TableView<Selling> ticket_table;

    @FXML
    void initialize() {
        selling_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        ticket_id.setCellValueFactory(new PropertyValueFactory<>("ticket"));
        cashier_id.setCellValueFactory(new PropertyValueFactory<>("cashier"));
        cinemagoer_id.setCellValueFactory(new PropertyValueFactory<>("cinemagoer"));
        movie_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        movie_price.setCellValueFactory(new PropertyValueFactory<>("price"));

        ticket_table.setItems(sellings);

        back_button.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                HelloApplication.setScene("main_activity.fxml", stage, 565,  290);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private ObservableList<Selling> sellings = FXCollections.observableArrayList(
            SellingService.getSellings());
}
