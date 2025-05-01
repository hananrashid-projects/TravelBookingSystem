package model;
import java.time.LocalDate;

/**
 * @author Hanan Rashid, ID:2006354 - Nousseiba Boudaia, ID:202005430 - Noha Elgamal, ID: 201906140
 */

public class Operation {
	/**
	 * customer(citizen/company) of the operation
	 */
	private Customer customer;
	/**
	 * operationDate of the operation
	 */
	private LocalDate operationDate;
	/**
	 * type of the operation(hotel/flight)
	 */
	private String type;
	/**
	 * book as in(flight/hotel)
	 */
	private Bookable book;
	
	
	
	/**
	 * @param customer
	 * @param operationDate
	 * @param type
	 * @param Book
	 */
	public Operation(Customer customer, LocalDate operationDate, String type,Bookable Book) {
		this.customer = customer;
		this.operationDate = operationDate;
		this.type = type;
		this.book=Book;
	}
	/**
	 * @return book of bookable object(hotels/flights)
	 */
	public Bookable getBook() {
		return book;
	}
	/**
	 *This method sets the parameter book to the class's book
	 *@param book Bookable representing the book of a bookable ojects(hotel/flight)
	 */
	public void setBook(Bookable book) {
		this.book = book;
	}
	/**
	 * @return customer object of Customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 *This method sets the parameter customer to the class's customer
	 *@param customer Customer representing the customer of a Customer ojects
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return operationDate of flight date or hotel booking date
	 */
	public LocalDate getOperationDate() {
		return operationDate;
	}
	/**
	 *This method sets the parameter operationDate to the class's operationDate
	 *@param operationDate LocalDate representing the operation Date of of flight date or hotel booking date
	 */
	public void setOperationDate(LocalDate operationDate) {
		this.operationDate = operationDate;
	}
	/**
	 * @return type: Hotel or Flight
	 */
	public String getType() {
		return type;
	}
	/**
	 *This method sets the parameter type to the class's type
	 *@param type String representing the type : Hotel or Flight
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 *@return all the details of the operation as string 
	 *Details: customer, operationDate, and type(hotel or flight)
	 */
	@Override
	public String toString() {
		return "\nOperation Details:\n" + customer + 
				"\nOperation Date :" + operationDate + 
				"\nType : " + type+"\n";
	
		}
}

