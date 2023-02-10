package proj3;
import javax.swing.JOptionPane;

/**
 * <p>Title: CSC 120 Project 4: Project4App</p>
 * 
 * <p>Description: This class is an application class for the Question class.<br>
 * This class asks the user 15 arithmetic questions which are either addition<br>
 * or subtraction. After the user finishes answering the 15 question, the<br>
 * application then reports the score for addition, the score for subtraction,<br>
 * and the overall score to the user.</p>
 * 
 * <p>Due 11/10 11:59 PM</p>
 * 
 * @author Richard Kim (n00923815@students.ncc.edu)
 */
public class Project4App {

	public static void main(String[] args) {
		Question[] listOfQuestions = new Question[15]; // This array holds 15 Question objects
													   // from the Question class. Contains 15
													   // arithmetic questions to be asked.
		int[] correctAnswer = new int[15]; // This array holds the correct answers to each of
										   // the 15 Question objects.
		int additionCorrect = 0; // The number of addition questions the user got correct.
		int additionWrong = 0;   // The number of addition questions the user got wrong.
		int subtractionCorrect = 0; // The number of subtraction questions the user got correct.
		int subtractionWrong = 0;   // The number of subtraction questions the user got wrong.
		double finalScore = 0.0; // The score that the user will get.
		
		
		// This loop fills all 15 indexes of the listOfQuestions array with Question objects.
		// This loop also fills all 15 indexes of the correctAnswer array with the correct
		// answer corresponding to each index of questions.
		for(int i = 0; i < listOfQuestions.length; i++) {
			listOfQuestions[i] = new Question();
			correctAnswer[i] = listOfQuestions[i].calculateAnswer();
		}
		
		
		// This portion of code asks the user to answer 15 questions.
		for(int i = 0; i < listOfQuestions.length; i++) {
			// Asks the question to the user.
			int userAnswer = Integer.parseInt(JOptionPane.showInputDialog("Question #" + (i + 1) + ": \n"
											  + "What is the answer?\n" + listOfQuestions[i]));
			
			// If the user gets the question correct.
			if(userAnswer == correctAnswer[i]) {
				JOptionPane.showMessageDialog(null, "Congratulations! You got it correct!");
				
				// Determines whether the question is either addition or subtraction.
				if(listOfQuestions[i].getQuestionType() == "+") {
					additionCorrect++;
				}
				else {
					subtractionCorrect++;
				}
			}
			// If the user gets the question wrong.
			else {
				JOptionPane.showMessageDialog(null, "Sorry, " + listOfQuestions[i] + correctAnswer[i]);
				
				// Determines whether the question is either addition or subtraction.
				if(listOfQuestions[i].getQuestionType() == "+") {
					additionWrong++;
				}
				else {
					subtractionWrong++;
				}
			}
		}
		
		
		// Calculates the final score of the user out of 100.
		finalScore = ((additionCorrect * 100.0 + subtractionCorrect * 100.0) / listOfQuestions.length);
		
		// This portion displays the final message to the user.
		// The message contains the addition score, the subtraction score, and the final score.
		JOptionPane.showMessageDialog(null,
		"Addition:\n" +
		"You got " + additionCorrect + " correct, and " + additionWrong + " incorrect.\n" +
		"Subtraction:\n" + 
		"You got " + subtractionCorrect + " correct, and " + subtractionWrong + " incorrect.\n" +
		"The percent correct is " + finalScore + ".");
	}
}