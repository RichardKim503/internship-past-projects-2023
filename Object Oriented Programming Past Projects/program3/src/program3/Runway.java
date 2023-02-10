package program3;

/**
 * <p>
 * Title: The Runway Class
 * </p>
 * 
 * <p>
 * Description: Simulates a runway from an airport that<br>
 * takes in departing and arriving airplanes.
 * </p>
 * 
 * @author Richard Kim (n00923815)
 */
public class Runway extends Thread {

	private Arrival arrival;		// Thread for arriving airplanes
	private Departure departure;	// Thread for departing airplanes
	private boolean running = true;	// Determines if the thread is running or not
	
	
	/**
	 * <p>Runway</p>
	 * 
	 * The constructor for the runway class
	 * 
	 * @param a The Arriving airplane thread
	 * @param d The departing airplane thread
	 */
	public Runway(Arrival a, Departure d) {
		this.arrival = a;
		this.departure = d;
	}
	
	
	/**
	 * <p>stopRunning</p>
	 * 
	 * Stops the runway thread from running
	 */
	public void stopRunning() {
		running = false;
	}
	
	
	/**
	 * <p>run</p>
	 * 
	 * Runs the runway thread.
	 */
	public void run() {		
		while(running) {
			try {
				Airline tempArrival = arrival.getQueue().dequeue();
				System.out.println("Minute: " + ((System.currentTimeMillis() - arrival.getTime())/1000) + 
						" - Flight " + tempArrival.getID() + " cleared for landing." + 
						" - Entered Queue at " + ((System.currentTimeMillis() - arrival.getTime())/1000) +
						" - waited " + (arrival.getNextTime()/1000) + " mins");
				System.out.println();
				
				Airline tempDeparture = departure.getQueue().dequeue();
				System.out.println("Minute: " + ((System.currentTimeMillis() - departure.getTime())/1000) + 
						" - Flight " + tempDeparture.getID() + " cleared for takeoff." + 
						" - Entered Queue at " + ((System.currentTimeMillis() - departure.getTime())/1000) +
						" - waited " + (departure.getNextTime()/1000) + " mins");
				System.out.println();
			} catch(QueueEmptyException e) {
				
			}
			
		}
	}
	
	
	/**
	 * <p>toString</p>
	 * 
	 * @return the state of the runway thread
	 */
	public String toString() {
		String str = "Arrival state: " + arrival.toString() + "\n" +
		"Departure state: " + departure.toString() + "\n" +
		"Is running: " + running;
		
		return str;
	}
}