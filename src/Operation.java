import java.time.LocalDate;

public class Operation {
	
	private Customer customer;
	private LocalDate operationDate;
	private String type;
	private Bookable book;
	
	public Operation(Customer customer, LocalDate operationDate, String type,Bookable Book) {
		
		this.customer = customer;
		this.operationDate = operationDate;
		this.type = type;
		this.book=Book;
	}
	
	public Bookable getBook() {
		return book;
	}

	public void setBook(Bookable book) {
		this.book = book;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LocalDate getOperationDate() {
		return operationDate;
	}
	public void setOperationDate(LocalDate operationDate) {
		this.operationDate = operationDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
			return "\nOperation Details:\n" + customer + 
					"\nOperation Date :" + operationDate + 
					"\nType : " + type+"\n";
		}
	
	
	
	
	
	
}
