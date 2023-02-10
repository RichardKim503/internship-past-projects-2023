package program3;

/**
 * <p>
 * Title: The QueueEmptyException Class
 * </p>
 * 
 * <p>
 * Description: An exception class when the Queue is empty.
 * </p>
 * 
 * @author Richard Kim (n00923815)
 */
public class QueueEmptyException extends RuntimeException {

	/**
	 * <p>QueueEmptyException</p>
	 * 
	 * The default message when the queue is empty.
	 */
	public QueueEmptyException() {
		super("QueueEmptyException: Queue is empty.");
	}
	
	
	/**
	 * <p>QueueEmptyException Parameterized</p>
	 * 
	 * A custom message when the queue is empty.
	 * 
	 * @param msg The custom message to send when the exception is created.
	 */
	public QueueEmptyException(String msg) {
		super(msg);
	}
}
