package program3;

/**
 * <p>
 * Title: The QueueFullException Class
 * </p>
 * 
 * <p>
 * Description: An exception class when the Queue is full.
 * </p>
 * 
 * @author Richard Kim (n00923815)
 */
public class QueueFullException extends RuntimeException {

	/**
	 * <p>QueueFullException</p>
	 * 
	 * The default message when the queue is full.
	 */
	public QueueFullException() {
		super("QueueFullException: Queue is full.");
	}
	
	
	/**
	 * <p>QueueEmptyException Parameterized</p>
	 * 
	 * A custom message when the queue is full.
	 * 
	 * @param msg The custom message to send when the exception is created.
	 */
	public QueueFullException(String msg) {
		super(msg);
	}
}
