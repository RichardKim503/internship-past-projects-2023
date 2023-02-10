package proj1;
import javax.swing.JOptionPane;

/**
 * <p>Title: Project 1</p>
 * 
 * <p>Description: The program asks the user for their first and last name,
 * their midterm grade, and their final exam grade. Then the program displays
 * information such as how many letters are in your name, your initials, and your average.</p>
 * 
 * @author Richard Kim, n00923815
 *
 */

public class Project1 {
	public static void main(String[] args)
	{
		String fullName;
		int posOfSpace;
		String firstName;
		String lastName;
		int firstNameLength;
		int lastNameLength;
		int fullNameLength;
		char firstInitial;
		char lastInitial;
		double midterm;
		double finalExam;
		double average;
		
		// I moved this to the top of the code because most of the code depends on the full name variable.
		fullName = JOptionPane.showInputDialog("Please enter your first name, followed by a space, followed by your last name");
		
		// I moved this to the top of the code because the grade portion of the code relies on the midterm variable.
		midterm = Double.parseDouble(JOptionPane.showInputDialog("Please enter your midterm score."));
		
		// I moved this to the top of the code because the grade portion of the code relies on the finalExam variable.
		finalExam = Double.parseDouble(JOptionPane.showInputDialog("Please enter your final exam score."));	
		
		// I moved this up because there are other variables that rely on this variable in order to work properly.
		posOfSpace = fullName.indexOf(" ");
		
		// I changed the parameters because before, the first name would exclude the first and last character.
		firstName = fullName.substring(0, posOfSpace);
		
		// lastName was changed to (posOfSpace + 1) because not everyone's last name starts at index 5.
		lastName = fullName.substring(posOfSpace + 1);
		
		// I changed it so that it instantiated the first name length because before, it was the last name length.
		firstNameLength = firstName.length();
		
		// I moved this up because the output depends on this variable to be instantiated first.
		lastNameLength = lastName.length();
		
		// I added a -1 because I need to account for the space in the output.
		fullNameLength = fullName.length() - 1;
		
		// I moved this up because this is suppose to be the first output. I also swapped the first and last name
		// to match the correct output.
		System.out.println("Name: " + lastName + ", " + firstName + "\n");
		
		// I moved this up because this is suppose to be near the beginning of the output. The output was also changed
		// because not everyone has 4 letters in their first name, and the length was displayed twice.
		System.out.println("There are " + firstNameLength + " letters in my first name");
		
		// I moved this down because lastNameLength was not instantiated yet.
		System.out.println("There are " + lastNameLength + " letters in my last name");
		
		// I changed the output so it displayed the proper length of the user's full name because not everyone has
		// 11 letter in their full name.
		System.out.println("There are " + fullNameLength + " letters in my full name\n");
		
		// Nothing wrong here
		firstInitial = fullName.charAt(0);
		
		// I changed it so it got the character at the first index of the last name. Before, it got the last letter
		// of the entire name.
		lastInitial = lastName.charAt(0);
		
		// This line of code was added because it wasn't in the original source code.
		System.out.println("First initial: " + firstInitial);
		
		// Nothing wrong here
		System.out.println("Last initial: " + lastInitial + "\n");
		
		// I moved this down because the output for midterm was towards the end of the code.
		System.out.println("Midterm: " + midterm);
		
		// I changed the parameter because it displayed the midterm grade instead of the final grade.
		System.out.println("Final Exam: " + finalExam + "\n");
		
		// I added parentheses because according to PEMDAS, the final exam score will be divided by 2 first which
		// is incorrect. The midterm and final grade must be added first, then divided by 2 to find the average.
		average = (midterm + finalExam) / 2;
		
		// I removed the escape sequence at the beginning because there would be an extra line of space.
		System.out.println("Average: " + average);
	}
}
