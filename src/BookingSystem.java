import java.time.LocalDate;
import java.util.ArrayList;




public class BookingSystem {
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Operation> operations = new ArrayList<Operation>();
	private ArrayList<Bookable> bookables = new ArrayList<Bookable>();
	
	
	public BookingSystem() {}
	
	
	

	/**
	 * @return the customers
	 */
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	/**
	 * @return the bookables
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

	public ArrayList<Operation> getOperations() {
		return operations;
	}
	public void setOperations(ArrayList<Operation> operations) {
		this.operations = operations;
	}
	
	

	
	
	public void deleteCustomer(Customer customer) {
		boolean available=false;
		if(customer!=null) {
			for(Customer c: customers) {
					if(c.getId()==customer.getId())
						available=true;}
			if(available==true)
				customers.remove(customer);}
		}
	
	
	
	public String generateCustomerReport() {
		return customers.toString();
	}
	
	
	
	public void addCustomer(Customer customer) {
		boolean available=false;
		if(customer!=null) {
			for(Customer c: customers) {
					if(c.getId()==customer.getId())
						available=true;}
			if(available==false)
				customers.add(customer);}
		}
	
	
	public Customer findCustomer(int id) {
		for(Customer c: customers) {
			if (c.getId()==id)
				return c;}
		System.out.println("No such customer was found! ");
		return null;}
	
	//
	public void addBookable(Bookable bookable) {
		bookables.add(bookable);
	}

	public void deleteBookable(Bookable bookable) {
		bookables.remove(bookable);
	}
	//
	
	
	
	
	public void makeFlightBooking(Customer customer, Flight flight, int seatNumber) {
		for(Bookable book: bookables) {
			if(book instanceof Flight ) {
				if (((Flight) book).getDestination().equalsIgnoreCase(flight.getDestination()) &&
						((Flight) book).getTakeOff().equalsIgnoreCase(flight.getTakeOff()) &&
								((Flight) book). getFlightDate().equals(flight. getFlightDate())) {
					if (((Flight) book).Book(seatNumber)) {
						operations.add(new Operation(customer,((Flight) book).getFlightDate(),"Flight",flight));   
						
					            }
				         }
				
		          }
			} 
	}

		
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
