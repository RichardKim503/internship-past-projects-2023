package perceptions;

/**
 * <p><b>SinglyLinkedList</b></p>
 * 
 * <p>This class creates an unsorted linked list data structure<br>
 * that also contains its own node class. This linked list<br>
 * is not ordered. List was implemented using the textbook.
 * 
 * <p>Due 9/25/21</p>
 * 
 * @author Richard Kim (n00923815)
 */
public class SinglyLinkedList<E> {

	// Node class
	protected static class Node<E>{
		private E element;
		private Node<E> next;
		
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		
		public E getElement() {
			return element;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public void setNext(Node<E> n) {
			next = n;
		}
		
		public void setElement(E e) {
			element = e;
		}
	}
	
	
	// LinkedList starts here
	protected Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	public SinglyLinkedList() {}
	
	// Accessors
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E first() {
		if(isEmpty()) {
			return null;
		}
		return head.getElement();
	}
	
	public E last() {
		if(isEmpty()) {
			return null;
		}
		return tail.getElement();
	}
	
	// Mutators
	public void addFirst(E e) {
		head = new Node<>(e, head);
		
		if(size == 0) {
			tail = head;
		}
		
		size++;
	}
	
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

	public int getSize() {
		return size;
	}
}