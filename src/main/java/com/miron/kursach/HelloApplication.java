package com.miron.kursach;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        setScene("role.fxml", stage, 600, 292);
    }

    public static void main(String[] args) {
        launch();
    }

    public static void setScene(String fxmlName, Stage stage, double v, double v1) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlName));
        Scene scene = new Scene(fxmlLoader.load(), v, v1);
        stage.setTitle("Cinema");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}