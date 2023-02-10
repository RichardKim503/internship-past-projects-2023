package proj6;

/**
 * <p>Title: CSC 120 Project 6: StationList Class</p>
 * 
 * <p>Description: This class contains information about a list<br>
 * of Station objects. This method can return the number of<br>
 * Stations in the list, return all the Station names along with<br>
 * their averages, add an indefinite amount of new Stations,<br>
 * remove a station, and return the Station that has the highest<br>
 * single day ridership. All Station methods can be called as well.</p>
 * 
 * <p>Due 12/21 11:59 PM</p>
 * 
 * @author Richard Kim (n00923815@students.ncc.edu)
 *
 */
public class StationList {

	private Station[] allStations; // The array to hold all of the Stations.
	private int numStations;	   // The number of Stations.
	
	
	/**
	 * <p>StationList default constructor</p>
	 * 
	 * <p>This is the default constructor of the StationList class.<br>
	 * It creates an array that holds 0 stations and sets the<br>
	 * numStations to 0 since there are no stations.</p>
	 */
	public StationList() {
		allStations = new Station[0];
		numStations = 0;
	}
	
	
	/**
	 * <p>StationList parameterized constructor</p>
	 * 
	 * <p>This is the parameterized constructor of the StationList<br>
	 * class. It takes in an array of Stations and adds them to the<br>
	 * allStations array. It also sets numStations to the number<br>
	 * of stations in the parameter.</p>
	 * @param myStations
	 */
	public StationList(Station[] myStations) {
		allStations = new Station[myStations.length];
		numStations = myStations.length;
		
		for(int i = 0; i < myStations.length; i++) {
			allStations[i] = myStations[i];
		}
	}
	
	
	/**
	 * <p>getNumStations</p>
	 * 
	 * @return The number of stations in the StationList.
	 */
	public int getNumStations() {
		return numStations;
	}
	
	
	/**
	 * <p>getStation</p>
	 * 
	 * @param pos The position, or index, of the Station you want to return<br>
	 * from the StationList.
	 * 
	 * @return A station at the given position in human indexing starting at 1.<br>
	 * If the position of the Station does not exist, it returns null instead.
	 */
	public Station getStation(int pos) {
		if(pos < 1 || pos > numStations) {
			return null;
		}
		
		Station result = allStations[pos - 1];
		return result;
	}
	
	
	/**
	 * <p>insertStation</p>
	 * 
	 * <p>Adds a new Station at the end of the StationList.<br>
	 * It will first expand the capacity of the StationList<br>
	 * by one before adding.
	 * 
	 * @param myStation The Station object to be added.
	 */
	public void insertStation(Station myStation) {
		expandCapacity();
		
		allStations[allStations.length - 1] = myStation;
		numStations++;
	}
	
	
	/**
	 * <p>removeStation</p>
	 * 
	 * <p>Removes a station at the given position. A station does not<br>
	 * get removed if the position does not exist within the StationList.</p>
	 * 
	 * @param pos The position at which the Station will be removed<br>
	 * in human indexing starting at 1.
	 */
	public void removeStation(int pos) {
		if(pos < 1 || pos > numStations) {
			return;
		}
		pos--;
		
		for(int i = pos; i < numStations - 1; i++) {
			allStations[i] = allStations[i + 1];
		}
		numStations--;
	}
	
	
	/**
	 * <p>highestRidership</p>
	 * 
	 * @return The Station that has the highest single day ridership.
	 */
	public Station highestRidership() {
		if(numStations == 0) {
			return null;
		}
		
		Station highestStation = allStations[0];
		int highest = allStations[0].getDaysRidership(allStations[0].getDayWithMostRiders());
		
		for(int i = 1; i < numStations; i++) {
			if(highest < allStations[i].getDaysRidership(allStations[i].getDayWithMostRiders())) {
				highestStation = allStations[i];
				highest = allStations[i].getDaysRidership(allStations[i].getDayWithMostRiders());
			}
		}
		
		return highestStation;
	}
	
	
	/**
	 * <p>expandCapacity</p>
	 * 
	 * <p>This class expands the capacity of the StationList by one.<br>
	 * Can only be called within this class.</p>
	 */
	private void expandCapacity() {
		Station[] temp = new Station[allStations.length + 1];
		
		for(int i = 0; i < allStations.length; i++) {
			temp[i] = allStations[i];
		}
		
		allStations = temp;
	}
	
	
	/**
	 * <p>toString</p>
	 * 
	 * <p>Overrides the toString method. This returns the number of stations,<br>
	 * all of the station names, and their respective ridership average.</p>
	 */
	public String toString() {
		String result = "Number of Stations: " + numStations + "\n";
		result += "\n" + "All station names and average ridership: ";
		
		if(numStations == 0) {
			return result;
		}
		result += "\n" + allStations[0].getStationName();
		result += ": " + allStations[0].getAverage();
		
		for(int i = 1; i < numStations; i++) {
			result += "\n" + allStations[i].getStationName();
			result += ": " + allStations[i].getAverage();
		}
		
		return result;
	}
}