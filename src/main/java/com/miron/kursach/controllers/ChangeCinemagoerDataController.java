package com.miron.kursach.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.miron.kursach.DB_settings.CashierService;
import com.miron.kursach.DB_settings.CinemagoerService;
import com.miron.kursach.DB_settings.SellingService;
import com.miron.kursach.DB_settings.TicketService;
import com.miron.kursach.HelloApplication;
import com.miron.kursach.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChangeCinemagoerDataController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add_cinemagoer;

    @FXML
    private ChoiceBox<String> cinemagoer_names;

    @FXML
    private ChoiceBox<String> cinemagoer_surname;

    @FXML
    private Button delete_cinemagoer;

    @FXML
    private TextField enter_cinemagoer_name;

    @FXML
    private TextField enter_cinemagoer_number;

    @FXML
    private TextField enter_cinemagoer_patronimic;

    @FXML
    private TextField enter_cinemagoer_surname;

    @FXML
    private Pane enter_cinemagoer_name_pane;

    @FXML
    private Pane enter_cinemagoer_surname_pane;

    @FXML
    private Pane enter_cinemagoer_patronimic_pane;

    @FXML
    private Pane enter_cinemagoer_number_pane;

    @FXML
    private ChoiceBox<String> ticket_date;

    @FXML
    private ChoiceBox<String> cashier_surname;

    @FXML
    private ChoiceBox<String> ticket_name;

    @FXML
    private Button return_page;

    private List<Ticket> tickets = TicketService.getTickets();
    private List<Cashier> cashiers = CashierService.getCashiers();
    private List<Cinemagoer> cinemagoers = CinemagoerService.getCinemagoers();
    private int id = 0;
    String surname;

    private void setMoviesToChoiceBox() {
        for(Ticket ticket : tickets){
            if(!ticket_name.getItems().contains(ticket.getMovieName())){
                ticket_name.getItems().add(ticket.getMovieName());
            }
        }
    }

    private void setCashiersToChoiceBox(){
        for (Cashier cashier: cashiers) {
            cashier_surname.getItems().add(cashier.getSurname());
        }
    }

    private void getTickets(ActionEvent event) {
        ticket_date.getItems().clear();
        String movieName = ticket_name.getValue();
        for(Ticket ticket : tickets){
            if(movieName.equals(ticket.getMovieName())) {
                ticket_date.getItems().add(ticket.getMovieTime());
            }
        }
    }

    private void searchTicketId(ActionEvent event){
        String ticketName = ticket_name.getValue();
        String ticketDate = ticket_date.getValue();
        for(Ticket ticket : tickets){
            if(ticketName.equals(ticket.getMovieName()) && ticketDate.equals(ticket.getMovieTime())) {
                System.out.println(ticket.getId());
                this.id = ticket.getId();
            }
        }
    }

    @FXML
    void initialize() {
        setMoviesToChoiceBox();
        setCinemagoersToChoiceBox();
        setCashiersToChoiceBox();

        add_cinemagoer.setOnAction(event -> {
            try {
                addCinemagoers();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        ticket_name.setOnAction(this::getTickets);
        ticket_date.setOnAction(this::searchTicketId);
        cinemagoer_names.setOnAction(this::getCinemagoers);
        cashier_surname.setOnAction(this::searchCashierSurname);
        delete_cinemagoer.setOnAction(event -> {
            try {
                deleteCinemagoer();
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

    private void searchCashierSurname(ActionEvent event) {
        String tempSurname = cashier_surname.getValue();
        for(Cashier cashier : cashiers){
            if(tempSurname.equals(cashier.getSurname())) {
                this.surname = cashier.getSurname();
            }
        }
    }

    private void deleteCinemagoer() throws IOException {
        CinemagoerService.deleteByNameANDSurname(cinemagoer_names.getValue(), cinemagoer_surname.getValue());
    }

    private void getCinemagoers(ActionEvent event) {
        cinemagoer_surname.getItems().clear();
        String cinemagoerName = cinemagoer_names.getValue();
        for(Cinemagoer cinemagoer : cinemagoers){
            if(cinemagoerName.equals(cinemagoer.getName())) {
                cinemagoer_surname.getItems().add(cinemagoer.getSurname());
            }
        }
    }

    private void setCinemagoersToChoiceBox() {
        for(Cinemagoer cinemagoer : cinemagoers){
            if(!cinemagoer_names.getItems().contains(cinemagoer.getName())){
                cinemagoer_names.getItems().add(cinemagoer.getName());
            }
        }
    }

    private void addCinemagoers() throws IOException {

        String cinemagoerName = enter_cinemagoer_name.getText();
        String cinemagoerSurame = enter_cinemagoer_surname.getText();
        String cinemagoerPatronimic = enter_cinemagoer_patronimic.getText();
        String cinemagoerNumber = enter_cinemagoer_number.getText();

        enter_cinemagoer_name_pane.setStyle("-fx-border-color: #FFF; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        enter_cinemagoer_surname_pane.setStyle("-fx-border-color: #FFF; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        enter_cinemagoer_patronimic_pane.setStyle("-fx-border-color: #FFF; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        enter_cinemagoer_number_pane.setStyle("-fx-border-color: #FFF; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        add_cinemagoer.setText("Додати користувача");

        if(cinemagoerName.length() <= 3) {
            enter_cinemagoer_name_pane.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        }
        else if(cinemagoerSurame.length() <= 3) {
            enter_cinemagoer_surname_pane.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        }
        else if(cinemagoerPatronimic.length() <= 3) {
            enter_cinemagoer_patronimic_pane.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        }
        else if(cinemagoerNumber.length() <= 6 || cinemagoerNumber.length() > 10) {
            enter_cinemagoer_number_pane.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        }
        else if(ticket_name.getValue() == null){
            ticket_name.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55;");
        }
        else if(ticket_date.getValue() == null){
            ticket_date.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55;");
        }
        else if(cashier_surname.getValue() == null){
            cashier_surname.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55;");
        }
        else {
            enter_cinemagoer_name.setText("");
            enter_cinemagoer_surname.setText("");
            enter_cinemagoer_patronimic.setText("");
            enter_cinemagoer_number.setText("");
            ticket_date.setValue("");
            ticket_name.setValue("");
            cashier_surname.setValue("");
            add_cinemagoer.setText("Додано");

            Cinemagoer cinemagoer = new Cinemagoer(cinemagoerName, cinemagoerSurame, cinemagoerPatronimic, cinemagoerNumber);
            TicketService.edit(id);
            CinemagoerService.add(cinemagoer);
            Ticket tempTicket = TicketService.getTicket(id);
            Cashier tempCashier = CashierService.getBySurname(surname);
            SellingService.add(new Selling(tempTicket, tempCashier, cinemagoer, tempTicket.getTicketValue(), tempTicket.getMovieTime()));

        }
    }
}
