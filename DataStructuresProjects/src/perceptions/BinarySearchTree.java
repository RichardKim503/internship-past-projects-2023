package perceptions;

/**
 * <p><b>Binary Search Tree</p></b>
 * 
 * <p>This class creates a binary search tree. This class<br>
 * has a nested node class that contains a piece of information<br>
 * and a link to two child nodes.</p>
 * 
 * @author Richard Kim (n00923815)
 *
 * @param <E> Generic type that will store a String for the Datum class.
 */
public class BinarySearchTree<E extends Comparable<E>> {

	// Binary tree node class
	private class BinaryNode<E extends Comparable<E>> {
		protected E data;						// The data to hold
		protected BinaryNode<E> left, right;	// The two child nodes

		
		/**
		 * <p>BinaryNode</p>
		 * 
		 * <p>Constructor for a binary tree node.<br>
		 * Holds a piece of data and sets the<br>
		 * children node to null.</p>
		 * 
		 * @param d The data to hold.
		 */
		public BinaryNode(E d) {
			data = d;
			left = right = null;
		}
		
		
		/**
		 * <p>toString</p>
		 * 
		 * @return The data in the node as a String.
		 */
		public String toString() {
			return "" + data;
		}
		
		
		/**
		 * <p>getData</p>
		 * 
		 * @return The data in the node.
		 */
		public E getData() {
			return data;
		}
	}

	
	
	private BinaryNode<E> root;	// The root node of the tree.

	
	/**
	 * <p>insert</p>
	 * 
	 * <p>A call to the insert method to insert a new piece of data<br>
	 * into the binary search tree. The user can use this method.</p>
	 * 
	 * @param d The data to insert.
	 */
	public void insert(E d) {
		root = insert(d, root);
	}
	
	
	/**
	 * <p>insert (private)</p>
	 * 
	 * <p>Inserts a new node that has data into the binary search<br>
	 * tree. If the tree is empty, the root holds the new data.<br>
	 * If the data is less than its parent or is equal, insert<br>
	 * the data to the left. If the data is larger, insert the<br>
	 * data to the right.
	 * 
	 * @param d The data to insert.
	 * @param root The root of the binary search tree.
	 * @return The root node.
	 */
	private BinaryNode<E> insert(E d, BinaryNode<E> root) {
		if (root == null)
			root = new BinaryNode<E>(d);
		else if(root.data.compareTo(d) > 0)
			root.left = insert(d, root.left);
		else if(root.data.compareTo(d) < 0)
			root.right = insert(d, root.right);
		else if(root.data.compareTo(d) == 0)
			root.left = insert(d, root.left);
		return root;
	}
	
	
	/**
	 * <p>printTree</p>
	 * 
	 * <p>A call to the printTree method to print out the entire tree.</p>
	 */
	public void printTree() {
		printTree(root);
	}
	
	
	/**
	 * <p>printTree (private)</p>
	 * 
	 * <p>Prints the entire binary search tree in order recursively.</p>
	 * 
	 * @param root
	 */
	private void printTree(BinaryNode<E> root) {
		if (root != null) {
			printTree(root.left);
			System.out.println(root.data + " ");
			printTree(root.right);
		}
	}
	
	
	/**
	 * <p>searchTree</p>
	 * 
	 * <p>Searches the tree for a specific piece of data.<br>
	 * 
	 * @param dataToSearch The data to search for.
	 * @return An integer array. The first index holds the number of comparisons<br>
	 * and the second index is 1 if the data exists, 0 if the data is not in tree.
	 */
	public int[] searchTree(E dataToSearch) {
		return searchTree(dataToSearch, root, 0);
	}
	
	
	/**
	 * <p>searchTree (private)</p>
	 * 
	 * <p>Searches the tree for a specific piece of data.<br>
	 * 
	 * @param dataToSearch The data to search for.
	 * @param root The root of the binary search tree.
	 * @param comparisons The number of comparisons it took to find the data.
	 * @return integer array. The first index holds the number of comparisons<br>
	 * and the second index is 1 if the data exists, 0 if the data is not in tree.
	 */
	public int[] searchTree(E dataToSearch, BinaryNode<E> root, int comparisons){
		int[] result = {comparisons, 0};
		if(root != null) {
			
			result = searchTree(dataToSearch, root.left, comparisons);
			if(root.getData().compareTo(dataToSearch) == 0) {
				comparisons++;
				return new int[]{comparisons, 1};
			}
			else {
				comparisons++;
			}
			result = searchTree(dataToSearch, root.right, comparisons);
		}
		
		return result;
	}
}
