import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Flight implements Bookable{
	
	private String FlightNo;
	private ArrayList<Integer> bookedSeats= new ArrayList<Integer>();
	private int capacity;
	private String destination;
	private String takeOff;
	private double Price;
	private LocalDate flightDate;
	
	

	
	public Flight() {
		
	} 
	
	public Flight(String destination, String takeOff,LocalDate flightDate) {
		this.destination = destination;
		this.takeOff = takeOff;
		this.flightDate = flightDate;
		
	}
	
	
	public Flight(String flightNo, int capacity, String destination, String takeOff,
			double price, LocalDate flightDate) {
		FlightNo = flightNo;
		this.capacity = capacity;
		this.destination = destination;
		this.takeOff = takeOff;
		Price = price;
		this.flightDate = flightDate;
		
	}

	
	

	public String getFlightNo() {
		return FlightNo;
	}

	public void setFlightNo(String flightNo) {
		FlightNo = flightNo;
	}

	public ArrayList<Integer> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(ArrayList<Integer> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTakeOff() {
		return takeOff;
	}

	public void setTakeOff(String takeOff) {
		this.takeOff = takeOff;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	@Override
	public boolean Book(int seatNumber) {
		if (this.capacity>this.bookedSeats.size()) {
			this.bookedSeats.add(seatNumber);
			return true;}
		else return false;
	}
	
	public static LocalDate dateInput(String userInput) {

	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
	    LocalDate date = LocalDate.parse(userInput, dateFormat);

	    System.out.println(date);
	    return date ;
	}
	
	
	
	public void input() {
		Scanner input =new Scanner(System.in);
		System.out.println("Enter the take off: ");
		this.takeOff=input.nextLine();
		System.out.println("Enter the destinaton: ");
		this.destination=input.nextLine();
		System.out.println("Enter the flight date (mm/dd/yy): ");
		String flightdate = input.nextLine();
		this.flightDate=dateInput(flightdate);
		
		
	}
	
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
