package model;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FlightApp extends Application {

    @Override
    public void start(Stage stage) throws Exception{
    	String viewFileName = "FlightsView.fxml";
		String windowTite = "Flight Booking App";
		Parent root = FXMLLoader.load(getClass().getResource(viewFileName));
		stage.setTitle(windowTite);
		stage.setScene(new Scene(root, 600, 500));
		stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
