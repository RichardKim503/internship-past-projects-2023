package perceptions;

//import com.google.gson.*;
import java.util.*;
import java.io.*;
import java.text.*;

/**
 * <p><b>Project 2</p></b>
 * 
 * <p>This class takes in information from rows.json and<br>
 * adds them to an unordered, singly linked list. The json<br>
 * file contains information about the average grades from<br>
 * each borough in NYC, and each grade. The user can then<br>
 * ask to search for a source, for example "Bronx" for a<br>
 * borough, "3" for grade 3, and "2007" for a year. It will<br>
 * then display the first line of info for each source.</p>
 * 
 * <p>This class now has both an unsorted linked list and<br>
 * sorted linked list. The user will be prompted to enter<br>
 * a source and this program will search both the unsorted<br>
 * and the sorted list and the output for both will be<br>
 * given at the same time.</p>
 * 
 * <p>This class now has a chained hash table using the<br>
 * SinglyLinkedList class. The user will be prompted to<br>
 * enter a source and this program will convert the Datum<br>
 * source into an ASCII value using a hash multiplier.<br>
 * The hash multiplier should be very efficient and most<br>
 * Datum should take O(0) or O(1) comparisons with special<br>
 * exceptions.</p>
 * 
 * <p>This class is based off of the View class.</p>
 * 
 * <p>Due 11/13/21</p>
 * 
 * @author Richard Kim (n00923815)
 *
 */
public class Proj1 {

