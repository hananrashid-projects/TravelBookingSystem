
/**
 * @author Hanan Rashid, ID:2006354 - Nousseiba Boudaia, ID:202005430 - Noha Elgamal, ID: 201906140
 */
public interface Bookable {
	/**
	 * this method takes a seatnumber, and the body depends on classes using it.
	 * @param seatNumber of hotel or flight
	 */
	public boolean Book(int seatNumber); 
}