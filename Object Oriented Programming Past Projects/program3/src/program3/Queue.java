package program3;

/**
 * <p>
 * Title: The Queue Class
 * </p>
 * 
 * <p>
 * Description: An interface for a Queue data type.
 * </p>
 * 
 * @author Richard Kim (n00923815)
 */
public interface Queue<T> {

	/**
	 * <p>enqueue</p>
	 * 
	 * Puts an item at the rear of the queue.
	 * 
	 * @param d The item to enqueue.
	 * @throws QueueFullException If the queue is full.
	 */
	void enqueue(T d) throws QueueFullException;
	
	/**
	 * <p>dequeue</p>
	 * 
	 * Gets rid of the item at the front of the queue and returns it.
	 * 
	 * @return The item that was at the front of the queue.
	 * @throws QueueEmptyException If the queue is empty.
	 */
	T dequeue() throws QueueEmptyException;
	
	
	/**
	 * <p>front</p>
	 * 
	 * Returns the item at the front of the queue.
	 * 
	 * @return The item that is at the front of the queue.
	 * @throws QueueEmptyException If the queue is empty.
	 */
	T front() throws QueueEmptyException;
	
	
	/**
	 * <p>rear</p>
	 * 
	 * Returns the item at the rear of the queue.
	 * 
	 * @return The item that is at the rear of the queue.
	 * @throws QueueEmptyException If the queue is empty.
	 */
	T rear() throws QueueEmptyException;
	
	
	/**
	 * <p>isEmpty</p>
	 * 
	 * @return If the queue is empty.
	 */
	boolean isEmpty();
	
	
	/**
	 * <p>isFull</p>
	 * 
	 * @return If the queue is full.
	 */
	boolean isFull();
	

	/**
	 * <p>getSize</p>
	 * 
	 * @return The size of the queue.
	 */
	int getSize();
}