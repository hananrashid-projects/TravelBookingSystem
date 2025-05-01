package model;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddHotelViewControllers {

	@FXML
	private GridPane mainView;

	@FXML
	private Label TitleLabel;

	@FXML
	private TextField hotelnameTextField;

	@FXML
	private TextField hotellocationTextField;

	@FXML
	private TextField roompriceTextField;

	@FXML
	private TextField numberOfroomsTextField;

	@FXML
	void handleCancelButton(ActionEvent event) {
		Stage stage = (Stage) mainView.getScene().getWindow();
		stage.close();
	}

	@FXML
	void handleOkButton(ActionEvent event) {
		Hotel hotel = new Hotel();
		hotel.setName(hotelnameTextField.getText());
		hotel.setLocation(hotellocationTextField.getText());
		hotel.setRoomPrice(Double.parseDouble(roompriceTextField.getText()));
		hotel.setNoOfRooms(Integer.parseInt(numberOfroomsTextField.getText()));
		//Hanan added. not sure
		BookingSystem.bs.makeHotelBooking(null, hotel, Integer.parseInt(numberOfroomsTextField.getText()));
		//
		interaction.saveHotel(hotel);

		handleCancelButton(null);
	}
	
	public void setValues(Hotel hotel) {
		hotelnameTextField.setText(hotel.getName());
		hotellocationTextField.setText(hotel.getLocation());
		roompriceTextField.setText(Double.toString(hotel.getRoomPrice()));
		numberOfroomsTextField.setText(Integer.toString(hotel.getNoOfRooms()));
	}
	
	private AddHotelInteraction interaction;

	public void setInteraction(AddHotelInteraction interaction) {
		this.interaction = interaction;
	}

	public interface AddHotelInteraction{
		public void saveHotel(Hotel hotels);
	}

}
