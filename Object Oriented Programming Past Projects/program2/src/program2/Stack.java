package program2;

/**
 * <p>
 * Title: Stack
 * </p>
 * 
 * <p>
 * Description: An interface for a Stack data type.
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * 
 * @author Richard Kim
 * @version 0.9
 */
public interface Stack<T> {
	
	/**
	 * <p>push</p>
	 * 
	 * Adds a new value to the top of the stack.
	 * 
	 * @param d The value to add to the stack.
	 * @throws StackFullException If the stack is full.
	 */
	public void push(T d) throws StackFullException;
	
	
	/**
	 * <p>pop</p>
	 * 
	 * Removes the top value of the stack and returns it.
	 * 
	 * @return The top value of the stack.
	 * @throws StackEmptyException If the stack is empty.
	 */
	public T pop()throws StackEmptyException;
	
	
	/**
	 * <p>peek</p>
	 * 
	 * Shows the top value of the stack without removing it.
	 * 
	 * @return The top value of the stack.
	 * @throws StackEmptyException If the stack is empty.
	 */
	public T peek()throws StackEmptyException;
	
	
	/**
	 * <p>isFull</p>
	 * 
	 * @return true if the stack is full.<br>
	 * false if the stack is not full.
	 */
	public boolean isFull();
	
	
	/**
	 * <p>isEmpty</p>
	 * 
	 * @return true if the stack is empty.<br>
	 * false if the stack is not empty.
	 */
	public boolean isEmpty();
	
	
	/**
	 * <p>size</p>
	 * 
	 * @return The size of the stack.
	 */
	public int size();
}
