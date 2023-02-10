package program2;

/**
 * <p>
 * Title: ArrayStack
 * </p>
 * 
 * <p>
 * Description: A concrete class that implements the Stack data type<br>
 * and uses an array to hold the values.
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * 
 * @author Richard Kim
 * @version 0.9
 */
public class ArrayStack<T> implements Stack<T>{

	private T[] data;		// The array that represents the Stack.
	private int numItems;	// The number of items in the Stack.
	private final int DEFAULT_SIZE = 100;	// The default constructor size.
	
	
	/**
	 * <p>ArrayStack default constructor</p>
	 * 
	 * The default constructor of the ArrayStack. It creates<br>
	 * a Stack using the default size of 100.
	 */
	public ArrayStack() {
		data = (T[])new Object[DEFAULT_SIZE];
		numItems = 0;
	}
	
	
	/**
	 * <p>ArrayStack parameterized constructor</p>
	 * 
	 * The parameterized constructor of the ArrayStack. It<br>
	 * creates a Stack using a custom size from the user.
	 * 
	 * @param capacity The size of the Stack.
	 */
	public ArrayStack(int capacity) {
		if(capacity < 1) {
			data = (T[])new Object[capacity];
		}
		else {
			data = (T[])new Object[DEFAULT_SIZE];
		}
		numItems = 0;
	}
	
	
	/**
	 * <p>push</p>
	 * 
	 * Adds a new value to the top of the stack.
	 * 
	 * @param d The value to add to the stack.
	 * @throws StackFullException If the stack is full.
	 */
	@Override
	public void push(T d) throws StackFullException {
		if(isFull()) {
			throw new StackFullException("Stack Full Exception.");
		}
		data[numItems] = d;
		numItems++;
	}
	
	
	/**
	 * <p>pop</p>
	 * 
	 * Removes the top value of the stack and returns it.
	 * 
	 * @return The top value of the stack.
	 * @throws StackEmptyException If the stack is empty.
	 */
	@Override
	public T pop() throws StackEmptyException {
		if(isEmpty()) {
			throw new StackEmptyException("Stack Empty Exception");
		}
		numItems--;
		T item = data[numItems];
		return item;
	}

	
	/**
	 * <p>peek</p>
	 * 
	 * Shows the top value of the stack without removing it.
	 * 
	 * @return The top value of the stack.
	 * @throws StackEmptyException If the stack is empty.
	 */
	@Override
	public T peek() throws StackEmptyException {
		if(isEmpty())
			throw new StackEmptyException("Stack empty Exception...");
		return data[numItems-1];
	}
	
	
	/**
	 * <p>isFull</p>
	 * 
	 * @return true if the stack is full.<br>
	 * false if the stack is not full.
	 */
	@Override
	public boolean isFull() {
		return numItems == data.length;
	}
	
	
	/**
	 * <p>isEmpty</p>
	 * 
	 * @return true if the stack is empty.<br>
	 * false if the stack is not empty.
	 */
	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}

	
	/**
	 * <p>size</p>
	 * 
	 * @return The size of the stack.
	 */
	@Override
	public int size() {
		return numItems;
	}

}