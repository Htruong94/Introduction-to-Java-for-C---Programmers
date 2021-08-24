/************************************
 * Workshop #4
 * Course: JAC444 - Semester 4
 * Last Name: Truong
 * First Name: Hung
 * ID: 147779193
 * Section: NEE
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signature
 * Date: 2/21/2021
 */

package ca.senecacollege.ws4.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LetterCount { //testClass
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String fn = null;
		char[] letter = {'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f'
				, 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k'
				, 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p'
				, 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't', 'T', 'u'
				, 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z'};
		
		Letter[] leto = new Letter[letter.length]; 
		
		for(int i = 0; i < letter.length; i++) {
			leto[i] = new Letter(letter[i], 0);
		}
		
		System.out.print("Enter a filename: ");
		fn = getString();
		System.out.println("=============================================");
		
		File lcf = new File(fn);

		getCount(leto, lcf);
		showCount(leto);
	}
	
	public static String getString() { //from Hangman program
		Scanner scan = new Scanner(System.in);
		boolean cstring = false;
		String string = null;
		do {
			try {
				string = scan.nextLine();
				cstring = true;
			}
			catch(Exception err){
				System.out.println("Please enter a valid string.");
			}
		}while(!cstring);
		return string;
	}
	
	public static void getCount(Letter[] src, File fn) throws FileNotFoundException, IOException {
		try(FileReader fr = new FileReader(fn)){
			char[] fileChars = new char[(int)(fn.length())];
			fr.read(fileChars);

			for(int i = 0; i < fileChars.length; i++) {
				for(int a = 0; a < src.length; a++) {
					if(fileChars[i] == src[a].getLetter()) {
						src[a].incrementCount();;
					}
				}
			}
		}
		catch(Exception err) {
			System.out.println("Unable to open the file: " + fn);
		}
	}
	public static void showCount(Letter[] src) {
		for(int i = 0; i < src.length; i++) {
			if(src[i].getCount() != 0) {
				System.out.println("Number of " + src[i].getLetter() + "'s:" + src[i].getCount());
			}
		}
	}
}
