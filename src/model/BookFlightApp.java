package model;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BookFlightApp extends Application {

    @Override
    public void start(Stage stage) throws Exception{
    	
            Parent root = FXMLLoader.load(getClass().getResource("BookFlightView.fxml"));
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle("Book Flight App");
            stage.show();

    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
