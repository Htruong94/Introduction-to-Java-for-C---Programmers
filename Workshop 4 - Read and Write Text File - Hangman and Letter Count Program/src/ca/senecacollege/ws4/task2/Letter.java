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

public class Letter {
	private char letter;
	private int count;
	
	public Letter() {
		setLetter(' ');
		setCount(0);
	}
	
	public Letter(char l, int c) {
		setLetter(l);
		setCount(c);
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void incrementCount() {
		this.count++;
	}
	
}