	public static void main(String[] args)
    {
		// The list to store the datums.
    	SinglyLinkedList<Datum> list = new SinglyLinkedList<Datum>();
    	SortedLinkedList<String> listSorted = new SortedLinkedList<String>();
    	HashTable<Integer> hashTable = new HashTable<Integer>();
    	BinarySearchTree<String> tree = new BinarySearchTree<String>();
    	
        Scanner scan = new Scanner(System.in); //System.in is a standard input stream.
        String[] names;
        JsonArray[] dataset;

        try
        {
            // hardwired name for input file, students should replace with the file they select
            String filename = "rows.json";
            JsonObject input = JsonParser.parseReader(new FileReader(filename)).getAsJsonObject();
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
/*
            System.out.println(gson.toJson(input));
 */
            // get the columns of the data to work with
            JsonObject meta = input.getAsJsonObject("meta");
            JsonObject view = meta.getAsJsonObject("view");
            JsonArray columns = view.getAsJsonArray("columns");
            int sourceIndex = selectSource(columns, scan);
            Datum.setCategory(columns.get(sourceIndex).getAsJsonObject().get("name").getAsString());
            int numberIndex = selectNumber(columns, scan);
            Datum.setNumberName(columns.get(numberIndex).getAsJsonObject().get("name").getAsString());
            // create Datums from all the data in the json file and output them
            JsonArray data = input.getAsJsonArray("data");
            // traverse the data
            JsonArray dataItem = data.get(0).getAsJsonArray();
            for (int dataIndex = 0; dataIndex < data.size(); dataIndex+=1)
            {
                Datum toOutput = new Datum
                        (
                                data.get(dataIndex).getAsJsonArray().get(sourceIndex).getAsString(),
                                data.get(dataIndex).getAsJsonArray().get(numberIndex).getAsDouble()
                        );
//                System.out.println(toOutput);
                
                list.addLast(toOutput);
                //System.out.println(toOutput.getSource());
                listSorted.addFirst(toOutput.getSource());
                hashTable.insert(toOutput.getSource());
                tree.insert(toOutput.getSource().toUpperCase());
            }
            
            
        } catch (Throwable t)
        {
            t.printStackTrace(System.err);
        }
        
//        int ehehe = listSorted.getSize();
//        for(int i = 0; i < ehehe; i++) {
//        	System.out.println(listSorted.removeFirst());
//        }
        
//        hashTable.printHashTable();
//        tree.printTree();
        // MY PART OF THE CODE
        boolean exit = false;	// The condition to determine if the user wants to terminate
        boolean found = false;	// If the source is found, this returns the info to the user
        boolean foundSorted = false;
        boolean foundHash = false;
        String source;			// The name of the source to find
        int totalComparisons = 0;	// The total amount of comparisons
        int totalSortedComparisons = 0;
        int totalHashComparisons = 0;
        int totalTreeComparisons = 0;
        final int HASH_MULTIPLIER = 3;
        
        System.out.println(listSorted.getComparisons() + " comparisons needed to sort data.");
        
        while(!exit) {
        	System.out.println("\nWhat Source would you like to find? "
        			+ "Enter \"exit\" to terminate:");
        	
        	// Asks the user for input and changes to upper case
        	source = scan.nextLine();
        	
        	if(source.length() == 0) {
        		source = scan.nextLine();
        	}
        	
//        	source = source.toUpperCase();
        	
        	// Exits the program
        	if(source.toUpperCase().equals("EXIT")) {
        		System.out.println("Exiting program");
        		exit = true;
        	}
        	// The program searches for the user's source input
        	else {
        		System.out.println();
        		System.out.println("[]" + source + "[]");
        		System.out.println();
        		
        		int i;
        		int x;
        		int b;
        		Datum currentDatum;
        		String currentDatumSorted;
        		int currentDatumHash;
        		
        		// Searches for the data using a linear search
        		// Removes the first item in the list then adds it to the back
        		for(i = 1; i < list.getSize(); i++) {
        			totalComparisons++;
        			currentDatum = list.removeFirst();
        			list.addLast(currentDatum);
        			
        			if(currentDatum.getSource().toUpperCase().equals(source.toUpperCase())) {
        				System.out.println(currentDatum.toString());
        				System.out.println();
        				System.out.println("----------------------------------------");
        				System.out.println();
        				
        				System.out.println("Source found in unsorted linked list:");
        				System.out.println();
        				
        				found = true;
        				break;
        			}
        		}
        		
        		// If the source is found, prints how many comparisons it needed
        		if(found) {
        			System.out.println(i + " comparisons needed for current search in unsorted.");
        			System.out.println(totalComparisons + " comparisons this session.");
        			found = false;
        		}
        		// If the source is not found, it resets comparisons
        		else {
        			i--;
        			System.out.println("Source not present in unsorted list.");
        			System.out.println(i + " comparisons needed for current search in unsorted.");
        			System.out.println(totalComparisons + " comparisons this session.");
        			
        		}
        		
        		System.out.println();
        		System.out.println("----------------------------------------");
        		System.out.println();
        		
        		// Resets the list back to default before next input
        		for(int j = 0; j < list.getSize() - i; j++) {
        			currentDatum = list.removeFirst();
        			list.addLast(currentDatum);
        		}
        		
        		
        		
        		// Searches for the data in the SORTED list
        		// Removes the first item in the list then adds it to the back
        		for(x = 1; x < listSorted.getSize(); x++) {
        			totalSortedComparisons++;
        			currentDatumSorted = listSorted.removeFirst();
        			listSorted.addLast(currentDatumSorted);
        			
        			if(currentDatumSorted.toUpperCase().compareTo(source.toUpperCase()) > 0) {
        				x++;
        				break;
        			}
        			
        			if(currentDatumSorted.toUpperCase().equals(source.toUpperCase())) {
        				System.out.println("Source found in sorted linked list");
        				System.out.println(currentDatumSorted);
        				System.out.println();
        				
        				foundSorted = true;
        				break;
        			}
        		}
        		
        		// If the source is found, the print how many comparisons 
        		// it needed, how many comparisons this session, and how
        		// many comparisons in total including construction of list.
        		if(foundSorted) {
        			System.out.println(x + " comparisons needed for current search in sorted list.");
        			System.out.println(totalSortedComparisons + " comparisons this session.");
        			System.out.println(listSorted.getComparisons() + totalSortedComparisons +
        					" total comparions made.");
        			foundSorted = false;
        		}
        		// If source is not found.
        		else {
        			x--;
        			System.out.println("Source not present in sorted list.");
        			System.out.println(x + " comparisons needed for current search in sorted list.");
        			System.out.println(totalSortedComparisons + " comparisons this session.");
        			System.out.println(listSorted.getComparisons() + totalSortedComparisons +
        					" total comparions made.");
        		}

        		// Resets the sorted list back to original state to
        		// get it ready for searching and comparing again.
        		for(int y = 0; y < listSorted.getSize() - x; y++) {
        			currentDatumSorted = listSorted.removeFirst();
        			listSorted.addLast(currentDatumSorted);
        		}
        		
        		
        		
        		// Searches for the data in the hash table
        		// Converts the source the user is looking for into ASCII
        		// The ASCII value is multiplied repeated by the hash table multiplier
            	int sourceASCII = 0;
            	for(int a = 0; a < source.length(); a++) {
            		sourceASCII += /*(sourceASCII * HASH_MULTIPLIER)*/ + source.toUpperCase().charAt(a);
            	}
            	
            	// Gets the row from the hash table and searches.
            	SinglyLinkedList<Integer> hashList = hashTable.getRow(sourceASCII % hashTable.getSize());
            	
            	for(b = 1; b < hashList.getSize(); b++) {
            		totalHashComparisons++;
            		currentDatumHash = hashList.removeFirst();
            		hashList.addLast(currentDatumHash);
            		
            		// If the Datum source is found.
            		if(currentDatumHash == sourceASCII) {
            			System.out.println();
            			System.out.println("----------------------------------------");
            			System.out.println();
            			
            			System.out.println("Source found in hash table.");
            			
            			foundHash = true;
            			break;
            		}
            	}
            	
            	// If the Datum source is found in the hash table.
            	if(foundHash) {
            		System.out.println(b + " comparisons needed for current search in hash table.");
            		System.out.println(totalHashComparisons + " comparisons this session");
            		foundHash = false;
            	}
            	// If the Datum source is NOT found in the hash table.
            	else {
            		System.out.println();
        			System.out.println("----------------------------------------");
        			System.out.println();
            		
            		b--;
            		System.out.println("Source not present in hash table.");
            		System.out.println(b + " comparisons needed for current search in hash table.");
            		System.out.println(totalHashComparisons + " comparisons this session");
            	}
            	
            	// Resets the sorted list back to original state to
        		// get it ready for searching and comparing again.
            	if(hashList.getSize() > 0) {
	            	for(int c = 0; c < hashList.getSize() - b; c++) {
	            		currentDatumHash = hashList.removeFirst();
	            		hashList.addLast(currentDatumHash);
	            	}
            	}
            	
            	System.out.println();
    			System.out.println("----------------------------------------");
    			System.out.println();
        		
        		
        		// Searches for the data in the binary search tree
        		int[] treeResult = tree.searchTree(source.toUpperCase());
        		
        		// Adds to the total number of comparisons this session.
        		totalTreeComparisons += treeResult[0];
        		
        		// If the data does not exist in the tree.
        		if(treeResult[1] == 0) {
        			System.out.println("Source not present in binary search tree.");
        		}
        		// If the data does exist.
        		else {
        			System.out.println("Source found in binary search tree.");
        		}
        		
        		// Prints the total number of comparisons this session
        		// and how many comparisons were need for this search.
        		System.out.println(treeResult[0] + " comparisons need for current search in binary search tree.");
        		System.out.println(totalTreeComparisons + " comparisons this session.");
        		
        		System.out.println();
        		System.out.println("========================================");
        		System.out.println();
        		System.out.println();
        		
        	}
        }
    }
    

    /** selects a column for the sources of the data from the json file */
    public static int selectSource(JsonArray cols, Scanner fromUser)
    {
        // traverse the list of columns listing all the valid source names
        for (int index = 0; index < cols.size(); index += 1)
        {
            JsonElement column = cols.get(index);
            // valid sources are all of type text
            if(column.getAsJsonObject().get("dataTypeName").toString().equals("\"text\""))
            {
                System.err.println(""+index+": "+column.getAsJsonObject().get("name"));
            }
        }
        System.err.print("Select a column number above for the name of the source category: ");
        return fromUser.nextInt();
    }// end selectSource
    public static int selectNumber(JsonArray cols, Scanner fromUser)
    {
        // traverse the list of columns listing all the valid source names
        for (int index = 0; index < cols.size(); index += 1)
        {
            JsonElement column = cols.get(index);
            // valid sources are all of type text
            if(column.getAsJsonObject().get("dataTypeName").toString().equals("\"number\""))
            {
                System.err.println(""+index+": "+column.getAsJsonObject().get("name"));
            }
        }
        System.err.print("Select a column number above for the name of the source category: ");
        return fromUser.nextInt();
    }// end selectSource
}
