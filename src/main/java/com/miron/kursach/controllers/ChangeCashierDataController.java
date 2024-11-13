package com.miron.kursach.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.miron.kursach.DB_settings.CashierService;
import com.miron.kursach.DB_settings.PaymentService;
import com.miron.kursach.HelloApplication;
import com.miron.kursach.models.Cashier;
import com.miron.kursach.models.Payment;
import com.miron.kursach.models.Something;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChangeCashierDataController <T>{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add_cashier;

    @FXML
    private ChoiceBox<String> cashier_names;

    @FXML
    private ChoiceBox<String> cashier_surnames;

    @FXML
    private Button delete_cashier;

    @FXML
    private TextField enter_cashier_address;

    @FXML
    private TextField enter_cashier_name;

    @FXML
    private TextField enter_cashier_number;

    @FXML
    private TextField enter_cashier_patronimic;

    @FXML
    private TextField enter_cashier_surname;

    @FXML
    private TextField enter_cinema_name;

    @FXML
    private Pane enter_cashier_name_pane;

    @FXML
    private Pane enter_cashier_surname_pane;

    @FXML
    private Pane enter_cashier_patronimic_pane;

    @FXML
    private Pane enter_cashier_number_pane;

    @FXML
    private Pane enter_cinema_name_pane;

    @FXML
    private Pane enter_cashier_address_pane;

    @FXML
    private Pane is_on_work_pane;

    @FXML
    private TextField enter_payment_name;

    @FXML
    private TextField enter_payment_salary;

    @FXML
    private Pane enter_cashier_name_pane1;

    @FXML
    private Pane enter_cashier_name_pane11;

    @FXML
    private Label is_on_work;

    @FXML
    private Button no_button;

    @FXML
    private Button return_page;

    @FXML
    private Button yes_button;

    private List<Cashier> cashiers = CashierService.getCashiers();
    private int OnDuty = 0;
    private boolean isOnDuty;
    private Something something;


    @FXML
    void initialize() {
        setCashiersToChoiceBox();

        yes_button.setOnAction(event -> {
            yes_button.setScaleX(1.2);
            yes_button.setScaleY(1.2);
            no_button.setScaleX(1.0);
            no_button.setScaleY(1.0);
            OnDuty = 1;
        });

        no_button.setOnAction(event -> {
            no_button.setScaleX(1.2);
            no_button.setScaleY(1.2);
            yes_button.setScaleX(1.0);
            yes_button.setScaleY(1.0);
            OnDuty = 2;
        });

        add_cashier.setOnAction(event -> {
            try {
                addCashiers(new Something<>().setValue("hello"))
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        cashier_names.setOnAction(this::getCashiers);
        delete_cashier.setOnAction(event -> {
            try {
                deleteCashier();
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

    private void deleteCashier() throws IOException {
        CashierService.deleteByNameANDSurname(cashier_names.getValue(), cashier_surnames.getValue());
    }

    private void getCashiers(ActionEvent event) {
        cashier_surnames.getItems().clear();
        String cashierName = cashier_names.getValue();
        for(Cashier cashier : cashiers){
            if(cashierName.equals(cashier.getName())) {
                cashier_surnames.getItems().add(cashier.getSurname());
            }
        }
    }

    private void setCashiersToChoiceBox() {
        for(Cashier cashier : cashiers){
            if(!cashier_names.getItems().contains(cashier.getName())){
                cashier_names.getItems().add(cashier.getName());
            }
        }
    }

    private void addCashiers(Something<T> something) throws IOException {
        T lol = something.getValue();
        String lol2 = (String) lol;
        String cashierName = enter_cashier_name.getText();

        String cashierSurame = enter_cashier_surname.getText();

        String cashierPatronimic = enter_cashier_patronimic.getText();

        String cashierAddress = enter_cashier_address.getText();

        String cashierCinema = enter_cinema_name.getText();

        String cashierNumber = enter_cashier_number.getText();
        String paymentName = enter_payment_name.getText();
        String paymentSalary = enter_payment_salary.getText();

        enter_cashier_name_pane.setStyle("-fx-border-color: #FFF; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        enter_cashier_surname_pane.setStyle("-fx-border-color: #FFF; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        enter_cashier_patronimic_pane.setStyle("-fx-border-color: #FFF; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        enter_cashier_address_pane.setStyle("-fx-border-color: #FFF; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        enter_cinema_name_pane.setStyle("-fx-border-color: #FFF; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        enter_cashier_number_pane.setStyle("-fx-border-color: #FFF; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        enter_cashier_name_pane11.setStyle("-fx-border-color: #FFF; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        enter_cashier_name_pane1.setStyle("-fx-border-color: #FFF; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        is_on_work_pane.setStyle("-fx-border-color: #FFF; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        add_cashier.setText("Додати касира");

        if(cashierName.length() <= 3) {
            enter_cashier_name_pane.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        }
        else if(cashierSurame.length() <= 3) {
            enter_cashier_surname_pane.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        }
        else if(cashierPatronimic.length() <= 3) {
            enter_cashier_patronimic_pane.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        }
        else if(cashierNumber.length() <= 6 || cashierNumber.length() > 10) {
            enter_cashier_number_pane.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        }
        else if(cashierCinema.length() <= 3) {
            enter_cinema_name_pane.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        }
        else if(cashierAddress.length() <= 3) {
            enter_cashier_address_pane.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        }
        else if(OnDuty == 0) {
            is_on_work_pane.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        }
        else if(paymentName.length() < 3) {
            enter_cashier_name_pane11.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        }
        else if(paymentSalary.isEmpty()) {
            enter_cashier_name_pane1.setStyle("-fx-border-color: #e06249; -fx-background-color: #557C55; -fx-border-radius: 15; -fx-background-radius: 15;");
        }
        else {
            enter_cashier_name.setText("");
            enter_cashier_surname.setText("");
            enter_cashier_patronimic.setText("");
            enter_cashier_address.setText("");
            enter_cinema_name.setText("");
            enter_cashier_number.setText("");
            enter_payment_salary.setText("");
            enter_payment_name.setText("");
            add_cashier.setText("Додано");

            if(OnDuty == 1)
                isOnDuty = true;
            else
                isOnDuty = false;

            Cashier cashier = new Cashier(cashierName, cashierSurame, cashierPatronimic, cashierNumber, cashierCinema, cashierAddress, isOnDuty);
            CashierService.add(cashier);
            Payment payment = new Payment(Integer.parseInt(paymentSalary), paymentName, cashier);
            PaymentService.add(payment);
        }
    }
}
