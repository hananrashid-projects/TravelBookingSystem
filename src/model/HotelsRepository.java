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


public class HotelsRepository {
	
	public static List<Hotel>loadHotels() {
		 List<Hotel> hotels = new ArrayList<Hotel>(); 
		 
			ObjectInputStream in ;
			ObjectOutputStream out ;
			try {
				out = new ObjectOutputStream(new FileOutputStream("hotels.data"));
				Hotel h,h1,h2;
				h1=new Hotel("Sheraton","UK",1000.0, LocalDate.of(2021,10,12),1);
				h2=new Hotel("Sheraton","UK",1000.0, LocalDate.of(2021,10,12),1);
				
				out.writeObject(h1);
				out.writeObject(h2);
				out.writeObject(null); //have to write null to mark end of file
				out.close();

				System.out.println("Reading from Hotels file: ");
				in = new ObjectInputStream(new FileInputStream("hotels.data"));
				
				Object obj;
				while((obj=in.readObject())!=null) {
					h=(Hotel)obj;
					hotels.add(h);}
			}catch(IOException ioe) {
				System.out.println(ioe);
			}catch(ClassNotFoundException cnfe) {
				System.out.println(cnfe);}
	    	return hotels;
		}

	public static void  saveHotels(Hotel[] hotels) {
				ObjectOutputStream out ;
				try {
					out = new ObjectOutputStream(new FileOutputStream("flights.data"));
					System.out.printf("%d No of  loaded\n", hotels.length);
					for (Hotel f: hotels)
						System.out.println(f);
					out.writeObject(hotels);
					out.flush();
					out.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	}
	