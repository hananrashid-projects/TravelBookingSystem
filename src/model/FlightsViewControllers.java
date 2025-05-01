package model;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FlightsViewControllers{

    @FXML
    private Button exitButton;

    @FXML
    private Button bookFlightButton;

    @FXML
    private TableView<Flight> TableViewController;

    @FXML
    private TableColumn<Flight, String> FlightNumberCol;

    @FXML
    private TableColumn<Flight, String> TakeOffCol;

    @FXML
    private TableColumn<Flight, String> DestinationCol;

    @FXML
    private TableColumn<Flight, Integer> CapacityCol;

    @FXML
    private TableColumn<Flight, Double> PriceCol;

    @FXML
    private TableColumn<Flight, ArrayList<Integer>> BookedSeatsCol;
    
   public static ObservableList<Flight> flights = FXCollections.observableArrayList(FlightsRepository.loadFlights());
    
    @FXML
    public void initialize() {
    	FlightNumberCol.setCellValueFactory(new PropertyValueFactory("FlightNo"));
    	TakeOffCol.setCellValueFactory(new PropertyValueFactory("takeOff"));
    	DestinationCol.setCellValueFactory(new PropertyValueFactory("destination"));
    	CapacityCol.setCellValueFactory(new PropertyValueFactory("capacity"));
    	PriceCol.setCellValueFactory(new PropertyValueFactory("Price"));
    	BookedSeatsCol.setCellValueFactory(new PropertyValueFactory("bookedSeats"));
    	 
    	TableViewController.setItems(flights);}

    @FXML//Not suree
    void handleBookFlightButton(ActionEvent event) throws IOException {
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("BookFlightView.fxml"));
    	Parent root=loader.load();
    	BookFlightlViewControllers controller=loader.getController();
    	Scene scene=new Scene(root);
    	Stage stage=new Stage();
    	stage.setScene(scene);
    	stage.show();
    	TableViewController.setItems(flights);
    	

    	
    	
    	
    }

    @FXML
    void handleExitButton(ActionEvent event) throws IOException {
    	Stage stage=(Stage)exitButton.getScene().getWindow();
    	Pane root = FXMLLoader.load(getClass().getResource("Main View.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Travel Booking System App");
        stage.show();

    }

}
 

