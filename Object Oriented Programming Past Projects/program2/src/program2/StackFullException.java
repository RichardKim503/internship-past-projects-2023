package program2;

/**
 * <p>
 * Title: StackFullException
 * </p>
 * 
 * <p>
 * Description: An exception for when the stack is full.
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * 
 * @author Richard Kim
 * @version 0.9
 */
public class StackFullException extends Exception {
	
	/**
	 * <p>StackFullException default constructor</p>
	 * 
	 * The default message for when the Stack is full.
	 */
	public StackFullException(){
		super("Exception : Stack is full");
	}
	
	
	/**
	 * <p>StackFullException parameterized constructor</p>
	 * 
	 * A custom message when a StackFullxception is created.
	 * @param msg The custom error message
	 */
	public StackFullException(String msg){
		super(msg);
	}
}