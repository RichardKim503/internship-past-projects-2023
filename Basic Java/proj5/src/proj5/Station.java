package proj5;

/**
 * <p>Title: CSC 120 Project 5: Station Class</p>
 * 
 * <p>Description: This class contains information about a train station.<br>
 * The train station includes the name of the station, data that includes<br>
 * the amount of riders for each day, and how many days the train station<br>
 * saw riders. The class can also compute the average daily ridership and<br>
 * find which day had the highest ridership.</p>
 * 
 * <p>Due 12/7 11:59 PM</p>
 * 
 * @author Richard Kim (n00923815@students.ncc.edu)
 *
 */
public class Station {
	
	private String stationName; // The name of the station.
	private int[] allDays;		// An array that holds how many riders for each day.
	private int numDays;		// The number of days the station had riders.

	
	/**
	 * <p>Station default constructor</p>
	 * 
	 * <p>This is the default constructor of the Station class.<br>
	 * It creates a Station object with the default name<br>
	 * "Station Name", creates an array to hold up to 20 days<br>
	 * worth of data, and sets the number of days the station<br>
	 * saw riders to 0.</p>
	 */
	public Station() {
		stationName = "Station Name";
		allDays = new int[20];
		numDays = 0;
	}
	
	
	/**
	 * <p>Station parameterized constructor (name only)</p>
	 * 
	 * <p>This is a parameterized constructor of the Station class<br>
	 * where it takes in a String that will represent the name of<br>
	 * the train station. It does not change the ridership of the<br>
	 * train and sets all 20 indexes to the default and the number<br>
	 * of days the station saw riders to 0.</p>
	 * 
	 * @param newName The name of the station.
	 */
	public Station(String newName) {
		this();
		stationName = newName;
	}
	
	
	/**
	 * <p>Station parameterized constructor (name and ridership)</p>
	 * 
	 * <p>This is a parameterized constructor of the Station class<br>
	 * where it takes in a String that will represent the name of<br>
	 * the train station. It will also take in an array that will<br>
	 * store up to 20 days worth of ridership data. It will also<br>
	 * set the number of days the station saw riders to the number<br>
	 * of indexes the array has. It will not store more than 20<br>
	 * days worth of data.</p>
	 * 
	 * @param newName The name of the station.
	 * @param daysData The ridership data provided by the user.
	 */
	public Station(String newName, int[] daysData) {
		this(newName);
		
		for(int i = 0; i < daysData.length && i < 20; i++) {
			allDays[i] = daysData[i];
			numDays++;
		}
	}
	
	
	/**
	 * <p>getStationName</p>
	 * 
	 * @return The name of the station.
	 */
	public String getStationName() {
		String returnString = stationName;
		
		return returnString;
	}
	
	
	/**
	 * <p>getAllDays</p>
	 * 
	 * @return The ridership data.
	 */
	public int[] getAllDays() {
		int[] returnDays = new int[numDays];
		
		for(int i = 0; i < numDays; i++) {
			returnDays[i] = allDays[i];
		}
		
		return returnDays;
	}
	
	
	/**
	 * <p>getNumDays</p>
	 * 
	 * @return The number of days the station saw riders.
	 */
	public int getNumDays() {
		return numDays;
	}
	
	
	/**
	 * <p>setStationName</p>
	 * 
	 * @param newName The name of the station the user wishes to change to.
	 */
	public void setStationName(String newName) {
		stationName = newName;
	}
	
	
	/**
	 * <p>getDayWithMostRiders()</p>
	 * 
	 * @return The day that saw the most riders.<br>
	 * Returns human indexing starting at day 1.
	 */
	public int getDayWithMostRiders() {
		int highestRider = allDays[0];
		int highestDay = 0;
		
		for(int i = 1; i < numDays; i++) {
			if(allDays[i] > highestRider) {
				highestRider = allDays[i];
				highestDay = i;
			}
		}
		
		return highestDay + 1;
	}
	
	
	/**
	 * <p>addDay</p>
	 * 
	 * <p>Adds a day's worth of ridership data to the existing array<br>
	 * allDays. If there is already 20 days worth of data, then it is<br>
	 * not added.</p>
	 * 
	 * @param numRiders A single day's worth of ridership data to be added.
	 */
	public void addDay(int numRiders) {
		if(numDays == 20) {
			return;
		}
		
		allDays[numDays] = numRiders;
		numDays++;
	}
	
	
	/**
	 * <p>getDaysRidership</p>
	 * 
	 * @param pos Which day between 1 to 20 to get the ridership data from.<br>
	 * It is in human indexing starting at 1 instead of 0.
	 * 
	 * @return The amount of riders that was seen that day.<br>
	 * Returns a -1 if there is no data that day.
	 * 
	 */
	public int getDaysRidership(int pos) {
		if(pos > numDays) {
			return -1;
		}
		
		return allDays[pos - 1];
	}
	
	
	/**
	 * <p>getAverage</p>
	 * 
	 * @return The average daily ridership across all days.
	 */
	public double getAverage() {
		double total = 0;
		
		for(int i = 0; i < numDays; i++) {
			total += allDays[i];
		}
		
		return total / numDays;
	}
	
	
	/**
	 * <p>toString</p>
	 * 
	 * @return The state of the object, or in this case,<br>
	 * the station name, all days worth of ridership data,<br>
	 * and the number of days the station had riders.
	 */
	public String toString() {
		String result = "Station Name: " + stationName + "\n";
		
		result += "All days occupied: " + "\n";
		
		for(int i = 0; i < numDays; i++) {
			result += "Day " + (i + 1) + ": " + allDays[i] + "\n";
		}
		
		result += "Number of days: " + numDays;
		
		return result;
	}
}