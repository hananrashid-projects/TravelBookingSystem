package model;

import java.time.LocalDate;
/**
 * 
 * @author Hanan Rashid, ID:2006354 - Nousseiba Boudaia, ID:202005430 - Noha Elgamal, ID: 201906140
 *
 */
/**
 * This class Citizen inherits the class Customer
 */
public class Citizen extends Customer {
	
	/**
	 * The National Number of the Citizen
	 */
	private int nationalNo;
	/**
	 * The Nationality of the Citizen
	 */
	private String nationality;
	/**
	 * The bDate of the Citizen
	 */
	private LocalDate bDate;
	
	/**
	 * @param id of the Citizen
	 * @param name of the Citizen
	 * @param nationalNo of the Citizen
	 * @param nationality of the Citizen
	 * @param bDate of the Citizen
	 */
	public Citizen(int id, String name, int nationalNo, String nationality, LocalDate bDate) {
		super(id, name);
		this.nationalNo = nationalNo;
		this.nationality = nationality;
		this.bDate = bDate;
	}

	/**
	 * @return nationalNo of the Citizen
	 */
	public int getNationalNo() {
		return nationalNo;
	}

	/**This method sets the parameter nationalNo to the class's nationalNo
	 * @param nationalNo integer represents the national Number of a citizen
	 */
	public void setNationalNo(int nationalNo) {
		this.nationalNo = nationalNo;
	}

	/**
	 * @return nationality of the citizen
	 */
	public String getNationality() {
		return nationality;
	}
	/**This method sets the parameter nationality to the class's nationality
	 * @param nationality String representing the nationality of a citizen
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	/**
	 * @return bDate of the citizen
	 */
	public LocalDate getbDate() {
		return bDate;
	}
	/**This method sets the parameter bDate to the class's bDate
	 * @param bDate LocalDate representing the bDate of a cizizen
	 */
	public void setbDate(LocalDate bDate) {
		this.bDate = bDate;
	}
	/**
	 *@return all the details of the citizen as a string 
	 *Details: customer's id and name, national number, nationality, birth date
	 */
	@Override
	public String toString() {
		return super.toString()+
				"\nCitizen's Details:\nNational No : " + nationalNo +
				"\nNationality : " + nationality +
				"\nbirth Date :" + bDate +"\n" ;
	}
	
}