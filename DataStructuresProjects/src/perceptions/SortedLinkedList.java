package perceptions;

/**
 * <p><b>SortedLinkedList</b></p>
 * 
 * <p>This class creates a sorted linked list data structure<br>
 * that also contains its own node class. This linked list<br>
 * is in order.</p>
 * 
 * <p>Due 10/23/21</p>
 * 
 * @author Richard Kim (n00923815)
 */
public class SortedLinkedList<E extends Comparable<E>> {

	// Node class
	private static class Node<E>{
		private E element;
		private Node<E> next;
		
		/**
		 * <p>Node</p>
		 * 
		 * <p>Constructor for a node.</p>
		 * 
		 * @param e The element that the node contains.
		 * @param n Points to the next node.
		 */
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
			
		/**
		 * <p>getElement</p>
		 * 
		 * @return The element in the node.
		 */
		public E getElement() {
			return element;
		}
			
		/**
		 * <p>getNext</p>
		 * 
		 * @return The next node.
		 */
		public Node<E> getNext() {
			return next;
		}
			
		/**
		 * <p>setNext</p>
		 * 
		 * @param n The node to set the next to.
		 */
		public void setNext(Node<E> n) {
			next = n;
		}
			
		/**
		 * <p>setElement</p>
		 * 
		 * @param e The element to set to.
		 */
		public void setElement(E e) {
			element = e;
		}
	}
		
		
	// LinkedList starts here
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	private int comparisons = 0;
		
	public SortedLinkedList() {}
		
	/**
	 * <p>isEmpty</p>
	 * 
	 * @return true if the list is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}
		
	/**
	 * <p>first</p>
	 * 
	 * @return The first element.
	 */
	public E first() {
		if(isEmpty()) {
			return null;
		}
		return head.getElement();
	}
		
	/**
	 * <p>last</p>
	 * 
	 * @return The last element.
	 */
	public E last() {
		if(isEmpty()) {
			return null;
		}
		return tail.getElement();
	}
		
	/**
	 * <p>addFirst</p>
	 * 
	 * <p>Adds a node with an element at the first position.<br>
	 * Nodes are sorted as they are added to the list.</p>
	 * 
	 * @param e The element to add.
	 */
	public void addFirst(E e) {
		head = new Node<>(e, head);
			
		if(size == 0) {
			tail = head;
		}
			
		size++;
		sort();
	}
		
	/**
	 * <p>addLast</p>
	 * 
	 * <p>Adds a node with an element to the last position.<br>
	 * Is not sorted as they are added.
	 * 
	 * @param e The element to add.
	 */
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
			
		if(isEmpty()) {
			head = newest;
		}
		else {
			tail.setNext(newest);
		}
		tail = newest;
			
		size++;
	}
		
	/**
	 * <p>removeFirst</p>
	 * 
	 * @return The first element and removes it.
	 */
	public E removeFirst() {
		if(isEmpty()) {
			return null;
		}
			
		E answer = head.getElement();
		head = head.getNext();
		size--;
			
		if(size == 0) {
			tail = null;
		}
			
		return answer;
	}

	/**
	 * <p>getSize</p>
	 * 
	 * @return The size of the list.
	 */
	public int getSize() {
		return size;
	}
		
	/**
	 * <p>countComparisons</p>
	 * 
	 * <p>Adds one comparison from the insertion sort<br>
	 * when one comparison is made.
	 * 
	 * @return true always to keep the loop going.
	 */
	private boolean countComparisons() {
		comparisons++;
		return true;
	}
		
	/**
	 * <p>getComparisons</p>
	 * 
	 * @return The number of comparisons needed to sort loop.
	 */
	public int getComparisons() {
		return comparisons;
	}
	
	/**
	 * <p>sort</p>
	 * 
	 * <p>Uses an insertion sort to sort the linked list.<br>
	 * As nodes are being added to the list, the elements<br>
	 * are compared to one another to sort the list. It also<br>
	 * counts the number of comparisons needed to sort the<br>
	 * list and only runs until the new element is sorted.</p>
	 */
	public void sort() {
		if(size > 1) {
			E temp;
			Node<E> first = head;
			Node<E> second = head.next;
			
			while(first.getElement().compareTo(second.getElement()) > 0 && countComparisons() ) {
				
				temp = second.getElement();
				second.setElement(first.getElement());
				first.setElement(temp);
				
				if(second.next != null) {
					first = first.next;
					second = second.next;
				}
			}
		}
	}
}