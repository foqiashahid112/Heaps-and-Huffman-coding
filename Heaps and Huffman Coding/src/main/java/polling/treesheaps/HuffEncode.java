package polling.treesheaps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import com.opencsv.CSVReaderHeaderAware;

/**
 * this program will take a text file and encode it using the coding below
 * @author Foqia Shahid
 * @version 13th May 2020
 *
 */
public class HuffEncode { 
	public static final String[] CODES = {"000", "110", "0010", "0011", "0100", "0110", "0111", "1001", "1010", "10000", "10111", "11111", "010100", "010101", "010110", "100010", "100011", "101101", "111000", "111001", "111011", "111100", "1011000", "1110100", "1110101", "11110110", "11110111", "010111101", "010111111", "101100100", "101100101", "111101000", "111101010", "0101110001", "0101110010", "0101110011", "0101110111", "0101111000", "0101111001", "0101111100", "0101111101", "1011001101", "1011001110", "1011001111", "1111010010", "1111010111", "01011100000", "01011100001", "01011101000", "01011101001", "01011101011", "10110011000", "11110100110", "11110100111", "11110101100", "11110101101", "010111010101", "010111011000", "010111011001", "010111011010", "101100110011", "0101110101000", "0101110101001", "0101110110111", "01011101101100", "01011101101101", "10110011001000", "10110011001011", "101100110010011", "1011001100100100", "1011001100100101", "1011001100101000", "1011001100101001", "10110011001010100", "10110011001010101", "10110011001010110", "101100110010101111", "10110011001010111011", "101100110010101110000", "101100110010101110001", "101100110010101110010", "101100110010101110011", "101100110010101110100", "101100110010101110101"};
	public static final char[] SYMBOLS = {'e', ' ', 's', 'h', 'i', 'n', 'o', 'a', 't', 'l', 'd', 'r', 'p', ',', 'y', 'g', 'f', 'w', 'm', 'c', '\n', 'u', 'v', '.', 'b', '\"', 'k', '-', 'P', 'A', 'T', '\'', 'I', 'j', 'z', 'q', 'W', 'S', 'R', '?', 'M', 'B', 'N', 'x', '!', 'H', 'V', ';', 'K', 'Y', 'G', 'O', 'F', 'D', 'C', 'E', '(', ')', 'X', 'L', ':', '*', 'J', '1', '2', '0', '8', 'U', 'Z', '7', '5', '6', '3', '/', '9', 'Q', '4', '[', '#', ']', '%', '=', '@', '$'};
	
	//For more testing
	//	public static final String[] CODES = {"0000", "110", "0010", "0011", "0100", "0110", "0111", "1001", "1010", "10000", "10111", "11111", "010100", "010101", "010110", "100010", "100011", "101101", "111000", "111001", "111011", "111100", "1011000", "1110100", "1110101", "11110110", "11110111", "010111101", "010111111", "101100100", "101100101", "111101000", "111101010", "0101110001", "0101110010", "0101110011", "0101110111", "0101111000", "0101111001", "0101111100", "0101111101", "1011001101", "1011001110", "1011001111", "1111010010", "1111010111", "01011100000", "01011100001", "01011101000", "01011101001", "01011101011", "10110011000", "11110100110", "11110100111", "11110101100", "11110101101", "010111010101", "010111011000", "010111011001", "010111011010", "101100110011", "0101110101000", "0101110101001", "0101110110111", "01011101101100", "01011101101101", "10110011001000", "10110011001011", "101100110010011", "1011001100100100", "1011001100100101", "1011001100101000", "1011001100101001", "10110011001010100", "10110011001010101", "10110011001010110", "101100110010101111", "10110011001010111011", "101100110010101110000", "101100110010101110001", "101100110010101110010", "101100110010101110011", "101100110010101110100", "101100110010101110101", "000100", "000101", "0001100", "0001101", "00011100", "00011101", "0001111"};
	//	 public static final char[] SYMBOLS = {'e', ' ', 's', 'h', 'i', 'n', 'o', 'a', 't', 'l', 'd', 'r', 'p', ',', 'y', 'g', 'f', 'w', 'm', 'c', '\n', 'u', 'v', '.', 'b', '\"', 'k', '-', 'P', 'A', 'T', '\'', 'I', 'j', 'z', 'q', 'W', 'S', 'R', '?', 'M', 'B', 'N', 'x', '!', 'H', 'V', ';', 'K', 'Y', 'G', 'O', 'F', 'D', 'C', 'E', '(', ')', 'X', 'L', ':', '*', 'J', '1', '2', '0', '8', 'U', 'Z', '7', '5', '6', '3', '/', '9', 'Q', '4', '[', '#', ']', '%', '=', '@', '$', '_', '~', '<', '\\', '>', '+', '`'};
	
	 public static void main(String[] args) {
		HashMap<Character, String> map = new HashMap<Character, String>(); 
		for(int i = 0; i < SYMBOLS.length; i++) {
			map.put(SYMBOLS[i], CODES[i]);
		}
		String coded = "";
		String decodedIn = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			int num = 0;
			char ch;
			while( ( num=br.read() ) != -1) {
				ch = (char)num;	
				decodedIn = decodedIn + ch;
			}
			System.out.println("Input: ");
			System.out.println(decodedIn);
			br.close();
			for(int i = 0; i < decodedIn.length(); i++) {
				Character key = decodedIn.charAt(i);
				coded = coded + map.get(key);
			}
    	}
    	catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		/**
		 * Testing to see if same code produced as the original file that was decoded
			System.out.println(coded);
			String test = "1110111100101010101110000101011100001101100110011010111000010101011110111101101100101110000101011100001010111000010101110000101011100001111011110110010101101100110011010111000010101110000110110011001101011100001110110110110010101111101000101100110010101110011111010011101111011001011100001101100110011010111000011011001100110101110000111110100011011101000101111011111011011001010111110100011101001110111101101111010001011001100110101110000110110011001101011100001010101101100110010101001101100101010101111010101111011011001100111011001100101011100110111111011110110110111101000010111000010101110000110110011001101011100001110110101100110010101110011111010010110011001010100010111011000010111101111011110110110110110111101000111101101011001100101011100110101111011101100101110110000101111011111011011101111011011011011011011011011011110100001011110101011110111110100011110110111011";
			if(test.equals(coded)) {
				System.out.println("same");
			}
			else {
				System.out.println("not same");
				System.out.println(test);
			}
			*/
		System.out.println("Coded: " + coded);
	}
	 
	
	
	
}