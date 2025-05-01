package model;

import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BookFlightlViewControllers {

    @FXML
    private GridPane mainView;

    @FXML
    private Label TitleLabel;

    @FXML
    private TextField TakeOffTextFeild;

    @FXML
    private TextField destinationTextField;

    @FXML
    private TextField FlightDateTextField;

    @FXML
    private Button OkButton;

    @FXML
    private Button CancelButton;
    
    @FXML //to close the window .
    void handleCancelButton(ActionEvent event) {
    	Stage stage=(Stage)TakeOffTextFeild.getScene().getWindow();
    	stage.close();
    }
    //Created a flgihts observable which is static
    public ObservableList<Flight> flights = FlightsViewControllers.flights;
    //Already own static object in Booking System
    BookingSystem bs= BookingSystem.bs;
   
    @FXML
   void handleOkButton(ActionEvent event) throws IOException {
    	//addding flights individually. instead of adding a whole list of flight inside the list of bookable
        for(Flight flight:flights) {
        	if(!(bs.getBookables().contains(flight))) 
        	bs.addBookable(flight);}

    	Flight flight=new Flight();
    	flight.setDestination(destinationTextField.getText());
    	flight.setTakeOff(TakeOffTextFeild.getText());
    	flight.setFlightDate(flight.dateInput(FlightDateTextField.getText()));
    	bs.makeFlightBooking(null, flight, 0);
        	handleCancelButton(null);}
    	
    /**Method: Alows to book a random seat from the flight if its capcity isnt full yet**/
    public static int seatAvailable(Flight flight){
    	Random r =new Random();
    	int seatNum=r.nextInt(flight.getCapacity())+1;
    	while(flight.getBookedSeats().contains(seatNum)){
        	seatNum=r.nextInt(flight.getCapacity());
    	}
    	return seatNum;
    	
    }
}