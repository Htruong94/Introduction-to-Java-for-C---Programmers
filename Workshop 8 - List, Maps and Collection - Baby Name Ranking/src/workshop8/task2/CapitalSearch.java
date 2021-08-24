/************************************
 * Workshop #8
 * Course: JAC444 - Semester 4
 * Last Name: Truong
 * First Name: Hung
 * ID: 147779193
 * Section: NEE
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signature
 * Date: 3/27/2021
 */

package workshop8.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CapitalSearch {
	Map<String, String> country;
	private static final String fn = "country.txt"; //storing country name and capital name into separate .txt file
	
	public CapitalSearch() {
		country = new HashMap<String, String>();
	}
	
	public void populateMap() { //puts records of country.txt into hashmap country
		try {
			String temp = null;
			File f = new File(fn);
			BufferedReader br = new BufferedReader(new FileReader(f));
			for(int i = 0; i < numReco(f); i++) {
				temp = br.readLine();
				if(temp != null) {
					String[] tempSplit = temp.split(",");
					country.put(tempSplit[0], tempSplit[1]);
				}
			}
		}
		catch(Exception e) {
			System.out.println("Cannot open file: " + fn);
		}
	}
	
	public static int numReco(File src) throws IOException {
		int numRec = 0;
		
		BufferedReader br = new BufferedReader(new FileReader(src));
		while(br.readLine() != null) {
			numRec++;
		}
		br.close();
		
		return numRec;
	}
	
	public static String getString() {
		String temp = null;
		Scanner scan = new Scanner(System.in);
		try {
			temp = scan.nextLine();
		}catch(Exception e) {
			System.out.println("Please enter a valid name.");
		}
		return temp;
	}
	
	public void start() {
		populateMap();
		String countryName = null;
		
		System.out.print("Please enter a Country name: ");
		countryName = getString();
		
		if(country.containsKey(countryName)) {
			System.out.println("The Capital City of " + countryName + " is: " + country.get(countryName));
		}
		else {
			System.out.println("The Country named " + countryName + " is not valid or not in the list.");
		}
	}
}
