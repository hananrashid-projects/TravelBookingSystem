package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FlightsRepository {

	public static List<Flight> loadFlights() {
		 List<Flight> flights = new ArrayList<Flight>(); 
		 
			ObjectInputStream in ;
			ObjectOutputStream out ;
			
			try {
				out = new ObjectOutputStream(new FileOutputStream("flights.data"));
				Flight f,f1,f2,f3;
				 f1=new Flight("A222",10,"UK","QATAR",5000.0,LocalDate.of(2021,10,12));
				 f2=new Flight("B222",5,"USA","KUWAIT",5000.0,LocalDate.of(2021,5,12));
				 f3=new Flight("C222",2,"KUL","QATAR",5000.0,LocalDate.of(2021,5,12));
				
				out.writeObject(f1);
				out.writeObject(f2);
				out.writeObject(f3);
				out.writeObject(null); //have to write null to mark end of file
				out.close();

				System.out.println("Reading from flights file: ");
				in = new ObjectInputStream(new FileInputStream("flights.data"));
				
				Object obj;
				while((obj=in.readObject())!=null) {
					f=(Flight)obj;
					flights.add(f);}
			}catch(IOException ioe) {
				System.out.println(ioe);
			}catch(ClassNotFoundException cnfe) {
				System.out.println(cnfe);
			}
		
	    	return flights;
		}


	public static void saveFlights(Flight[] flights) throws IOException  {
				ObjectOutputStream out ;
					out = new ObjectOutputStream(new FileOutputStream("flights.data"));
					System.out.printf("%d No of  loaded\n", flights.length);
					for (Flight f: flights)
						System.out.println(f);
					out.writeObject(flights);
					out.flush();
					out.close();
	}
	}