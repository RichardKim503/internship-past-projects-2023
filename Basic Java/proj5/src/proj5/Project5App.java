package proj5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <p>Title: CSC 120 Project 5: Application Class</p>
 * 
 * <p>Description: This class is the application class of the Station class.<br>
 * This class reads data from a text document called "rrdata.txt" and creates<br>
 * a Station object every time a new String is found. The String will represent<br>
 * the name of the station and the numbers (integers) preceding it will represent<br>
 * the ridership data for each day. Once a new String, or a new station name is<br>
 * found, it will compute the average daily ridership, the the busiest day and<br>
 * how many riders the busiest day saw.</p>
 * 
 * <p>Due 12/7 11:59 PM</p>
 * 
 * @author Richard Kim (n00923815@students.ncc.edu)
 *
 */
public class Project5App {

	public static void main(String[] args) throws FileNotFoundException {
		
		// The scanner object to read the data from "rrdata.txt".
		Scanner file_input = new Scanner( new File( "rrdata.txt" ) );
		
		// A preliminary Station object.
		Station myStation = new Station();
		
		// The while loop will continue to read data until
		// there is no more data to be read from "rrdata.txt".
        while(file_input.hasNextLine()){
            
        	// A temporary variable that will hold a line of
        	// information from "rrdata.txt".
            String temp = file_input.nextLine();
            
            // If the data is a String, it will become a new Station.
            if(Character.isLetter(temp.charAt(0))) {
            	
            	myStation = new Station(temp);
            	
            	// All integers after the String will be added to the data.
            	while(file_input.hasNextInt()) {
            		
            		myStation.addDay(Integer.parseInt(file_input.nextLine()));
            	}
            	
            }
            
            // Once there is no more integers to take in, it then prints out the
            // average ridership, the busiest day, and the amount of riders on 
            // the busiest day.
            System.out.println(myStation.getStationName() + " averages " + 
            				   myStation.getAverage() + " riders a day.");
            System.out.println("The busiest day was day " + 
            				   myStation.getDayWithMostRiders() + " with " + 
            				   myStation.getDaysRidership(myStation.getDayWithMostRiders()) + 
            				   " riders.");
        } 
	}
}