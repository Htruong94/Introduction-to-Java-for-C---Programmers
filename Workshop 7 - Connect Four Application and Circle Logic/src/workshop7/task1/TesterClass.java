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

public class TesterClass {
	public static void main(String[] arg) {
		char[][] c4 = {{' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' '}, 
				{' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' '}};
		
		char stat = 'c';
		
		while(stat == 'c') {
			ConnectFour.grid(c4);
			c4 = ConnectFour.setDisk(c4, 'Y');
			stat = ConnectFour.status(c4);
			if(stat == 'c') {
				ConnectFour.grid(c4);
				ConnectFour.setDisk(c4, 'R');
				stat = ConnectFour.status(c4);
			}
		}
	}
}
