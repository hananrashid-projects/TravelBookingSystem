package model;
import java.time.LocalDate;

/**
 * @author Hanan Rashid, ID:2006354 - Nousseiba Boudaia, ID:202005430 - Noha Elgamal, ID: 201906140
 */
/**
 * The company class inherits customer class
 */
public class Company extends Customer {
	/**
	 * The license Number of the company
	 */
	private String licenseNo;
	/**
	 * The location of the company
	 */
	private String location;
	/**
	 * The expiryDate of the company
	 */
	private LocalDate expiryDate;
	
	/**
	 * @param id of the company's customer
	 * @param name of the company's customer
	 * @param licenseNo of the company
	 * @param location of the company
	 * @param expiryDate of the company
	 */
	public Company(int id, String name, String licenseNo, String location, LocalDate expiryDate) {
		super(id, name);
		this.licenseNo = licenseNo;
		this.location = location;
		this.expiryDate = expiryDate;
		}
	/**
	 * @return licenseNo of the company
	 */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
	 * This method sets the parameter licenseNo to the class's licenseNo
	 * @param licenseNo String representing the licenseNo of a company
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	/**
	 * @return location of the company
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * This method sets the parameter location to the class's location
	 * @param location String representing the location of a company
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return expiryDate of the company
	 */
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	/**
	 * This method sets the parameter expiryDate to the class's expiryDate
	 * @param expiryDate LocalDate representing the expiryDate of a company
	 */
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 *@return all the details of the company as string
	 *Details: Customer's id and name, license Number, location, expiry Date
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\nCompany's Details:\nLicense No : " +licenseNo
				+ "\nLocation : " + location + 
				"\nExpiryDate : " + expiryDate +"\n";
	}
	
}