package polling.treesheaps;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Class ArrayHeap forms a max Heap
 * @author: Foqia Shahid
 * @version: April 14th, 2020
 */

public class ArrayHeap<E extends Comparable<E>> implements PriorityQueue<E>{
	//Heap is implemented as an ArrayList
	private ArrayList<E> ArrayHeap;
	
	/**
	 * Constructor that is used to create the underlying array structure
	 */
	ArrayHeap(){
		ArrayHeap = new ArrayList<E>();
	}
	
	/**
	 * Constructor that takes in an unsorted ArrayList and converts it into a max heap
	 * @param array ArrayList<E>
	 */
	public ArrayHeap(ArrayList<E> array) {
		ArrayHeap = new ArrayList<E>();
		ArrayHeap = array;
		int n = array.size();
		for(int i = 0; i < n; i++) {//runs phase 1 of Heap sort
			bubbleUp(i);
		}
	}
	
	/**
	 * Function carries out phase 2 of Heap sort i.e. converted heap into a sorted array
	 * @return void
	 */
	public void sort() {
		int n = ArrayHeap.size();
		for(int i = n-1; i >= 0; i--) {
			swap(0,i);
			bubbleDown(i);
		}
	}

	
	/**
	 * Used to insert elements in Heap
	 * @param element E to be added
	 */
	public void insert(E element) {
		ArrayHeap.add(element);
		bubbleUp(ArrayHeap.size()-1);
	
	}
	
	/**
	 * Helper function that swaps two linked elements in Heap
	 * @param parent index of element to be swapped
	 * @param child index of element to be swapped
	 */
	public void swap(int parent, int child) {
		E temp = ArrayHeap.get(parent);
		ArrayHeap.set(parent, ArrayHeap.get(child));
		ArrayHeap.set(child, temp);
	}
	
	/**
	 * Helper that finds parent index of an element using the elements index
	 * @param i elements index
	 * @return int Index of parent
	 */
	public int parent(int i) {
		return (i-1)/2; //want to round down
	}
	
	/**
	 * Helper function that finds left child index of an element using the elements index
	 * @param i elements index
	 * @return int Index of left child
	 */
	public int leftChild(int i) {
		return 2*i+1;
	}
	
	/**
	 * Helper function that finds right child of an element using the elements index
	 * @param i elements index
	 * @return int Index of right child
	 */
	public int rightChild(int i) {
		return 2*i +2;
	}
	
	/**
	 * Bubble up Helper function
	 * @param index Index of element that needs to be bubbled up
	 */
	public void bubbleUp(int index) {
		int childIndex = index;
		while(ArrayHeap.get(childIndex).compareTo(ArrayHeap.get(parent(childIndex))) > 0 ) {//child > parent
			swap(parent(childIndex),childIndex);
			childIndex = parent(childIndex);
		}
		
	}

	/**
	 * Function used to remove max element from top of heap
	 * @return E the max element
	 */
	public E removeMax() {
		E rootElem = max();
		int lastElemIndex = ArrayHeap.size()-1;
		E lastElem = ArrayHeap.get(lastElemIndex);
		ArrayHeap.set(0, lastElem);
		ArrayHeap.remove(lastElemIndex);
	
		if(ArrayHeap.size() > 0) {
			//ArrayHeap.set(0, lastElem);
			//E toBubble = ArrayHeap.get(0);
			bubbleDown(ArrayHeap.size());
		}
		
		return rootElem;
	}

	/**
	 * Bubble down Helper function
	 * @param parent element that needs to be bubbled down till the end of heap
	 */
	public void bubbleDown(int end) {
		int parentIndex = 0;
		
		while( 
				((rightChild(parentIndex) < end)) &&
				((ArrayHeap.get(parentIndex).compareTo(ArrayHeap.get(leftChild(parentIndex) ) ) ) < 0 || 
				(ArrayHeap.get(parentIndex).compareTo(ArrayHeap.get(rightChild(parentIndex) ) ) ) < 0  )  ){//parent < either child
				
				if( (ArrayHeap.get(leftChild(parentIndex) ) ).compareTo(ArrayHeap.get(rightChild(parentIndex) ) ) > 0) {//leftChild > right Child
					swap(parentIndex, leftChild(parentIndex));
					parentIndex = leftChild(parentIndex);
					}
				
				else if((ArrayHeap.get(leftChild(parentIndex) ) ).compareTo(ArrayHeap.get(rightChild(parentIndex) ) ) <= 0){//leftChild <= rightChild
					swap(parentIndex, rightChild(parentIndex));
					parentIndex = rightChild(parentIndex);
					}
		}
		if(rightChild(parentIndex) >= end && leftChild(parentIndex) < end && (ArrayHeap.get(parentIndex).compareTo(ArrayHeap.get(leftChild(parentIndex) ) ) ) < 0){
			swap(parentIndex, leftChild(parentIndex));
			parentIndex = leftChild(parentIndex);
		}
	}

	/**
	 * Returns size of ArrayHeap
	 * @return int size of arrayHeap
	 */
	public int size() {
		return ArrayHeap.size();
	}

	/**
	 * checks if the arrayHeap is empty
	 * @return boolean true if arrayHeap is empty, else false
	 */
	public boolean isEmpty() {
		if(ArrayHeap.size()== 0)
			return true;
		return false;
	}
	
	/**
	 * returns max element in function
	 * @return E max element
	 */
	public E max() {
		return ArrayHeap.get(0);
	}
	
	/**
	 * toString method that prints out the ArrayHeap structure
	 * @return String ArrayHeap structure
	 */
	@Override
	public String toString() {
	StringBuilder sb = new StringBuilder();
	double b = 0;
	double a = Math.pow(2, b);
	
	double count = 0;
	for(int i = 0; i < ArrayHeap.size(); i++) {
		a = Math.pow(2, b);
	
		sb.append(ArrayHeap.get(i).toString() + " ");
		count = count + 1;
		if(count == a) {
			sb.append("\n");
			b +=1;
			count = 0;
		}
	}
		return sb.toString();
	}
	
}
