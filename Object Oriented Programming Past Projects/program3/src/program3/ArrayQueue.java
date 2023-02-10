package program3;

/**
 * <p>
 * Title: The ArrayQueue Class
 * </p>
 * 
 * <p>
 * Description: An array class that implements Queue.
 * </p>
 * 
 * @author Richard Kim (n00923815)
 */
public class ArrayQueue<T> implements Queue<T> {

	private T[] data;		// Holds the queue elements
	private int f = 0;		// The front element
	private int size = 0;	// The number of elements
	static final int CAPACITY = 100;	// Default capacity
	
	
	/**
	 * <p>ArrayQueue default constructor</p>
	 * 
	 * The default constructor for the ArrayQueue class.<br>
	 * Creates a queue using an array with the default capacity 100.
	 */
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	
	/**
	 * <p>ArrayQueue parameterized constructor</p>
	 * 
	 * The parameterized constructor for the ArrayQueue class<br>
	 * Creates a queue using an array with a custom capacity.
	 * 
	 * @param capacity The custom capacity to set the size from the user.
	 */
	public ArrayQueue(int capacity) {
		data = (T[])new Object[capacity];
	}
	
	
	/**
	 * <p>enqueue</p>
	 * 
	 * Puts an item at the rear of the queue.
	 * 
	 * @param d The item to enqueue.
	 * @throws QueueFullException If the queue is full.
	 */
	@Override
	public synchronized void enqueue(T d) throws QueueFullException {
		if(isFull()) {
			throw new QueueFullException();
		}
		
		int index = (f + size) % data.length;
		data[index] = d;
		size++;
	}

	
	/**
	 * <p>dequeue</p>
	 * 
	 * Gets rid of the item at the front of the queue and returns it.
	 * 
	 * @return The item that was at the front of the queue.
	 * @throws QueueEmptyException If the queue is empty.
	 */
	@Override
	public synchronized T dequeue() throws QueueEmptyException {
		if(isEmpty()) {
			throw new QueueEmptyException();
		}
		
		T temp = data[f];
		data[f] = null;
		f = (f + 1) % data.length;
		size--;
		return temp;
	}

	
	/**
	 * <p>front</p>
	 * 
	 * Returns the item at the front of the queue.
	 * 
	 * @return The item that is at the front of the queue.
	 * @throws QueueEmptyException If the queue is empty.
	 */
	@Override
	public synchronized T front() throws QueueEmptyException {
		if(isEmpty()) {
			throw new QueueEmptyException();
		}
		
		return data[f];
	}

	
	/**
	 * <p>rear</p>
	 * 
	 * Returns the item at the rear of the queue.
	 * 
	 * @return The item that is at the rear of the queue.
	 * @throws QueueEmptyException If the queue is empty.
	 */
	@Override
	public synchronized T rear() throws QueueEmptyException {
		if(isEmpty()) {
			throw new QueueEmptyException();
		}
		
		return data[data.length - 1];
	}

	
	/**
	 * <p>isEmpty</p>
	 * 
	 * @return If the queue is empty.
	 */
	@Override
	public synchronized boolean isEmpty() {
		return size == 0;
	}

	
	/**
	 * <p>isFull</p>
	 * 
	 * @return If the queue is full.
	 */
	@Override
	public synchronized boolean isFull() {
		return size == data.length;
	}

	
	/**
	 * <p>getSize</p>
	 * 
	 * @return The size of the queue.
	 */
	@Override
	public synchronized int getSize() {
		// TODO Auto-generated method stub
		return size;
	}
	
	
	/**
	 * <p>makeEmpty</p>
	 * 
	 * Empties out the queue.
	 */
	public synchronized void makeEmpty() {
		data = (T[])new Object[data.length];
		size = 0;
	}
	
	
	/**
	 * <p>toString</p>
	 * 
	 * Returns the size of the queue and the items in the queue.
	 * 
	 * @return The state of the ArrayQueue.
	 */
	public synchronized String toString() {
		if(isEmpty()) {
			return "Queue is empty! "
			+ "Maximum number of items that can be stored is " + data.length;
		}
		
		String str = "The number of items in the queue is: " + size + "\n" +
					 "The queue contains the following:\n";
		for(int i = f; i < size + f; i++) {
			str += data[i] + " ";
		}
		return str;
	}
}
