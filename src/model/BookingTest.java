package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Hanan Rashid, ID:2006354 - Nousseiba Boudaia, ID:202005430 - Noha Elgamal, ID: 201906140
 */
public class BookingTest {
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		System.out.println("\t\tWelcome To The Booking System");
		System.out.println("-----------------------------------");
		BookingSystem bs= new BookingSystem(); //Creating object of BookingSystem class
		
		System.out.println("Available Bookings Hotel/Flights:");
		System.out.println(bs.getBookableByAvailability(true));
		System.out.println("-----------------------------------");

		
		//Creating customer objects (customer/citizen/company)
		Customer cr1= new Customer(30180,"Ahmed");
		Customer cr2= new Citizen(56070,"Roaa",6678, "Qatar",LocalDate.of(2020,1,1));
		Customer cr3= new Company(34830,"United", "5548", "AlWakra",LocalDate.of(2021,10,1));
		Customer cr4= new Customer(35455,"Omar");

		//Creating objects of Flight and Hotel with default and paramitarized constructor.
		Flight f1=new Flight();
		Hotel h1=new Hotel();
		
		Flight bf3 = new Flight("A222",1,"UK","QATAR",5000.0,LocalDate.of(2021,10,12));
		Flight bf1 = new Flight("A234",1,"US","QATAR",5500.0,LocalDate.of(2021,10,12));
		Flight bf2 = new Flight("B333",2,"US","UAE",4000.0,LocalDate.of(2021,4,11));
		Hotel bh1 = new Hotel("Sheraton","UK",1000.0, LocalDate.of(2021,10,12),1);
		Hotel bh2 = new Hotel("Four Seasons","US",1200.0,LocalDate.of(2021,4,12),70);

		//Adding Flight and Hotel's object to the Bookable arraylist in BookingSystem class
		bs.addBookable(bf1); bs.addBookable(bf2); bs.addBookable(bf3);
		bs.addBookable(bh1); bs.addBookable(bh2);
		bs.addCustomer(cr1); bs.addCustomer(cr2); bs.addCustomer(cr3);bs.addCustomer(cr4);
		
		//Printing all customers in the BookingSystem class
		System.out.println("All Customer's Information:");
		System.out.println(bs.generateCustomerReport());
		System.out.println("-----------------------------------");
		
		//Finding Customer using id
		System.out.println("To Find a Customer, Enter an Id:");
		int id=input.nextInt();
		System.out.println(bs.findCustomer(id)); 
		System.out.println("-----------------------------------");
		
		System.out.println("To Find a Customer, Enter an Id:");
		int id1=input.nextInt();
		System.out.println(bs.findCustomer(id1));
		System.out.println("-----------------------------------");
		
		//Deleting a customer's object and printing the customers again
		System.out.println("Deleting customer 3:");
		bs.deleteCustomer(cr3); 
		System.out.println(bs.getCustomers());
		
		//letting user enter required details using input method for hotel or flight then using that details,
		//customer's objects, and seat number as a parameter to make their bookings
		System.out.println("-----------------------------------");
		f1.input();
		bs.makeFlightBooking(cr1, f1,1); 
		System.out.println("-----------------------------------");
		
		f1.input();
		bs.makeFlightBooking(cr2, f1,2);
		System.out.println("-----------------------------------");
		
		h1.input();
		bs.makeHotelBooking(cr4, h1,3);
		System.out.println("-----------------------------------");

		h1.input();
		bs.makeHotelBooking(cr3, h1,3);
		System.out.println("-----------------------------------");
		
		h1.input();
		bs.makeHotelBooking(cr4, h1,3);
		System.out.println("-----------------------------------");
		
		f1.input();
		bs.makeFlightBooking(cr4, f1,2); 
		System.out.println("-----------------------------------");
		
		//Displays Available Bookings Hotel/Flights in the Booking System
		System.out.println("Available Bookings Hotel/Flights:");
		System.out.println(bs.getBookableByAvailability(true));
		System.out.println("-----------------------------------");
		
		//Displays Booked Flight/Hotel on the Specified Date in the Booking System
		System.out.println("Booked Flight/Hotel on the Specified Date: ");
		System.out.println(bs.getBooked(LocalDate.of(2021,10,12))); 
		System.out.println("-----------------------------------");
		
		//Displays all the objects' toString inside the Operations list in the Booking System
		System.out.println("Operation List:");
		System.out.println(bs.getOperations());
		System.out.println("-----------------------------------");
	}
	
}

		
		
					