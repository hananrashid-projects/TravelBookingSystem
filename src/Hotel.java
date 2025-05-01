import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel implements Bookable {
	private String name;
	private String location;
	private double roomPrice;
	private LocalDate bookingDate;
	private int noOfRooms;
	private ArrayList<Integer> bookedRooms = new ArrayList<Integer>();
	
	
	public Hotel() {};
	
	public Hotel(String name, String location, double roomPrice, LocalDate bookingDate, int noOfRooms) {
		
		this.name = name;
		this.location = location;
		this.roomPrice = roomPrice;
		this.bookingDate = bookingDate;
		this.noOfRooms = noOfRooms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public ArrayList<Integer> getBookedRooms() {
		return bookedRooms;
	}

	public void setBookedRooms(ArrayList<Integer> bookedRooms) {
		this.bookedRooms = bookedRooms;
	}
	
	
	
	

	@Override
	public boolean Book(int seatNumber) {
		if (this.noOfRooms>this.bookedRooms.size()) {
			this.bookedRooms.add(seatNumber);
			return true;}
		else return false;
	}
	
	public void input() {
		Scanner input =new Scanner(System.in);
		System.out.println("Enter the hotel name: ");
		this.name=input.nextLine();
		System.out.println("Enter the Booking date (mm/dd/yy): ");
		String flightdate = input.nextLine();
		this.bookingDate=dateInput(flightdate);}
		
	
	public static LocalDate dateInput(String userInput) {

	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
	    LocalDate date = LocalDate.parse(userInput, dateFormat);

	    System.out.println(date);
	    return date ;
	}

	@Override
	public String toString() {
		return "\nHotel Name : " + name + 
				"\nLocation : " + location +
				"\nRoom Price : " + roomPrice +
				"\nBooking Date : "+bookingDate+
				 "\nNumber of Rooms=" + noOfRooms + 
				 "\nBooked Rooms :" + bookedRooms.size()+"\n";
	}
	
}
