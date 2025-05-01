package model;
/**
 * @author Hanan Rashid, ID:2006354 - Nousseiba Boudaia, ID:202005430 - Noha Elgamal, ID: 201906140
 */
public class Customer {
	/**
	 * The id of the customer
	 */
	private int id;
	/**
	 * The Name of the customer
	 */
	private String name;
	
	/**
	 * @param The id of the customer
	 * @param The Name of the customer
	 */
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id of the customer
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method sets the parameter id to the class's id
	 * @param id integer representing the id of a customer
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the Name of the customer.
	 */
	public String getName() {
		return name;
	}
	/**
	 *This method sets the parameter name to the class's name
	 *@param name String representing the name of a customer
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *@return Customer's all details as a string
	 *Details: id and name
	 */
	@Override
	public String toString() {
		return "Customer Id : "+ id
				+ "\nName : " + name+"\n";
				
	}
}
