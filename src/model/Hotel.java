package model;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Hanan Rashid, ID:2006354 - Nousseiba Boudaia, ID:202005430 - Noha Elgamal, ID: 201906140
 */
/**
 * Hotel class implements interface class Bookable
 */

public class Hotel implements Bookable,Serializable {
	/**
	 * The Name of the hotel
	 */
	private String name;
	/**
	 * The Location of the hotel
	 */
	private String location;
	/**
	 * The Room Price of the hotel
	 */
	private double roomPrice;
	/**
	 * The Booking Date of the hotel
	 */
	private LocalDate bookingDate;
	/**
	 * The no Of Rooms of the hotel
	 */
	private int noOfRooms;
	/**
	 * Booked Rooms'Array list of the hotel
	 */
	private ArrayList<Integer> bookedRooms = new ArrayList<Integer>();

	/**
	 * Default constructor of hotel
	 */
	public Hotel() {
	};

	/**
	 * @param name        of the hotel
	 * @param location    of the hotel
	 * @param roomPrice   of the hotel
	 * @param bookingDate of the hotel
	 * @param noOfRooms   of the hotel
	 */
	public Hotel(String name, String location, double roomPrice, LocalDate bookingDate, int noOfRooms) {

		this.name = name;
		this.location = location;
		this.roomPrice = roomPrice;
		this.bookingDate = bookingDate;
		this.noOfRooms = noOfRooms;
	}

	/**
	 * @return name of the hotel
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the parameter name to the class's name
	 * 
	 * @param name String representing the name of a hotel
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return location of the hotel
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * This method sets the parameter location to the class's location
	 * 
	 * @param location String representing the location of a hotel
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return roomPrice of the hotel
	 */
	public double getRoomPrice() {
		return roomPrice;
	}

	/**
	 * This method sets the parameter roomPrice to the class's roomPrice
	 * 
	 * @param roomPrice double representing the room Price of a hotel
	 */
	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	/**
	 * @return bookingDate of the hotel
	 */
	public LocalDate getBookingDate() {
		return bookingDate;
	}

	/**
	 * This method sets the parameter bookingDate to the class's bookingDate
	 * 
	 * @param bookingDate LocalDate representing the booking date of a hotel
	 */
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	/**
	 * @return noOfRooms of the hotel
	 */
	public int getNoOfRooms() {
		return noOfRooms;
	}

	/**
	 * This method sets the parameter noOfRooms to the class's noOfRooms
	 * 
	 * @param noOfRooms int representing the no Of Rooms of a hotel
	 */
	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	/**
	 * @return bookedRooms integer array list of the hotel
	 */
	public ArrayList<Integer> getBookedRooms() {
		return bookedRooms;
	}

	/**
	 * This method sets the parameter bookedRooms to the class's bookedRooms
	 * 
	 * @param bookedRooms int array list representing the booked Rooms of a hotel
	 */
	public void setBookedRooms(ArrayList<Integer> bookedRooms) {
		this.bookedRooms = bookedRooms;
	}

	/**
	 * This method take a seat number as a parameter,checks if the Number of rooms
	 * is greater than the array list of bookedRooms, then it adds the seatNumber in
	 * the bookedRooms array list, and returns true if not, returns false
	 * 
	 * @param seatNumber of a flight
	 * @return true or false
	 */
	@Override
	public boolean Book(int seatNumber) {
		if (this.noOfRooms > this.bookedRooms.size()) {
			this.bookedRooms.add(seatNumber);
			return true;
		} else
			return false;
	}

	/**
	 * The Method takes a hotel name and a Booking date (mm/dd/yy) from the user and
	 * sets them to the classes' name and flightDate(mm/dd/yy)
	 */
	public void input() {
		System.out.println("Booking a Hotel, Enter the required details:");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the hotel name: ");
		this.name = input.nextLine();
		System.out.println("Enter the Booking date (mm/dd/yy): ");
		String bookingdate = input.nextLine();
		this.bookingDate = dateInput(bookingdate);
	}

	/**
	 * @param userInput String representing a date as mm/dd/yy of the hotel The
	 *                  method turns the String date into a LocalDate date as
	 *                  mm-dd-yy
	 * @return date as a LocalDate
	 */
	public static LocalDate dateInput(String userInput) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
		LocalDate date = LocalDate.parse(userInput, dateFormat);
		System.out.println(date);
		return date;
	}

	/**
	 * @return Hotel's all details as a string Details: hotel's name, location, room
	 *         price, booking date,no of rooms, size of the bookedRooms
	 */
	@Override
	public String toString() {
		return "\nHotel Name : " + name + "\nLocation : " + location + "\nRoom Price : " + roomPrice
				+ "\nBooking Date : " + bookingDate + "\nNumber of Rooms=" + noOfRooms + "\nBooked Rooms :"
				+ bookedRooms.size() + "\n";
	}
}

