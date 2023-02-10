package perceptions;

/**
 * IGNORE THIS CLASS
 */
public class Node<E>{
	private E element;
	private int count;
	private Node<E> smaller;
	private Node<E> larger;
	
	public Node(E e) {
		element = e;
		count = 1;
		smaller = null;
		larger = null;
	}
	
	public int getCount() {
		return count;
	}
	
	public E getElement() {
		return element;
	}
	
	public Node<E> getSmaller(){
		return smaller;
	}
	
	public Node<E> getLarger(){
		return larger;
	}
	
	public void incrementCount() {
		count++;
	}
	
	public void setSmaller(Node<E> smallerNode) {
		smaller = smallerNode;
	}
	
	public void setLarger(Node<E> largerNode) {
		larger = largerNode;
	}
}
