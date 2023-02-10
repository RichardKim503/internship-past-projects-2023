package proj3;

/**
 * <p>Title: CSC 120 Project 3: Project3App</p>
 * 
 * <p>Description: This class is the application class for the Question class.<br>
 * It tests the default constructor, parameterized constructor with both valid<br>
 * and invalid parameters, and tests the toString and calculateAnswer methods.</p>
 * 
 * <p>Due 10/28 11:59 PM</p>
 * 
 * @author Richard Kim (n00923815@students.ncc.edu)
 */
public class Project3App {

	public static void main(String[] args) {
		
		/*
		 * Ten objects created using the default constructor
		 */
		Question defaultQuestion1 = new Question();
		Question defaultQuestion2 = new Question();
		Question defaultQuestion3 = new Question();
		Question defaultQuestion4 = new Question();
		Question defaultQuestion5 = new Question();
		Question defaultQuestion6 = new Question();
		Question defaultQuestion7 = new Question();
		Question defaultQuestion8 = new Question();
		Question defaultQuestion9 = new Question();
		Question defaultQuestion10 = new Question();
		
		System.out.println("TESTING DEFAULT CONSTRUCTOR:");
		System.out.println("1: " + defaultQuestion1.toString() + defaultQuestion1.calculateAnswer());
		System.out.println("2: " + defaultQuestion2.toString() + defaultQuestion2.calculateAnswer());
		System.out.println("3: " + defaultQuestion3.toString() + defaultQuestion3.calculateAnswer());
		System.out.println("4: " + defaultQuestion4.toString() + defaultQuestion4.calculateAnswer());
		System.out.println("5: " + defaultQuestion5.toString() + defaultQuestion5.calculateAnswer());
		System.out.println("6: " + defaultQuestion6.toString() + defaultQuestion6.calculateAnswer());
		System.out.println("7: " + defaultQuestion7.toString() + defaultQuestion7.calculateAnswer());
		System.out.println("8: " + defaultQuestion8.toString() + defaultQuestion8.calculateAnswer());
		System.out.println("9: " + defaultQuestion9.toString() + defaultQuestion9.calculateAnswer());
		System.out.println("10: " + defaultQuestion10.toString() + defaultQuestion10.calculateAnswer());
		System.out.println();
		
		
		/*
		 * Ten objects created using the parameterized constructor with VALID parameters
		 */
		Question validQuestion1 = new Question("+", 6, 4);
		Question validQuestion2 = new Question("+", 12, 12);
		Question validQuestion3 = new Question("+", 0, 0);
		Question validQuestion4 = new Question("+", 3, 2);
		Question validQuestion5 = new Question("+", 11, 8);
		Question validQuestion6 = new Question("-", 6, 5);
		Question validQuestion7 = new Question("-", 12, 11);
		Question validQuestion8 = new Question("-", 11, 8);
		Question validQuestion9 = new Question("-", 9, 0);
		Question validQuestion10 = new Question("-", 8, 4);
		
		System.out.println("TESTING PARAMETERIZED CONSTRUCTOR (VALID):");
		
		System.out.println("Creating an addition question with 6 and 4:");
		System.out.println(validQuestion1.toString() + validQuestion1.calculateAnswer());
		
		System.out.println("Creating an addition question with 12 and 12:");
		System.out.println(validQuestion2.toString() + validQuestion2.calculateAnswer());
		
		System.out.println("Creating an addition question with 0 and 0:");
		System.out.println(validQuestion3.toString() + validQuestion3.calculateAnswer());
		
		System.out.println("Creating an addition question with 3 and 2:");
		System.out.println(validQuestion4.toString() + validQuestion4.calculateAnswer());
		
		System.out.println("Creating an addition question with 11 and 8:");
		System.out.println(validQuestion5.toString() + validQuestion5.calculateAnswer());
		
		System.out.println("Creating a subtraction question with 6 and 5:");
		System.out.println(validQuestion6.toString() + validQuestion6.calculateAnswer());
		
		System.out.println("Creating a subtraction question with 12 and 11:");
		System.out.println(validQuestion7.toString() + validQuestion7.calculateAnswer());
		
		System.out.println("Creating a subtraction question with 11 and 8:");
		System.out.println(validQuestion8.toString() + validQuestion8.calculateAnswer());
		
		System.out.println("Creating a subtraction question with 9 and 0:");
		System.out.println(validQuestion9.toString() + validQuestion9.calculateAnswer());
		
		System.out.println("Creating a subtraction question with 8 and 4:");
		System.out.println(validQuestion10.toString() + validQuestion10.calculateAnswer());
		
		System.out.println();

		
		/*
		 * Several objects created using the parameterized constructor with INVALID parameters
		 */
		
		// Addition question but first operand is too large
		Question invalidQuestion1 = new Question("+", 35, 2);
		
		// Addition question but second operand is too large
		Question invalidQuestion2 = new Question("+", 3, 23);
		
		// Addition question but first operand is too small
		Question invalidQuestion3 = new Question("+", -1, 11);
		
		// Addition question but second operand is too small
		Question invalidQuestion4 = new Question("+", 3, -3);
		
		// Subtraction question but the first operand is greater than 12
		Question invalidQuestion5 = new Question("-", 13, 3);
		
		// Subtraction question but the first operand is less than 6
		Question invalidQuestion6 = new Question("-", 5, 2);
		
		// Subtraction question but the second operand is higher than the first operand
		Question invalidQuestion7 = new Question("-", 7, 8);
		
		// Subtraction question but the second operand is less than 0
		Question invalidQuestion8 = new Question("-", 10, -1);
		
		// Subtraction question but the first and second operands are the same
		Question invalidQuestion9 = new Question("-", 6, 6);
		
		// Multiplication questions are not valid
		Question invalidQuestion10 = new Question("*", 11, 5);
		
		// Division questions are not valid
		Question invalidQuestion11 = new Question("/", 12, 4);
		
		
		System.out.println("TESTING PARAMETERIZED CONSTRUCTOR (INVALID):");
		
		System.out.println("Creating an addition question with 35 and 2:");
		System.out.println(invalidQuestion1.toString() + invalidQuestion1.calculateAnswer());
		
		System.out.println("Creating an addition question with 3 and 23:");
		System.out.println(invalidQuestion2.toString() + invalidQuestion2.calculateAnswer());
		
		System.out.println("Creating an addition question with -1 and 11:");
		System.out.println(invalidQuestion3.toString() + invalidQuestion3.calculateAnswer());
		
		System.out.println("Creating an addition question with 3 and -3:");
		System.out.println(invalidQuestion4.toString() + invalidQuestion4.calculateAnswer());
		
		System.out.println("Creating a subtraction question with 13 and 3:");
		System.out.println(invalidQuestion5.toString() + invalidQuestion5.calculateAnswer());
		
		System.out.println("Creating a subtraction question with 5 and 2:");
		System.out.println(invalidQuestion6.toString() + invalidQuestion6.calculateAnswer());
		
		System.out.println("Creating a subtraction question with 7 and 8:");
		System.out.println(invalidQuestion7.toString() + invalidQuestion7.calculateAnswer());
		
		System.out.println("Creating a subtraction question with 10 and -1:");
		System.out.println(invalidQuestion8.toString() + invalidQuestion8.calculateAnswer());
		
		System.out.println("Creating a subtraction question with 6 and 6:");
		System.out.println(invalidQuestion9.toString() + invalidQuestion9.calculateAnswer());
		
		System.out.println("Creating a multiplication question with 11 and 5:");
		System.out.println(invalidQuestion10.toString() + invalidQuestion10.calculateAnswer());
		
		System.out.println("Creating a division question with 12 and 4:");
		System.out.println(invalidQuestion11.toString() + invalidQuestion11.calculateAnswer());
	}
}