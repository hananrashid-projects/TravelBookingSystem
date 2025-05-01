package model;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author Hanan Rashid, ID:2006354 - Nousseiba Boudaia, ID:202005430 - Noha Elgamal, ID: 201906140
 */
/**
 * Flight class implements interface class Bookable
 *
 */
public class Flight implements Bookable,Serializable{
	/**
	 * Flight Number of the Flight
	 */
	private String FlightNo;
	/**
	 * Array list of bookedSeats of the Flight
	 */
	private ArrayList<Integer> bookedSeats= new ArrayList<Integer>();
	/**
	 * Capacity of the Flight
	 */
	private int capacity;
	/**
	 * Destination of the Flight
	 */
	private String destination;
	/**
	 * Take Off place for the Flight
	 */
	private String takeOff;
	/**
	 * Price of the Flight
	 */
	private double Price;
	/**
	 * Flight Date of the Flight
	 */
	private LocalDate flightDate;
	
	
	/** 
	 * Default constructor of Flight
	 */
	public Flight() {
	} 
	
	/**
	 * @param flightNo of the flight
	 * @param capacity of the flight
	 * @param destination of the flight
	 * @param takeOff of the flight
	 * @param price of the flight
	 * @param flightDate of the flight
	 */
	public Flight(String flightNo, int capacity, String destination, String takeOff,
			double price, LocalDate flightDate) {
		FlightNo = flightNo;
		this.capacity = capacity;
		this.destination = destination;
		this.takeOff = takeOff;
		Price = price;
		this.flightDate = flightDate;
	}
	
	/**
	 * @return FlightNo of the flight
	 */

	public String getFlightNo() {
		return FlightNo;
	}
	/**
	 *This method sets the parameter flightNo to the class's flightNo
	 *@param flightNo String representing the flight number of a flight
	 */
	public void setFlightNo(String flightNo) {
		FlightNo = flightNo;
	}
	/**
	 * @return bookedSeats: 's integer array list of the flight
	 */
	public ArrayList<Integer> getBookedSeats() {
		return bookedSeats;
	}
	/**
	 *This method sets the parameter bookedSeats to the class's bookedSeats
	 *@param bookedSeats ArrayList<Integer> representing the arrary list Booked seats of a flight
	 */
	public void setBookedSeats(ArrayList<Integer> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	/**
	 * @return Capacity of a flight
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 *This method sets the parameter capacity to the class's capacity
	 *@param capacity integer representing the capacity of a flight
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * @return destination of a flight
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 *This method sets the parameter destination to the class's destination
	 *@param destination Strign representing the destination of a flight
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return takeoff of a flight
	 */
	public String getTakeOff() {
		return takeOff;
	}
	/**
	 *This method sets the parameter takeOff to the class's takeOff
	 *@param takeOff String representing the take Off of a flight
	 */
	public void setTakeOff(String takeOff) {
		this.takeOff = takeOff;
	}
	/**
	 * @return Price of the flight
	 */
	public double getPrice() {
		return Price;
	}
	/**
	 *This method sets the parameter price to the class's price
	 *@param price double representing the price of a flight
	 */
	public void setPrice(double price) {
		Price = price;
	}
	/**
	 * @return flightDate of the flight
	 */
	public LocalDate getFlightDate() {
		return flightDate;
	}
	/**
	 *This method sets the parameter flightDate to the class's flightDate
	 *@param object LocalDate representing the flight date of a flight
	 */
	public void setFlightDate(Object object) {
		this.flightDate = (LocalDate) object;
	}
	
	/**
	 * This method take a seat number as a parameter,checks if the capacity is greater than the 
	 * size of the bookedseats array list then it adds the seatNumber in the bookedseats list, 
	 * and returns true. if not, returns false
	 * @param seatNumber of a flight
	 * @return true or false
	 */
	@Override
	public boolean Book(int seatNumber) {
		if (this.capacity>this.bookedSeats.size()) {
			this.bookedSeats.add(seatNumber);
			return true;}
		else return false;
	}
	/**
	 * @param userInput String representing a date as mm/dd/yy
	 * The method turns the String date into a LocalDate as mm-dd-yy
	 * @return date as a LocalDate 
	 */
	public static LocalDate dateInput(String userInput) {
	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
	    LocalDate date = LocalDate.parse(userInput, dateFormat);
	    System.out.println(date);
	    return date ;
	}
	
	/**
	 * The Method takes a take off and a destination,flight date(mm/dd/yy) from the user
	 * and sets them to the classes' take off and destination, and flight date(mm/dd/yy)
	 */
	public void input() {
		System.out.println("Booking a Flight, Enter the required details:");
		Scanner input =new Scanner(System.in);
		System.out.println("Enter the destinaton: ");
		this.destination=input.nextLine();
		System.out.println("Enter the take off: ");
		this.takeOff=input.nextLine();
		System.out.println("Enter the flight date (mm/dd/yy): ");
		String flightdate = input.nextLine();
		this.flightDate=dateInput(flightdate);
	}
	/**
	 *@return Flight 's all details as a string
	 *Details are:FlightNo, size of bookedSeats, capacity,destination,takeOff, Price, flightDate
	 */
	@Override
	public String toString() {
		return "\nFlight Number : " + FlightNo+
				"\nBooked Seats : " + bookedSeats.size() + 
				"\nCapacity : " + capacity+
				"\nDestination : " + destination + 
				"\nTake Off : " + takeOff + 
				"\nPrice :" + Price +
				"\nFlight Date : "+flightDate
				+"\n";
				
	}
}
