package model;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.ObservableList;

/**
 * @author Hanan Rashid, ID:2006354 - Nousseiba Boudaia, ID:202005430 - Noha Elgamal, ID: 201906140
 */


public class BookingSystem {
	static BookingSystem bs=new BookingSystem();


	/**
	 * customers' array list of the booking system
	 */
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	/**
	 * operations' array list of the booking system
	 */
	private ArrayList<Operation> operations = new ArrayList<Operation>();
	/**
	 * bookables' array list of the booking system
	 */
	private ArrayList<Bookable> bookables = new ArrayList<Bookable>();
	
	/**
	 * Default constructor for BookingSystem
	 */
	public BookingSystem() {}
	/**
	 * @return customers' arraylist of the booking system
	 */
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	/**
	 * This method sets the parameter customers to the class's customers
	 * @param customers arraylist representing the customers of a booking system
	 */
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	/**
	 * @return the bookables of the booking system
	 */
	public ArrayList<Bookable> getBookables() {
		return bookables;
	}

	/**
	 * @param bookables the bookables to set
	 */
	public void setBookables(ArrayList<Bookable> bookables) {
		this.bookables = bookables;
	}
	
	/**
	 * @return operations of the booking system
	 */
	public ArrayList<Operation> getOperations() {
		return operations;
	}
	
	/**
	 * This method sets the parameter operations to the class's operations
	 * @param operations ArrayList<Operation> representing the operations of a booking system
	 */
	public void setOperations(ArrayList<Operation> operations) {
		this.operations = operations;
	}
	
	
	/**
	 * @param customer Customer representing a customer's object.
	 * The method takes a customer, checks if its not null, and whether the customer's id exists inside the
	 * customers arraylist, if it exists the customer will be removed from customers' arraylist.
	 */
	public void deleteCustomer(Customer customer) {
		boolean available=false;
		if(customer!=null) {
			for(Customer c: customers) {
					if(c.getId()==customer.getId())
						available=true;}
			if(available==true)
				customers.remove(customer);}
		}
	
	/**
	 * 
	 * @return customers: returns all the customers' informations, by call their toString method.
	 */
	public String generateCustomerReport() {
		return customers.toString();
	}

	/**
	 * @param customer Customer representing a customer's object.
	 * The method takes a customer, checks if its not null, and whether the customer's id exists inside the
	 * customers arraylist, if it does not exist the customer will be added to the customers arraylist.
	 */
	public void addCustomer(Customer customer) {
		boolean available=false;
		if(customer!=null) {
			for(Customer c: customers) {
					if(c.getId()==customer.getId())
						available=true;}
			if(available==false)
				customers.add(customer);}
		}
	
	/**
	 * The method takes an id of a customer(citizen/company), if the customer is founded
	 * inside the customers arraylist, it returns the customer(the object), if not returns null
	 * @param id integer representing an id of a customer(citizen/company)
	 * @return Customer object or null
	 */
	public Customer findCustomer(int id) {
		for(Customer c: customers) {
			if (c.getId()==id)
				return c;}
		System.out.println("No such customer was found!\nCustomer: ");
		return null;}
	
	/**
	 * Takes a parameter bookable and adds it to the bookables array list.
	 * @param bookable Bookable representing either a fight or hotel.
	 */
	public void addBookable(Bookable bookable) {
		bookables.add(bookable);
	}

	
	
	/**
	 * This method takes a customer, flight, and seatNumber, first iterates over bookables list using for loop,
	 * and checks if the bookable object is an instance of flight,then it checks if the flight exists inside the
	 * bookables' arraylist with the same destination, take off and the flight date, if it exists, it'll take the
	 * seatNumber to check if there are available seats using Book() method in flight class,if yes,it'll add the 
	 * customer, flight date, Type=flight,and that flight(bookable object) inside the operation array list.
	 * @param customer(company/citizen)
	 * @param flight object
	 * @param seatNumber of the flight
	 */
    public ObservableList<Flight> flights = FlightsViewControllers.flights;
    
