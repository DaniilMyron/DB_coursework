package com.miron.kursach.controllers;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.miron.kursach.DB_settings.TicketService;
import com.miron.kursach.HelloApplication;
import com.miron.kursach.models.Ticket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class ChangeDataController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button add_movie;
    @FXML
    private Button delete_movie;
    @FXML
    private TextField enter_movie_date;
    @FXML
    private TextField enter_movie_name;
    @FXML
    private TextField enter_ticket_value;
    @FXML
    private Pane enter_movie_name_pane;
    @FXML
    private Pane enter_ticket_value_pane;
    @FXML
    private Pane enter_movie_date_pane;
    @FXML
    private ChoiceBox<String> movie_date;
    @FXML
    private Button return_page;
    @FXML
    private ChoiceBox<String> movie_names;
    private List<Ticket> tickets = TicketService.getTickets();

    @FXML
    void initialize() {
        setMoviesToChoiceBox();

        add_movie.setOnAction(event -> {
            try {
                addMovie();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        movie_names.setOnAction(this::getTickets);
        delete_movie.setOnAction(event -> {
            try {
                deleteMovie();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return_page.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                HelloApplication.setScene("main_activity.fxml", stage, 565,  290);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void deleteMovie() throws IOException {
        TicketService.deleteByNameANDDate(movie_names.getValue(), movie_date.getValue());
    }

    private void getTickets(ActionEvent event) {
        movie_date.getItems().clear();
        String movieName = movie_names.getValue();
        for(Ticket ticket : tickets){
            if(movieName.equals(ticket.getMovieName())) {
                movie_date.getItems().add(ticket.getMovieTime());
            }
        }
    }

    private void setMoviesToChoiceBox() {
        for(Ticket ticket : tickets){
            if(!movie_names.getItems().contains(ticket.getMovieName())){
                movie_names.getItems().add(ticket.getMovieName());
            }
        }
    }

    private void addMovie() throws IOException {

        String movieName = enter_movie_name.getText();
        String ticketValue = enter_ticket_value.getText();
        String movieDate = enter_movie_date.getText();

        enter_movie_name_pane.setStyle("-fx-border-color: #FFF; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        enter_ticket_value_pane.setStyle("-fx-border-color: #FFF; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        enter_movie_date_pane.setStyle("-fx-border-color: #FFF; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        add_movie.setText("Додати фільм");

        if(movieName.length() <= 3) {
            enter_movie_name_pane.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        }
        else if(ticketValue.isEmpty()) {
            enter_ticket_value_pane.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        }
        else if(!movieDate.contains(".")) {
            enter_movie_date_pane.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        }
        else {
            enter_movie_name.setText("");
            enter_ticket_value.setText("");
            enter_movie_date.setText("");
            add_movie.setText("Додано");

            Ticket ticket = new Ticket(movieName, Integer.parseInt(ticketValue), movieDate);
            TicketService.add(ticket);
        }
    }
}
