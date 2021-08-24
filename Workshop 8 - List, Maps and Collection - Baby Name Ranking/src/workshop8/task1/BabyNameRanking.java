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

package workshop8.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BabyNameRanking {
	private static List<nameRank> babyNameBoy;
	private static List<nameRank> babyNameGirl;
	
	public BabyNameRanking() {
		babyNameBoy = new ArrayList<>();
		babyNameGirl = new ArrayList<>();
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
	
	public static void getReco(File src) throws IOException {
		String temp = null;
		nameRank nr = new nameRank();
		try {
			BufferedReader br = new BufferedReader(new FileReader(src));
			for(int i = 0; i < numReco(src); i++) {
				temp = br.readLine();
				if(temp != null) {
					String[] tempSplit = temp.split("\\s+");
					if(tempSplit.length == 5) {
						nr = new nameRank(tempSplit[1], Integer.parseInt(tempSplit[0].replaceAll(",", "")), 
								Integer.parseInt(tempSplit[2].replaceAll(",", "")), 'm');
						babyNameBoy.add(nr);
						nr = new nameRank(tempSplit[3], Integer.parseInt(tempSplit[0].replaceAll(",", "")),
								Integer.parseInt(tempSplit[4].replaceAll(",", "")), 'f'); 
						babyNameGirl.add(nr);
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println("File cannot be found");
		}
			
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
	
	public void getList() {
		System.out.print("Enter a filename for baby name ranking: ");
		String fn = getString();
		try {
			File bn = new File(fn);
			getReco(bn);
		}
		catch(Exception e){
			System.out.println("File name " + fn + " cannot be found.");
		}
	}
	
	public int unisexNameCount() {
		int cnt = 0;
		
		for(int i = 0; i < babyNameBoy.size(); i++) {
			for(int a = 0; a < babyNameGirl.size(); a++) {
				if(babyNameBoy.get(i).getName().equals(babyNameGirl.get(a).getName())) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	public void listUnisexName() {
		int cnt = 0;
		for(int i = 0; i < babyNameBoy.size(); i++) {
			for(int a = 0; a < babyNameGirl.size(); a++) {
				if(babyNameBoy.get(i).getName().equals(babyNameGirl.get(a).getName())) {
					cnt++;
					System.out.println(cnt + ". " + babyNameBoy.get(i).getName());
				}
			}
		}
	}
	
	public void listName(ArrayList<nameRank> src) {
		for(int i = 0; i < src.size(); i++) {
			System.out.println((i + 1) + ". " + src.get(i).getName());
		}
	}
	
	public void removeUnisexName() {
		for(int i = 0; i < babyNameBoy.size(); i++) {
			for(int a = 0; a < babyNameGirl.size(); a++) {
				if(babyNameBoy.get(i).getName().equals(babyNameGirl.get(a).getName())) {
					babyNameBoy.remove(i);
					i--; //decrements to avoid out of bounds
					babyNameGirl.remove(a);
					a--; //decrements to avoid out of bounds
				}
			}
		}
	}
	
	public void sortList() {
		Collections.sort(babyNameBoy, new Comparator<nameRank>() {

			@Override
			public int compare(nameRank o1, nameRank o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
			
		});
		
		Collections.sort(babyNameGirl, new Comparator<nameRank>() {

			@Override
			public int compare(nameRank o1, nameRank o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
			
		});
	}
	
	public void pause() { //pauses application
		Scanner o = new Scanner(System.in);
		String temp = null;
		
		temp = o.nextLine();
	}
	
	public void start() { //task 1
		getList();
		
		System.out.println(unisexNameCount() + " names used for both genders");
		
		System.out.println("They are: ");
		
		listUnisexName();
	}
	
	public void startp2() { //task 2
		sortList();
		removeUnisexName();
		
		System.out.println("The unique boy names in alphabetical order are:");
		
		listName((ArrayList<nameRank>) babyNameBoy);
		System.out.println("------------------------------------------------");
		System.out.println("Press enter to show unique girl names");
		pause();
		
		System.out.println("The unique girl names in alphabetical order are:");
		
		listName((ArrayList<nameRank>) babyNameGirl);
	}
}
