package program3;

/**
 * <p>
 * Title: The Program 3 Application class
 * </p>
 * 
 * <p>
 * Description: Simulates an airport with a runway that has<br>
 * arriving and departing airplanes.
 * </p>
 * 
 * @author Richard Kim (n00923815)
 */
public class Program3 {
	
	public static void startSimulation(long time) {
		Departure d = new Departure(System.currentTimeMillis());
		Arrival a = new Arrival(System.currentTimeMillis());
		Runway r = new Runway(a, d);
		
		d.start();
		a.start();
		r.start();
		
		long startTime = System.currentTimeMillis();
		
		while(System.currentTimeMillis() < startTime + time) {
			
		}
		
		d.stopRunning();
		a.stopRunning();
		r.stopRunning();
		
		d.interrupt();
		a.interrupt();
		r.interrupt();
		
		try {
			d.wait();
			a.wait();
			r.wait();
		} catch(InterruptedException e) {
			
		} catch(IllegalMonitorStateException e) {
			
		}
	}

	public static void main(String[] args) {
		startSimulation(100000);
	}
}
