package project2;

/**
 * <p>Title: CSC 120 Project 2: Darts</p>
 * 
 * <p>Description: This program plays darts. Darts are thrown and land in random locations.
 * The program tests to see if two darts have the same value. The highest scoring dart is recorded.
 * Your total score are recorded. If your total score is higher than 50, you win. If not, you lose.</p>
 * 
 * <p>Due October 7, 11:59 PM</p>
 * 
 * @author Richard Kim (n00923815@students.ncc.edu)
 */

public class Project2 {
    /**
     * This is the main class runs the Dart class
     */
    public static void main( String args[] ) {
        Dart d1;  // The first dart that gets thrown
        Dart d2;  // The second dart that gets thrown
        Dart d3;  // The third dart that gets thrown
        

        // Each Dart object that was declared will be instantiated
        // with a default constructor. Each of the three darts are "thrown"
        // and will land in a random spot. The dart will land in a random 
        // wedge and ring and the result will be multiplied and printed out.
        d1 = new Dart();
        d1.throwDart();
        
        //Dart 1 Test Parameters and Results
        //d1 = new Dart(9,2); 18
        //d1 = new Dart(8,3); 24
        //d1 = new Dart(15,3); 45
        //d1 = new Dart(7,3); 21
        //d1 = new Dart(4,1); 4
        //d1 = new Dart(16,1); 16
        //d1 = new Dart(10,3); 30
        //d1 = new Dart(20,3); 60
        //d1 = new Dart(-20,3); 0
        //d1 = new Dart(3,1); 3

        System.out.println( "Dart 1: " + d1.toString() );

        d2 = new Dart();
        d2.throwDart();
        
        //Dart 2 Test Parameters and Results
        //d2 = new Dart(18,1); 18
        //d2 = new Dart(4,2); 8
        //d2 = new Dart(15,3); 45
        //d2 = new Dart(8,2); 16
        //d2 = new Dart(20,2); 40
        //d2 = new Dart(16,2); 32
        //d2 = new Dart(10,3); 30
        //d2 = new Dart(30,2); 0
        //d2 = new Dart(30,-2); 0
        //d2 = new Dart(20,3); 60

        System.out.println( "Dart 2: " + d2.toString() );
        
        d3 = new Dart();
        d3.throwDart();
        
        //Dart 3 Test Parameters and Results
        //d3 = new Dart(6,3); 18
        //d3 = new Dart(15,1); 15
        //d3 = new Dart(12,3); 36
        //d3 = new Dart(8,2); 16
        //d3 = new Dart(4,1); 4
        //d3 = new Dart(16,3); 48
        //d3 = new Dart(10,3); 30
        //d3 = new Dart(10,6); 0
        //d3 = new Dart(1,-6); 0
        //d3 = new Dart(15,1); 15
        
        System.out.println("Dart 3: " + d3.toString());
        
        
        // This checks if two darts have the same score
        if(d1.getScore() == d2.getScore()) {
        	System.out.println("Two darts have the same score.");
        }
        else if(d2.getScore() == d3.getScore()) {
        	System.out.println("Two darts have the same score.");
        }
        else if(d1.getScore() == d3.getScore()) {
        	System.out.println("Two darts have the same score.");
        }
        else {
        	System.out.println("No two darts have the same score.");
        }
        
        
        // This checks to see which dart has the highest score
        int highestScore = d1.getScore();
        
        if(highestScore < d2.getScore()) {
        	highestScore = d2.getScore();
        }
        if(highestScore < d3.getScore()) {
        	highestScore = d3.getScore();
        }
        
        System.out.println("The highest score is " + highestScore + ".");
        
        
        // This combines all of the scores to get a total
        int totalScore = d1.getScore() + d2.getScore() + d3.getScore(); 
        
        System.out.println("The total score is " + totalScore + ".");
        
        
        // This determines whether or not you won
        // If your total score is above 50, you win. Otherwise, you lose
        if(totalScore > 50) {
        	System.out.println("You win!");
        }
        else {
        	System.out.println("You lose!");
        }
    }
}
