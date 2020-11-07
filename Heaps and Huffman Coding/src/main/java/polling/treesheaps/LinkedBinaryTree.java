package polling.treesheaps;

/**
 * The Class that implements the BinaryTree interface
 *
 * @author: Foqia Shahid
 * @version: April 6, 2020
 */


public class LinkedBinaryTree<E extends Comparable<E>> implements BinaryTree<E> {

	private E data;
	private LinkedBinaryTree<E> left;
	private	LinkedBinaryTree<E> right;
	
	/**
	 * basic constructor
	 */
	LinkedBinaryTree() {
		data = null;
		left = null;
		right = null;
	}
	
	/**
	 * Constructor that takes a generic type E and creates a basic linked Binary Tree
	 * @param date E
	 */
	LinkedBinaryTree(E data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	/**
	 * Insert Function to add items to binary tree
	 * @param element item of generic type E that needs to be added to binary tree
	 * @return void
	 */
	public void insert(E element) {
		if(this.isEmpty()) {
			data = element;
			left = new LinkedBinaryTree<E>();
			right = new LinkedBinaryTree<E>();
		}
			if(element.compareTo(data) < 0){ //element < data
				left.insert(element);
			}
			else if(element.compareTo(data) > 0) { //element > data 11 > 8
				right.insert(element);
			}
			else { //element = data
				data = element;
			}
	}
	
	
	public void leftNode(E symbol) {
		data = symbol;
		left = new LinkedBinaryTree<E>();
		right = null;
	}
	
	public void rightNode(E symbol) {
		data = symbol;
		left = null;
		right = new LinkedBinaryTree<E>();
	}
	
	/**
	 * getter method for element in current root
	 * @return E the data stored in a node of the tree
	 */
	public E getRootElement() { 
		return this.data;
	}

	/**
	 * Finds size of binary tree
	 * @return int size of Binary Tree
	 */
	public int size() { 
		if(isEmpty()) {
			return 0;
		}
		else {
			return left.size() + 1 + right.size();
		}
	}

	/**
	 * Checks to see if binary tree is empty or not
	 * @return boolean corresponding to if tree is empty or not
	 */
	public boolean isEmpty() { 
		if(this.data == null) {
			return true;
		}
		return false;
	}

	/**
	 * Method that builds the final output for in-order traversal
	 * @return String that is to be outputted after in-order traversal is performed in InOrderHelper method
	 */
	public String toStringInOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append("In:\t");
		sb.append(InOrderHelper());
		
		return sb.toString().trim();
	}
	
	
	/**
	 * Helper method for toStringInOrder
	 * @return String that is created after in order traversal
	 */
	public String InOrderHelper() {
		StringBuilder sb = new StringBuilder();
		if(this.data == null) {
			return "";
		}
		if(this.data != null) {
			String leftString = left.InOrderHelper();
			sb.append(leftString);
			
			sb.append(data.toString() + " ");
			
			String rightString = right.InOrderHelper();
			sb.append(rightString);
		}
		
		return sb.toString();
	}

	/**
	 * Method that builds the final output for pre-order traversal
	 * @return String that is to be outputted after pre-order traversal is performed in PreOrderHelper method
	 */
	public String toStringPreOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append("Pre:\t");
		sb.append(PreOrderHelper());
		
		return sb.toString().trim();
	}
	
	/**
	 * Helper method for toStringPreOrder
	 * @return String that is created after pre order traversal
	 */
	public String PreOrderHelper() { // root-left-right
		StringBuilder sb = new StringBuilder();
		if(this.data == null) {
			return "";
		}
		if(this.data != null) {
			sb.append(data.toString() + " ");
			String leftString = left.PreOrderHelper();
			sb.append(leftString);
			String rightString = right.PreOrderHelper();
			sb.append(rightString);
		}
		return sb.toString();
	}

	/**
	 * Method that builds the final output for post-order traversal
	 * @return String that is to be outputted after post-order traversal is performed in PostOrderHelper method
	 */
	public String toStringPostOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append("Post:\t");
		sb.append(PostOrderHelper());
		
		return sb.toString().trim();
	}
	
	/**
	 * Helper method for toStringPostOrder
	 * @return String that is created after post order traversal
	 */
	public String PostOrderHelper() { // root-left-right
		StringBuilder sb = new StringBuilder();
		if(this.data == null) {
			return "";
		}
		if(this.data != null) {
			
			String leftString = left.PostOrderHelper();
			sb.append(leftString);
			String rightString = right.PostOrderHelper();
			sb.append(rightString);
			sb.append(data.toString() + " ");
		}
		return sb.toString();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Tree: \n");
		sb.append(this.toStringPreOrder() + "\n");
		sb.append(this.toStringInOrder() + "\n");
		sb.append(this.toStringPostOrder()+ "\n");
		return sb.toString();
	}


}
