package model;

import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainViewControllers {

    @FXML
    private Label TitleLable;

    @FXML
    private Button HotelsButton;

    @FXML
    private Button FlightsButton;

    @FXML
    private Button BookingsButton;

    @FXML
    void handleBookings(ActionEvent event) throws IOException {
    	Stage stage=(Stage)BookingsButton.getScene().getWindow();
    	BorderPane root=FXMLLoader.load(getClass().getResource("BookingView.fxml"));
    	stage.setTitle("Booking App");
		stage.setScene(new Scene(root, 600, 400));
    }

    @FXML
    void handleFlights(ActionEvent event) throws IOException {
    	Stage stage=(Stage)FlightsButton.getScene().getWindow();
    	BorderPane root=FXMLLoader.load(getClass().getResource("FlightsView.fxml"));
    	stage.setTitle("Flight App");
		stage.setScene(new Scene(root, 600, 500));
    }
    @FXML
    void handleHotels(ActionEvent event) throws IOException {
    	Stage stage=(Stage)HotelsButton.getScene().getWindow();
    	BorderPane root = FXMLLoader.load(getClass().getResource("HotelsView.fxml"));
		stage.setTitle("Hotel App");
		stage.setScene(new Scene(root, 500, 400));

    }

	
}
