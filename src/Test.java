
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		
		Customer cr1= new Customer(30180,"Ahmed");
		Customer cr2= new Citizen(56070,"Roaa",6678, "Qatar",LocalDate.of(2000,1,1));
		Customer cr3= new Company(34830,"United", "5548", "AlWakra",LocalDate.of(2021,10,1));
		Customer cr4= new Customer(35455,"Omar");

		
		Flight bf3 = new Flight("A222",1,"UK","QATAR",5000.0,LocalDate.of(2021,10,12));
		Flight bf1 = new Flight("A234",1,"US","QATAR",5500.0,LocalDate.of(2021,10,12));
		Flight bf2 = new Flight("B333",2,"US","UAE",4000.0,LocalDate.of(2021,4,11));
		Hotel bh1 = new Hotel("Sheraton","UK",1000.0, LocalDate.of(2021,10,12),1);
		Hotel bh2 = new Hotel("Four Seasons","US",1200.0,LocalDate.of(2021,4,12),70);
		
		Flight f1=new Flight();
		Hotel h1=new Hotel();
		
		System.out.println("-----------------------------------");
		BookingSystem bs= new BookingSystem(); 
		
		 //Add methods are working..
		bs.addBookable(bf1); bs.addBookable(bf2); bs.addBookable(bf3);
		bs.addBookable(bh1);  bs.addBookable(bh2);
		bs.addCustomer(cr1); bs.addCustomer(cr2); bs.addCustomer(cr3);
		System.out.println(bs.getCustomers());
		
	   /* System.out.println("To find a customer, Enter an Id:");
		int id=input.nextInt();
		System.out.println(bs.findCustomer(id)); //it's working..
		System.out.println("-----------------------------------");
		
		/*bs.deleteCustomer(cr3); //it's working..
		System.out.println(bs.getCustomers());
		System.out.println("-----------------------------------");*/
		
		f1.input();
		bs.makeFlightBooking(cr1, f1,1); //it's working..
		System.out.println("-----------------------------------");
		
		f1.input();
		bs.makeFlightBooking(cr2, f1,2); //it's working..
		System.out.println("-----------------------------------");
		
		h1.input();
		bs.makeHotelBooking(cr4, h1,3); //it's working..
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
		
		
		System.out.println("-----------------------------------");
		
		System.out.println(bs.getBookableByAvailability(true));//it's working..
		System.out.println("-----------------------------------");
		
		System.out.println(bs.getBooked(LocalDate.of(2021,10,12)));
		//System.out.println(bs.generateCustomerReport());
		System.out.println("-----------------------------------");
		
		System.out.println(bs.getOperations());
		//System.out.println("-----------------------------------");
	}
	
}

		
		
