/************************************
 * Workshop #7
 * Course: JAC444 - Semester 4
 * Last Name: Truong
 * First Name: Hung
 * ID: 147779193
 * Section: NEE
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signature
 * Date: 3/20/2021
 */

package workshop7.task1;

import java.util.Scanner;

public class ConnectFour{
	
	public static int getInt() {
		int inp = -1;
		Scanner scan = new Scanner(System.in);
		try {
			inp = scan.nextInt();
		}catch(Exception e) {
			System.out.println("Please enter an Integer.");
		}
		return inp;
	}
	
	public static void grid(char[][] src) {
		for(int c = 0; c < 6; c++) {
			for(int r = 0; r < 7; r++) {
				System.out.print("|" + src[r][c]);
			}
			System.out.println("|");
		}
		System.out.println("---------------");
	}
	
	public static char status(char[][] src) {
		char stat = 'd'; //c == continue, d == draw, r == red win, y == yellow win
		
		int yellow = 0;
		int red = 0;
		
		for(int c = 0; c < 7; c++) { //check if there are any empty slots
			for(int r = 0; r < 6; r++) {
				if(src[c][r] == ' ') {
					stat = 'c';
				}
			}
		}
		if(stat == 'c') {
			for(int c = 0; c < 7; c++) { //checking horizontal win condition
				for(int r = 0; r < 6; r++) {
					if(src[c][r] == 'Y') {
						yellow++;
						red = 0;
						if(yellow == 4) {
							stat = 'y';
						}
					}
					else if(src[c][r] == 'R') {
						red++;
						yellow = 0;
						if(red == 4) {
							stat = 'r';
						}
					}
					else {
						red = 0;
						yellow = 0;
					}
				}
			}
		}
		
		if(stat == 'c') {
			for(int r = 0; r < 6; r++) { //check vertical win condition
				for(int c = 0; c < 7; c++) {
					if(src[c][r] == 'Y') {
						yellow++;
						red = 0;
						if(yellow == 4) {
							stat = 'y';
						}
					}
					else if(src[c][r] == 'R') {
						red++;
						yellow = 0;
						if(red == 4) {
							stat = 'r';
						}
					}
					else {
						red = 0;
						yellow = 0;
					}
				}
			}
		}
		
		if(stat == 'c') {
			for(int r = 0; r < 3; r++) {
				for(int c = 0; c < 4; c++) {
					if(src[c][r] == 'Y' && src[c+1][r+1] == 'Y' &&
							src[c+2][r+2] == 'Y' && src[c+3][r+3] == 'Y') {
						stat = 'y';
					}
					if(src[c][r] == 'R' && src[c+1][r+1] == 'R' &&
							src[c+2][r+2] == 'R' && src[c+3][r+3] == 'R') {
						stat = 'r';
					}
				}
			}
		}
		
		if(stat == 'c') {
			for(int r = 3; r < 6; r++) {
				for(int c = 0; c < 4; c++) {
					if(src[c][r] == 'Y' && src[c+1][r-1] == 'Y' &&
							src[c+2][r-2] == 'Y' && src[c+3][r-3] == 'Y') {
						stat = 'y';
					}
					if(src[c][r] == 'R' && src[c+1][r-1] == 'R' &&
							src[c+2][r-2] == 'R' && src[c+3][r-3] == 'R') {
						stat = 'r';
					}
				}
			}
		}
		
		if(stat == 'r') {
			grid(src);
			System.out.println("The red player won!");
		}
		else if(stat == 'y') {
			grid(src);
			System.out.println("The yellow player won!");
		}
		else if(stat == 'd') {
			grid(src);
			System.out.println("Game concluded as a draw.");
		}
		
		return stat;
	}
	
	public static char[][] setDisk(char[][] src, char player) {
		char[][] updateGrid = src;
		int column = -1;
		boolean valid = false;
		
		if(player == 'R') {
			System.out.print("Drop a red disk at column (0-6): ");
		}
		else if(player == 'Y') {
			System.out.print("Drop a yellow disk at column (0-6): ");
		}
		
		while(!valid) {
			column = getInt();
			if(column >= 0 && column <= 6) {
				for(int i = 0; i < 6; i++) {
					if(updateGrid[column][5 - i] == ' ' && !valid) {
						updateGrid[column][5 - i] = player;
						valid = true;
					}
				}
				if(!valid) {
					System.out.print("The column is full, please enter a column between 0-6: ");
				}
			}
			else {
				System.out.print("Please enter a column between 0-6: ");
			}
		}
		
		return updateGrid;
	}
	
	
	
}
