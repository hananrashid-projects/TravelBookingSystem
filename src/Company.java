import java.time.LocalDate;

public class Company extends Customer {
	private String licenseNo;
	private String location;
	private LocalDate expiryDate;
	
	public Company(int id, String name, String licenseNo, String location, LocalDate expiryDate) {
		super(id, name);
		this.licenseNo = licenseNo;
		this.location = location;
		this.expiryDate = expiryDate;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return super.toString() + 
				" \nCompany "
				+"\nLicense Number : "+ licenseNo 
				+"\nLocation : " + location 
				+" \nExpiry Date :" + expiryDate ;
	}

	

	
	
	
}
