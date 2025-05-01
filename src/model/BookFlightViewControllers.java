package model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BookFlightViewControllers {

    @FXML
    private GridPane mainView;

    @FXML
    private Label TitleLabel;

    @FXML
    private TextField TakeOffTextFeild;

    @FXML
    private TextField destinationTextField;

    @FXML
    private TextField dateTextField;

    @FXML
    private Button OkButton;

    @FXML
    private Button CancelButton;
    
    @FXML
    public void initialize() {
    	
   }

    @FXML
    void handleCancelButton(ActionEvent event) {
    	Stage stage = (Stage) mainView.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void handleOkButton(ActionEvent event) {

    }

}
