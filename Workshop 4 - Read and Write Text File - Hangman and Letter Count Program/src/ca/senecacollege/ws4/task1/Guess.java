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

public class Guess {
	private char[] letter;
	private int numGuess;
	
	public Guess() {
		letter = new char[26];
		numGuess = 0;
	}

	public char getLetter(int num) {
		return letter[num];
	}

	public void setLetter(int num, char src) {
		this.letter[num] = src;
	}
	
	public int getNumGuess() {
		return numGuess;
	}

	public void setNumGuess(int numGuess) {
		this.numGuess = numGuess;
	}
}
