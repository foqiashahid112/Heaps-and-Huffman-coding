package polling.treesheaps;

import java.io.FileReader;
import java.util.ArrayList;

import com.opencsv.CSVReaderHeaderAware;
/**
 * Note: Copied from lab 5
 * The Class that holds information on a single candidate and has a compareTo function which compares percentages and last Names
 * lexicographically
 *
 * @author: Foqia Shahid
 * @version: April 14th, 2020
 */

public class PollingData implements Comparable<PollingData>{
	private String lastName;
	private String fullName;
	private double percentage;
	
	/**
	 * Constructor that takes a string array whose indices correspond to column order of csv file
	 * @param pollingData String Array
	 */
	public PollingData(String [] pollingData) {
		lastName = pollingData[0];
		fullName = pollingData[1];
		percentage = Double.parseDouble(pollingData[2]);
	}

	/**
	 * Getter function for percentage
	 * @return double percentage value for candidate
	 */
	public double percentage() {
		return this.percentage;
	}
	
	/**
	 * Getter function for lastName
	 * @return String last name of candidate 
	 */
	public String lastName() {
		return this.lastName;
	}
	
	
	/**
	 * to String method
	 * @return String that writes Name and Percentage 
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.fullName);
		sb.append(":");
		sb.append(this.percentage);
		return sb.toString();
	}

	/**
	 * compareTo method that compares the last names of candidates by percentages and in case of equal percentages,
	 * compares last names lexicographically
	 * @param newData PollingData 
	 * @return int 0 if equal, 1 if less than and -1 greater
	 */
	@Override
	public int compareTo(PollingData newData) { 
		
		if((this.percentage) > (newData.percentage) ) {
	
			return 1;
		}
		else if( (this.percentage()) < (newData.percentage()) ) {
			return -1;
		}
		else {// percentages same
			if( ( (this.lastName()).compareTo(newData.lastName()) ) > 0 ) {  //this.lastName > newData.lastName
				return 1;
			}
			else if( ( (this.lastName()).compareTo(newData.lastName()) ) < 0  ){ //this.lastName < newData.lastName
				return -1;
			}
			else { //equal
				return 0;
			}
		}
		
	}

}
