package perceptions;

/**
 * <p><b>Hash Table</b></p>
 * 
 * <p>This class creates a chained hash table using the<br>
 * SinglyLinkedList class. Each bucket contains a linked<br>
 * list. Keys are stored in the linked list.</p>
 * 
 * <p>Due 11/13/2021</p>
 * 
 * @author Richard Kim (n00923815)
 *
 * @param <E> Generic type of Integer which stores the<br>
 * ASCII value of each source of Datum.
 */
public class HashTable<E> {
	
	// The Hash Table
	private SinglyLinkedList[] array;
	private int size;
	private int numberOfItems;
	// The Hash Multiplier for the ASCII value
	private final int HASH_MULTIPLIER = 3;
	
	
	/**
	 * <p>HashTable</p>
	 * 
	 * <p>Constructor for the HashTable class. The<br>
	 * initial size is 3. Each bucket has a linked list.</p>
	 */
	public HashTable() {
		
		size = 3;
		array = new SinglyLinkedList[size];
		
		for(int i = 0; i < size; i++) {
			array[i] = new SinglyLinkedList<Integer>();
		}
		
		numberOfItems = 0;
	}
	
	
	/**
	 * <p>insert</p>
	 * 
	 * <p>Inserts an item into the hash table. The datum source<br>
	 * is converted to upper case and multiplied repeatedly by<br>
	 * the hash multiplier, then is remainder divided and added<br>
	 * into the hash table. If the number of items is greater<br>
	 * than the size, then the hash table will double in size<br>
	 * and all items are rehashed.</p>
	 * 
	 * @param datumSource The source of each Datum to convert to ASCII.
	 */
	public void insert(String datumSource) {
		
		datumSource = datumSource.toUpperCase();
		
		numberOfItems++;
		
		if(numberOfItems > size) {
			rehash();
		}
		
		int hashValue = hashMultiply(datumSource);
		
		array[hashValue % size].addFirst(hashMultiply(datumSource));
	}
	
	
	/**
	 * <p>hashMultiply</p>
	 * 
	 * <p>Takes in a Datum source and converts it to ASCII and<br>
	 * is multiplied repeatedly.</p>
	 * 
	 * @param datumSource The source of the Datum sent by the insert method.
	 * @return The hash value of the Datum source.
	 */
	private int hashMultiply(String datumSource) {
		int result = 0;
		
		for(int i = 0; i < datumSource.length(); i++) {
			result += /*(result * HASH_MULTIPLIER)*/ + datumSource.charAt(i);
		}
		
		return result;
	}
	
	
	/**
	 * <p>rehash</p>
	 * 
	 * <p>Rehashes the hash table. This is called by the insert<br>
	 * method once the number of items is greater than the size.</p>
	 */
	private void rehash() {
		Integer itemToHash;
		size = size * 2;
		
		SinglyLinkedList[] tempHashTable = new SinglyLinkedList[size];
		
		for(int i = 0; i < size; i++) {
			tempHashTable[i] = new SinglyLinkedList<Integer>();
		}
		
		for(int j = 0; j < size / 2; j++) {
			while(array[j].first() != null) {
				itemToHash = (Integer) array[j].removeFirst();
				tempHashTable[itemToHash % size].addFirst(itemToHash);
			}
		}
		
		array = tempHashTable;
		
	}
	
	
	/**
	 * <p>printHashTable</p>
	 * 
	 * <p>Prints a visualization of the hash table.</p>
	 */
	public void printHashTable() {
		for(int i = 0; i < size; i++) {
			System.out.print("Row" + i + ": ");
			for(int j = 0; j < array[i].getSize(); j++) {
				Integer item = (Integer) array[i].removeFirst();
				System.out.print(item + "->");
				array[i].addLast(item);
			}
			System.out.println();
		}
	}
	
	
	/**
	 * <p>getSize</p>
	 * 
	 * @return The size of the hash table.
	 */
	public int getSize() {
		return size;
	}
	
	
	/**
	 * <p>getRow</p>
	 * 
	 * @param index Which row to return.
	 * @return A specific row in the hash table, or the linked list.
	 */
	public SinglyLinkedList<Integer> getRow(int index) {
		return array[index];
	}
}
