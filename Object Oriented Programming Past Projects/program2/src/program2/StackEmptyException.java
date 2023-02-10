package program2;

/**
 * <p>
 * Title: StackEmptyException
 * </p>
 * 
 * <p>
 * Description: An exception for when the stack is empty.
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * 
 * @author Richard Kim
 * @version 0.9
 */
public class StackEmptyException extends Exception {
	
	/**
	 * <p>StackEmptyException default constructor</p>
	 * 
	 * The default message for when the Stack is Empty.
	 */
	public StackEmptyException(){
		super("Exception : Stack is empty");
	}

	
	/**
	 * <p>StackEmptyException parameterized constructor</p>
	 * 
	 * A custom message when a StackEmptyException is created.
	 * @param msg The custom error message
	 */
	public StackEmptyException(String msg){
		super(msg);
	}
}
