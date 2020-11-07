package polling.treesheaps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.opencsv.CSVReaderHeaderAware;
/**
 * Main for Lab 6
 * @author Foqia Shahid
 *@version 14th April 2020
 */
public class Main {

    public static void main(String[] args) {
    	//Test1

    	Integer[] arr = {-2,3,9,-7,1,2,6,-3};
    	ArrayHeap<Integer> ArrayHeap1 = new ArrayHeap<Integer>();
    	for(int i = 0; i < arr.length; i++) {
    			ArrayHeap1.insert(arr[i]);
    		}
    	System.out.println("Test 1 ArrayHeap: \n" + ArrayHeap1);
	    ArrayHeap1.removeMax();
	    System.out.println("With max removed: \n" + ArrayHeap1);
    	
	    //Test 2
    	// create an ArrayList using static method "asList"
    	ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(arr));

    	// make a new heap out of the array
    	ArrayHeap<Integer> ArrayHeap2 = new ArrayHeap<Integer>(array);
    	System.out.println("Test 2 ArrayHeap: \n" + ArrayHeap2); // should print the same heap as before
    	ArrayHeap2.sort();
    	System.out.println("When sorted: \n" + array);
    	
    	
    	// Test 3
    	ArrayHeap<Character> letterHeap = new ArrayHeap<Character>();
    	letterHeap.insert('A');
    	letterHeap.insert('C');
    	letterHeap.insert('G');
    	letterHeap.insert('B');
    	letterHeap.insert('D');
    	letterHeap.insert('G'); // inserting again, will still both copies
    	letterHeap.insert('F');
    	letterHeap.insert('E');
    	letterHeap.insert('H');
    	letterHeap.insert('I');
    	System.out.println("Test 3 ArrayHeap size:" + letterHeap.size());
    	System.out.println("Test 3 ArrayHeap: \n" + letterHeap);
    	letterHeap.removeMax();
    	System.out.println("With max removed: \n" + letterHeap);
    	
    	
        // TODO: then read in the polling data from the given file (just one) and create
		// a heap of candidates to be sorted by their polling numbers
    	ArrayHeap<PollingData> myArrayHeap2 = new ArrayHeap<PollingData>();
    	String filePath = args[0];
    	try {
	    	CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(filePath));
			ArrayList<String[]> myEntries = new ArrayList<String[]>(reader.readAll());
			reader.close();
			for(String[] row : myEntries) {
				PollingData candidate = new PollingData(row); 
				myArrayHeap2.insert(candidate);
			}
    	}
    	catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
    	System.out.println("Input file ArrayHeap: \n" + myArrayHeap2);
    	
    	System.out.println("\nHeap Sort of Candidates using removeMax: \n"); 
    	while(!myArrayHeap2.isEmpty()) {
    		System.out.println(myArrayHeap2.removeMax());
    	}

   
    	
    	
    }
    
  
 
    
}
