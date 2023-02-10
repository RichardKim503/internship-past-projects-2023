package program3;
import java.util.*;

/**
 * <p>
 * Title: The Departure Class
 * </p>
 * 
 * <p>
 * Description: A thread for departing airplanes.
 * </p>
 * 
 * @author Richard Kim (n00923815)
 */
public class Departure extends Thread {

	private ArrayQueue<Airline> queue;	// The queue for departing airplanes
	private final long time;			// The takeoff duration
	private boolean running = true;		// Determines if the thread is running or not
	private int nextTime;				// The randomized time
	
	
	/**
	 * <p>Departure</p>
	 * 
	 * The constructor for the departure thread.
	 * 
	 * @param l The time
	 */
	public Departure(long l) {
		queue = new ArrayQueue<Airline>();
		this.time = l;
	}
	
	
	/**
	 * <p>getQueue</p>
	 * 
	 * @return the queue of departing airplanes
	 */
	public Queue<Airline> getQueue(){
		return queue;
	}
	
	
	/**
	 * <p>getTime</p>
	 * 
	 * @return the time
	 */
	public long getTime() {
		return time;
	}
	
	
	/**
	 * <p>getNextTime</p>
	 * 
	 * @return 
	 */
	public int getNextTime() {
		return nextTime;
	}
	
	
	/**
	 * <p>stopRunning</p>
	 * 
	 * Stops the departure thread from running
	 */
	public void stopRunning() {
		running = false;
	}
	
	
	/**
	 * <p>run</p>
	 * 
	 * Runs the departure thread.
	 */
	public void run() {
		while(running) {
			try {
				Random rng = new Random();
				String flightId = SimulationTime.AIRLINES[rng.nextInt(18)] + rng.nextInt(30);
				int nextTime = SimulationTime.timeTillNext(10000);
				
				Airline a = new Airline(flightId, time);
				queue.enqueue(a);
				
				System.out.println("Minute: " + ((System.currentTimeMillis() - time)/1000) + " - " +
				"Added flight " + flightId + " to departure Queue");
				System.out.println("Random wait time before next departure: " + (nextTime/1000));
				System.out.println();
				
				sleep(nextTime);
			} catch(InterruptedException e) {
				
			}
		}
	}
	
	
	/**
	 * <p>toString</p>
	 * 
	 * @return the state of the departure thread
	 */
	public String toString() {
		String str = "Queue: " + queue + "\n" +
		"Time: " + time + "\n" + 
		"Is running: " + running;
		
		return str;
	}
}
