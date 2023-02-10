package program3;
import java.util.Random;

/**
 * <p>
 * Title: The Arrival Class
 * </p>
 * 
 * <p>
 * Description: A thread for arriving airplanes.
 * </p>
 * 
 * @author Richard Kim (n00923815)
 */
public class Arrival extends Thread {

	private ArrayQueue<Airline> queue;	// The queue for arriving airplanes
	private final long time;			// The landing time
	private boolean running = true;		// Determines if the thread is running or not
	private int nextTime;				// The randomized time
	
	
	/**
	 * <p>Arrival</p>
	 *  
	 * The constructor for the arrival thread
	 * 
	 * @param l the time
	 */
	public Arrival(long l) {
		queue = new ArrayQueue<Airline>();
		this.time = l;
	}
	
	
	/**
	 * <p>getQueue</p>
	 * 
	 * @return the queue of arriving airplanes
	 */
	public Queue<Airline> getQueue() {
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
	 * Stops the arrival thread from running
	 */
	public void stopRunning() {
		running = false;
	}
	
	
	/**
	 * <p>run</p>
	 * 
	 * Runs the arrival thread.
	 */
	public void run() {
		while(running) {
			try {
				Random rng = new Random();
				String flightId = SimulationTime.AIRLINES[rng.nextInt(18)] + rng.nextInt(30);
				nextTime = SimulationTime.timeTillNext(20000);
				
				Airline a = new Airline(flightId, time);
				queue.enqueue(a);
				
				System.out.println("Minute: " + ((System.currentTimeMillis() - time)/1000) + " - " +
				"Added flight " + flightId + " to arrival Queue");
				System.out.println("Random wait time before next arrival: " + (nextTime/1000));
				System.out.println();
				
				sleep(nextTime);
			} catch(InterruptedException e) {
				
			}
		}
	}
	
	
	/**
	 * <p>toString</p>
	 * 
	 * @return the state of the Arrival thread.
	 */
	public String toString() {
		String str = "The queue: " + queue + "\n" + 
		"Time: " + time + "\n" +
		"Is running: " + running;
		
		return str;
	}
}
