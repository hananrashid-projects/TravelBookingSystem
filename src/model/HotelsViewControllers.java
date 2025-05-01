package model;

import java.io.IOException;

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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.AddHotelViewControllers.AddHotelInteraction;

public class HotelsViewControllers implements AddHotelInteraction {

	@FXML
	private Button addButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Button updateButton;

	@FXML
	private Button exitButton;

	@FXML
	private TableView<Hotel> HotelTableView;

	@FXML
	private TableColumn<Hotel, String> nameCol, locationCol;

	@FXML
	private TableColumn<Hotel, Double> roomPriceCol;

	@FXML
	private TableColumn<Hotel, Integer> numberOfRoomsCol;
	//Hanan Added
	static ObservableList<Hotel> hotels = FXCollections.observableArrayList(HotelsRepository.loadHotels());

	@FXML
	public void initialize() {
		nameCol.setCellValueFactory(new PropertyValueFactory("name"));
		locationCol.setCellValueFactory(new PropertyValueFactory("location"));
		roomPriceCol.setCellValueFactory(new PropertyValueFactory("roomPrice"));
		numberOfRoomsCol.setCellValueFactory(new PropertyValueFactory("noOfRooms"));

		HotelTableView.setItems(hotels);
	}
	@FXML
	void handleAddButton(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AddHotelView.fxml"));
		try {
			Parent root = loader.load();
			AddHotelViewControllers controller = loader.getController();
			controller.setInteraction(this);
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			HotelTableView.setItems(hotels);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleDeleteButton(ActionEvent event) {
		int index = HotelTableView.getSelectionModel().getSelectedIndex();
		hotels.remove(index);
		HotelTableView.setItems(hotels);
	}
	@FXML
	void handleUpdateButton(ActionEvent event) {
		int index = HotelTableView.getSelectionModel().getSelectedIndex();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AddHotelView.fxml"));
		try {
			Parent root = loader.load();
			AddHotelViewControllers controller = loader.getController();
			controller.setInteraction(this);
			controller.setValues(hotels.get(index));
			hotels.remove(index);
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			HotelTableView.setItems(hotels);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    @FXML
    void handleExitButton(ActionEvent event) throws IOException {
    	Stage stage=(Stage)exitButton.getScene().getWindow();
    	Pane root = FXMLLoader.load(getClass().getResource("Main View.fxml"));
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Travel Booking System App");
        stage.show();
    }
	public void saveHotel(Hotel hotel) {
		hotels.add(hotel);
	}
}