	public void makeFlightBooking(Customer customer, Flight flight, int seatNumber) {
		//added
		int index=0;
		for(Bookable book: bookables) {
			if(book instanceof Flight ) {
				if (((Flight) book).getDestination().equalsIgnoreCase(flight.getDestination()) &&
						((Flight) book).getTakeOff().equalsIgnoreCase(flight.getTakeOff()) &&
								((Flight) book). getFlightDate().equals(flight. getFlightDate())){
					//Added
					 seatNumber=BookFlightlViewControllers.seatAvailable(flights.get(index));

					 
					if (((Flight) book).Book(seatNumber)) {
						operations.add(new Operation(customer,((Flight) book).getFlightDate(),"Flight",flight));
						//Added
				    	flights.set(index,flights.get(index));
					}	
				}index++;
			}
		}
	}
	
					       

	/**
	 * This method takes a customer, hotel, and roomNumber, first iterates over bookables list using for loop,
	 * and checks if the bookable object is an instance of hotels,then it checks if the hotel exists inside the
	 * bookables' arraylist with the same hotel name, if it exists, it'll take the roomNumber to check if there are
	 * available seats using Book() method in hotel class,if yes,it'll add the customer, hotel booking date,
	 * Type=hotel,and that hotel(bookable object) inside the operation array list.
	 * @param customer(citizen/company)
	 * @param hotel object
	 * @param roomNumber of the hotel
	 */
	public void makeHotelBooking(Customer customer, Hotel hotel, int roomNumber) {
		for(Bookable book: bookables) {
			if(book instanceof Hotel) {
					if(((Hotel) book).getName().equalsIgnoreCase((hotel.getName()))) {
						if(((Hotel)book).Book(roomNumber)) 
						operations.add(new Operation(customer,((Hotel) book).getBookingDate(),"Hotel",hotel));
					}
			}
		}
	}
					
			            
	/**
	 * This method uses for loop to iterate over bookables array list,returns an array list of all the available 
	 * bookable objects(flights) which didnt reach its full capacity and all the available bookable objects(hotels)
	 * which didnt reach its full no Of Rooms. if the bookables list is empty returns null.
	 * @param available representing Availability of flights/hotels
	 * @return availables: returns list of all available flights/hotels(bookable objects) not fully booked. or null.
	 */
		public ArrayList<Bookable> getBookableByAvailability(boolean available) {
			ArrayList<Bookable> availableFlights = new ArrayList<Bookable>();
			ArrayList<Bookable> availableHotels= new ArrayList<Bookable>();
			ArrayList<Bookable> availables= new ArrayList<Bookable>();
			  if (bookables.size() == 0) {
		           System.out.print("No flights or hotels are available...");
		           return null;
		      }
			for (Bookable book : bookables) {
				if(book instanceof Flight)
					if (((Flight)book).getCapacity()>((Flight)book).getBookedSeats().size())
						availableFlights.add(book);
				if(book instanceof Hotel)
					if (((Hotel)book).getNoOfRooms()>((Hotel)book).getBookedRooms().size())
						availableHotels.add(book);
			}
			availables.addAll(availableFlights);
			availables.addAll(availableHotels);
			return availables;
		}
		
		
		
	/**
	 * Returns an arraylist of all bookable objects that are booked on the same date as the date 
	 * passed to the object
	 * @param date of available bookings hotels/flights in that date
	 * @return BookedByDate's Array List of Bookable
	 */
		

		public ArrayList<Bookable> getBooked(LocalDate date) {
			ArrayList<Bookable> BookedFlights = new ArrayList<Bookable>();
			ArrayList<Bookable> BookedHotels = new ArrayList<Bookable>();
			ArrayList<Bookable> BookedByDate = new ArrayList<Bookable>();
			
				for(Bookable book:bookables) {
					
					if(book instanceof Flight) {
						if(date.compareTo(((Flight)book).getFlightDate())==0) {
							if(((Flight)book).getBookedSeats().size()>0)
							BookedFlights .add(book);}}
					if(book instanceof Hotel) {
						if(date.compareTo(((Hotel)book).getBookingDate())==0) {
							if(((Hotel)book).getBookedRooms().size()>0)
							BookedHotels.add(book);}}
					      }	  
				  
		           BookedByDate.addAll(BookedHotels); BookedByDate.addAll(BookedFlights );
			         return BookedByDate;
	   }
}

	



			
			
			
			
	