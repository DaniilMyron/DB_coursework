package com.miron.kursach.controllers;

import com.miron.kursach.DB_settings.TicketService;
import com.miron.kursach.HelloApplication;
import com.miron.kursach.models.Ticket;
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
import java.util.Iterator;
import java.util.ResourceBundle;

public class TicketsController{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button;

    @FXML
    private TableView<Ticket> ticket_table;

    @FXML
    private TableColumn<Ticket, Integer> ticket_id;

    @FXML
    private TableColumn<Ticket, String> ticket_movie_name;

    @FXML
    private TableColumn<Ticket, String> ticket_movie_time;

    @FXML
    private TableColumn<Ticket, Integer> ticket_moviegoer_count;

    @FXML
    private TableColumn<Ticket, Integer> ticket_ticket_value;

    @FXML
    void initialize() {
        ticket_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        ticket_movie_name.setCellValueFactory(new PropertyValueFactory<>("movieName"));
        ticket_moviegoer_count.setCellValueFactory(new PropertyValueFactory<>("moviegoerCount"));
        ticket_ticket_value.setCellValueFactory(new PropertyValueFactory<>("ticketValue"));
        ticket_movie_time.setCellValueFactory(new PropertyValueFactory<>("movieTime"));

        ticket_table.setItems(tickets);

        back_button.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                HelloApplication.setScene("main_activity.fxml", stage, 565,  290);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private ObservableList<Ticket> tickets = FXCollections.observableArrayList(
            TicketService.getTickets());


}
