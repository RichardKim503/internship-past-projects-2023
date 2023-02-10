package program3;

/**
 * <p>
 * Title: The Airline Class
 * </p>
 * 
 * <p>
 * Description: A class that contains information about<br>
 * an airplane object.
 * </p>
 * 
 * @author Richard Kim (n00923815)
 */
public class Airline {

	private String flightID;	// The plane's id
	private long entered;		// The time the plane entered the queue
	private long exited;		// The time the plane exited the queue
	
	
	/**
	 * <p>Airline</p>
	 * 
	 * The constructor for an airline
	 * 
	 * @param i The ID
	 * @param st The time the plane entered
	 */
	public Airline(String i, long st) {
		this.flightID = i;
		this.entered = st;
	}
	
	
	/**
	 * <p>getId</p>
	 * 
	 * @return the flight's id
	 */
	public String getID() {
		return flightID;
	}
	
	
	/**
	 * <p>getEntered</p>
	 * 
	 * @return the time entered
	 */
	public long getEntered() {
		return entered;
	}
	
	
	/**
	 * <p>getExited</p>
	 * 
	 * @return the time exited
	 */
	public long getExited() {
		return exited;
	}
	
	
	/**
	 * <p>setEntered</p>
	 * 
	 * @param st the entered time to change to
	 */
	public void setEntered(long st) {
		this.entered = st;
	}
	
	
	/**
	 * <p>setExited</p>
	 * 
	 * @param ed the exited time to change to
	 */
	public void setExited(long ed) {
		this.entered = ed;
	}
	
	
	/**
	 * <p>toString</p>
	 * 
	 * @return the state of the Airline object.
	 */
	public String toString() {
		String str = "Flight ID: " + flightID + "\n" + 
		"Entered Time: " + entered + "\n" +
		"Exited Time: " + exited;
		
		return str;
	}
}
