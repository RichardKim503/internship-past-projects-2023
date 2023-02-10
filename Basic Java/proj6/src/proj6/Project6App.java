package proj6;
import java.util.*;
import java.io.*;

/**
 * <p>Title: CSC 120 Project 6: Application Class</p>
 * 
 * <p>Description: This class is the application class of the<br>
 * StationList class. It will read in data from the "rrdata.txt"<br>
 * text file and insert a new Station into the StationList once<br>
 * a new String is found. The following integers will be the<br>
 * ridership data of that Station until a new String is found.<br>
 * This class will also display how many Stations there are in<br>
 * the StationList, give all the Station names and their ridership<br>
 * averages, and the Station with the highest single day ridership.<br>
 * This class will also remove a random Station and display all of<br>
 * this information once again.</p>
 * 
 * <p>Due 12/21 11:59 PM</p>
 * 
 * @author Richard Kim (n00923815@students.ncc.edu)
 *
 */
public class Project6App {

	public static void main(String[] args) throws Exception {
		
		/*
		 * This portion of the code reads data from the "rrdata.txt" file.
		 * Every time that there is a new String, a new Station is added
		 * to myStationList. All integers that come after become the 
		 * ridership data of the Station. When there is a new String, a
		 * new Station is created once again until there is no data left.
		 */
		Scanner file_input = new Scanner( new File( "rrdata.txt" ) );
		
		Station myStation = new Station();
		
		StationList myStationList = new StationList();
		
		while(file_input.hasNextLine()){
			String temp = file_input.nextLine();
			
			if(Character.isLetter(temp.charAt(0))) {
				
				myStation = new Station(temp);
				
				myStationList.insertStation(myStation);
				
					while(file_input.hasNextInt()) {
						myStation.addDay(Integer.parseInt(file_input.nextLine()));
            	}
			}
		}
		
		
		// Repeats the code twice.
		for(int i = 0; i < 2; i++) {
			// Displays to state of myStationList. This contains how many Stations were entered
			// and the Stations' names along with their respective daily average ridership.
			System.out.println(myStationList.toString());
			System.out.println();
			
			// Displays the name of the highest single-day ridership.
			System.out.println("Station with highest ridership: " +
								myStationList.highestRidership().getStationName());
			System.out.println();
			
			if(i == 0) {
				// Picks a random station to remove. Then displays that Station's index and name.
				Random rng = new Random();
				int removePos = rng.nextInt(myStationList.getNumStations()) + 1;
				System.out.println("The station at position " + removePos + " is about to be removed.");
				System.out.println("The name of that station is: " + 
				myStationList.getStation(removePos).getStationName());
				myStationList.removeStation(removePos);
				System.out.println();
			}
		}
	}
}