package model;

import java.awt.Label;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BookingViewControllers {

    @FXML
    private DatePicker operationDatepicker;

    @FXML
    private Button exitButton;

    @FXML
    private Button findBookingsButton;

    @FXML
    private TableView<Bookable> operationTableView;

    @FXML
    private TableColumn<Flight, String> flightNumberCol,TakeOffCol,destinationCol;
    
  

    
    @FXML
    private TableColumn<Flight, Double> priceCol;
    
    ArrayList<Bookable> book = new ArrayList<Bookable>();
	BookingSystem bs=BookingSystem.bs; 
	ObservableList<Bookable> booked = FXCollections.observableArrayList(book);
   
    @FXML
	 public void initialize() {
		 flightNumberCol.setCellValueFactory(new PropertyValueFactory("FlightNo"));
	    	TakeOffCol.setCellValueFactory(new PropertyValueFactory("takeOff"));
	    	destinationCol.setCellValueFactory(new PropertyValueFactory("destination"));
	    	priceCol.setCellValueFactory(new PropertyValueFactory("Price"));
	    	
	    	
	 }

    @FXML
    void handleFindButton(ActionEvent event) {
    	try {
    	
     	booked.addAll(bs.getBooked(operationDatepicker.getValue()));
     	operationTableView.setItems(booked);
    	}catch(NullPointerException e) {
    		LocalDate d=operationDatepicker.getValue();
			while( d==null ){
				System.out.print("No date was picked!"); 
    			d=operationDatepicker.getValue();
    			}
    		booked.addAll(bs.getBooked(d));
         	operationTableView.setItems(booked);
    	}
    } 
     @FXML
     void handleExitButton(ActionEvent event) throws Exception {
     	Stage stage=(Stage)exitButton.getScene().getWindow();
     	Pane root = FXMLLoader.load(getClass().getResource("Main View.fxml"));
         stage.setScene(new Scene(root, 600, 400));
         stage.setTitle("Travel Booking System App");
         stage.show();

     	
     }

}
