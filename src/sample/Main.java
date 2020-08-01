package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Main extends Application {

        @Override
    public void start(Stage primaryStage) throws Exception{

            Parent root = FXMLLoader.load(getClass().getResource("LOGIN.fxml"));
        primaryStage.setTitle("E_LEARNING");
        primaryStage.setScene(new Scene(root, 600, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {

    launch(args);
    }
}
