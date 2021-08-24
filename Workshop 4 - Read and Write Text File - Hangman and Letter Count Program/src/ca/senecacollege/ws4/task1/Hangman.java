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

package ca.senecacollege.ws4.task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Hangman { //testClass
	private static final String hangman = "hangman.txt";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File hm = new File(hangman);
		int misses = 0;
		char tempGuess = ' ';
		boolean valid = true;
		int correctLetters = 0;
		boolean match = false;
		char cont = 'y';
		
		header();
		
		try(FileOutputStream fout = new FileOutputStream(hm, true);
				FileInputStream fin = new FileInputStream(hm);
						PrintWriter pw = new PrintWriter(fout)){
			Guess guess = new Guess();
			while(cont == 'y') {
				char[] word = randomWord(hm).toCharArray();
				char[] wordHidden = new char[word.length];
			
				for(int i = 0; i < wordHidden.length; i++) {
					wordHidden[i] = '*';
				}
			
				while(correctLetters != wordHidden.length) {
			
					System.out.print("(Guess) Enter a letter in word ");
					System.out.print(wordHidden);
					System.out.print(" > ");
				
					tempGuess = getAlpha();
				
					for(int i = 0; i < guess.getNumGuess(); i++) {
						if(tempGuess == guess.getLetter(i)) {
							System.out.println("        " + tempGuess + " is already in the word");
							valid = false;
						}
					}
				
					if(valid) {
						guess.setLetter(guess.getNumGuess(), tempGuess);
						guess.setNumGuess(guess.getNumGuess() + 1);
						for(int a = 0; a < word.length; a++) {
							if(word[a] == tempGuess) {
								wordHidden[a] = tempGuess;
								correctLetters++;
								match = true;
							}
						}
						if(!match) {
							misses++;
						}
						match = false;
					}
					valid = true;
				}
			
				System.out.print("The word is ");
				System.out.print(word);
				System.out.println(". You missed " + misses + " time");
				System.out.println("Enter a new word to be added in the memory > ");
				addWord(hm);
				System.out.print("Do you want to guess another word? Enter y or n > ");
				cont = getAlpha();
				while(cont != 'y' && cont != 'n') {
					System.out.println("Invalid option.");
					System.out.print("Do you want to guess another word? Enter y or n > ");
					cont = getAlpha();
				}
				if(cont == 'y') {
					misses = 0;
					correctLetters = 0;
					guess = new Guess();
				}
				else {
					System.out.println("End of Hangman Game.");
				}
			}
		}
		catch(Exception err) {
			System.out.println("Unable to open the file " + hangman);
		}
		
	}
	
	public static void header() {
		System.out.println("Task 1: Hangman game");
		System.out.println("-------------------");
	}
	
	public static char getAlpha() {
		char input = ' ';
		Scanner scan = new Scanner(System.in);

		do {
			try {
				while(!Character.isAlphabetic(input)) {
					input = scan.next().charAt(0);
					if(!Character.isAlphabetic(input)) {
						System.out.print("Input is not an alphabet, please enter an alphabet letter: ");
					}
				}
			}
			catch(Exception err){
				System.out.println("Please enter a valid alphabet letter.");
			}
		}while(!Character.isAlphabetic(input));
		
		return Character.toLowerCase(input); //converts inputted character to lower case
	}
	
	public static String randomWord(File hm) throws IOException {
		String word = null;

		RandomAccessFile raf = new RandomAccessFile(hm, "r");

		long loc = (long)(Math.random()*hm.length());
		raf.seek(loc);
		raf.readLine();
		word = raf.readLine();

		return word;
	}
	
	public static String getString() {
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
	
	public static void addWord(File hm) throws IOException {
		String word = " ";
		word = getString();
		try(FileWriter fw = new FileWriter(hm,true)){
			fw.write("\n" + word.toLowerCase()); // protects to only have lower case values
		}
	}
	
}
