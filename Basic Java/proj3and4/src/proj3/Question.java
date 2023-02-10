package proj3;
import java.util.Random;

/**
 * <p>Title: CSC 120 Project 3: Question</p>
 * 
 * <p>Description: This class creates basic addition and subtraction questions.</p>
 * 
 * <p>Due 10/28 11:59 PM</p>
 * 
 * @author Richard Kim (n00923815@students.ncc.edu)
 */
public class Question {
	private String questionType; // What kind of question it will be, + or -
	private int firstOp;		 // The first operand, or the first number
	private int secondOp;		 // The second operand, or the second number
	
	
	/**
	 * <p>Question (default)</p>
	 * 
	 * <p>This is the default constructor of the Question class.<br>
	 * It creates either an addition or a subtraction question.<br>
	 * If the question is addition, both integers are between 0 and 12.<br>
	 * If the question is subtraction, the first integer is between 6 and 12,<br>
	 * and the second integer is between 0 and less than the first integer.</p>
	 */
	public Question() {
		Random rng = new Random(); // Used to randomize the values of the question
		
		int questionTypeRNG = rng.nextInt(2);
		if(questionTypeRNG == 0) {
			questionType = "+";
		}
		else {
			questionType = "-";
		}
		
		if(questionType.equals("+")) {
			firstOp = rng.nextInt(13);
			secondOp = rng.nextInt(13);
		}
		else
		{
			firstOp = rng.nextInt(7) + 6;
			secondOp = rng.nextInt(firstOp);
		}	
	}
	
	
	/**
	 * <p>Question (parameterized)</p>
	 * 
	 * <p>This is the parameterized constructor of the Question class.<br>
	 * The user inputs whether they want an addition or a subtraction problem.<br>
	 * If the question is addition, both integers are between 0 and 12.<br>
	 * If the question is subtraction, the first integer is between 6 and 12<br>
	 * and the second integer is between 0 and less than the first integer.<br>
	 * If these rules are not followed, then the construction creates a<br>
	 * randomized equation for you following the rules.</p>
	 * 
	 * @param myQuestionType Determines if the question is addition or subtraction using + and -.
	 * @param myFirstOp The first operator (or number).
	 * @param mySecondOp The second operator (or number).
	 */
	public Question(String myQuestionType, int myFirstOp, int mySecondOp) {
		Random rng = new Random(); // Used to randomize the values of the question
		boolean randomizeEverything = false; // Becomes true if one of the parameters are not valid.
											 // If one is not valid, randomizes the entire question.
		
		if(!(myQuestionType.equals("+") || myQuestionType.equals("-"))) {
			randomizeEverything = true;
			questionType = "ERROR";
		}
		else {
			questionType = myQuestionType;
		}
		
		if(questionType.equals("+")) {
			if(myFirstOp > 12 || myFirstOp < 0) {
				randomizeEverything = true;
			}
			else {
				firstOp = myFirstOp;
			}
			if(mySecondOp > 12 || mySecondOp < 0) {
				randomizeEverything = true;
			}
			else {
				secondOp = mySecondOp;
			}
		}
		
		if(questionType.equals("-")) {
			if(myFirstOp > 12 || myFirstOp < 6) {
				randomizeEverything = true;
			}
			else {
				firstOp = myFirstOp;
			}
			if(mySecondOp >= myFirstOp || mySecondOp < 0) {
				randomizeEverything = true;
			}
			else {
				secondOp = mySecondOp;
			}
		}
		
		if(randomizeEverything) {
			int questionTypeRNG = rng.nextInt(2);
			if(questionTypeRNG == 0) {
				questionType = "+";
			}
			else {
				questionType = "-";
			}
			
			if(questionType.equals("+")) {
				firstOp = rng.nextInt(13);
				secondOp = rng.nextInt(13);
			}
			else
			{
				firstOp = rng.nextInt(7) + 6;
				secondOp = rng.nextInt(firstOp);
			}
		}
	}
	
	
	/**
	 * <p>getQuestionType</p>
	 * 
	 * @return The questionType variable (String),
	 * whether it was addition, "+", or subtraction, "-".
	 */
	public String getQuestionType() {
		return questionType;
	}
	
	
	/**
	 * <p>calculateAnswer</p>
	 * 
	 * @return The answer to the question.
	 */
	public int calculateAnswer() {
		if(questionType.equals("+")) {
			return firstOp + secondOp;
		}
		else {
			return firstOp - secondOp;
		}
	}
	
	
	/**
	 * <p>toString</p>
	 * 
	 * @return The state of the object, or the actual equation itself.
	 */
	public String toString() {
		String equation = firstOp + " " + questionType + " " + secondOp + " = ";
		// The question to return back to the caller.
		return equation;
	}
}