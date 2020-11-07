package polling.treesheaps;

import java.util.LinkedList;

/**
 * both programs(HuffDecode and HuffEncode) make use of this class, which contains the tree data structure
 * @author Foqia Shahid
 * @version 13th May 2020
 *
 */
public class HuffTree {
	Character data;
	HuffTree left;
	HuffTree right;
	
	public HuffTree(){
		data = (Character) null;
		left = null;
		right =null;
	} 
	
	//call this for each pair above, this will create a new leaf node (and potentially other nodes along the way)
	/**
	 * Used to add nodes to recursive tree structure based on huffman coding
	 * @param symbol Takes in the symbol 
	 * @param code Takes in code associated with symbol
	 */
	public void addNode(char symbol, String code) {
		HuffTree pointer = this; //pointer to head of hufftree
		for(int i = 0; i < code.length(); i++) { //look at each number in code
			if(code.charAt(i) == '0') { //if 0 then move left
				if(pointer.left == null) {
					pointer.left = new HuffTree();
				}
				pointer = pointer.left;
			}
			else {//if 1 then move right
				if(pointer.right == null) {
					pointer.right = new HuffTree();
				}
				pointer = pointer.right;
			}
			if(i == code.length()-1) { //when at last digit in code (base case of leaf)
					pointer.data = symbol;
			}
		}//end loop
	}
	
	/**
	 * Helper that checks if the node is leaf
	 * @param node to check if it is leaf or not
	 * @return true if node is leaf, false otherwise
	 */
	public boolean isLeaf(HuffTree node) {
		return node.left == null && (node.right == null);
	}
	
	/**
	 * Decodes a message by going through tree from top and finding the symbol associated with code
	 * @param message to be decoded (code)
	 * @return String of symbols (decoded message)
	 */
	public String decode(String message) {
		HuffTree pointer = this; //start at top of tree
		String decoded = "";
		for(int i = 0; i <message.length(); i++) {
				if(message.charAt(i)== '0'){
					pointer = pointer.left;	
				}
				else {// char is 1
					pointer = pointer.right;
				}
				if(isLeaf(pointer)) {
					decoded = decoded + pointer.data;
					pointer = this;
				}
		}
		return decoded;
	}	
}
