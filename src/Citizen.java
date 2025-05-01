import java.time.LocalDate;

public class Citizen extends Customer {
	private int nationalNo;
	private String nationality;
	private LocalDate bDate;
	
	public Citizen(int id, String name, int nationalNo, String nationality, LocalDate bDate) {
		super(id, name);
		this.nationalNo = nationalNo;
		this.nationality = nationality;
		this.bDate = bDate;
	}

	public int getNationalNo() {
		return nationalNo;
	}

	public void setNationalNo(int nationalNo) {
		this.nationalNo = nationalNo;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public LocalDate getbDate() {
		return bDate;
	}

	public void setbDate(LocalDate bDate) {
		this.bDate = bDate;
	}

	@Override
	public String toString() {
		return super.toString() + 
				"\nCitizen  "
				+ "\nNational Number : " + nationalNo 
				+ "\nNationality : " + nationality 
				+ "\nBirth Date : " + bDate ;
	}

	
	
	
	
}
