/************************************
 * Workshop #1
 * Course: JAC444 - Semester 4
 * Last Name: Truong
 * First Name: Hung
 * ID: 147779193
 * Section: NEE
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signature
 * Date: 1/29/2021
 */


public class craps {
	public static void main(String[] args) {
		
		int dice1 = 0;
		int dice2 = 0;
		int sumDice = 0;
		int pointSet = 0;
		boolean cont = true;
		
		while(cont) { //loops until win or lose
			dice1 = rollDice();
			dice2 = rollDice();
		
			sumDice = dice1+dice2;
		
			System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + sumDice);
		
			if(sumDice == 2 || sumDice == 3 || sumDice == 12) {
				System.out.println("Craps, Better Luck Next Time, You Lose.");
				cont = false;
			}
			else if(sumDice == 7 || sumDice == 11 || sumDice == pointSet) {
				System.out.println("Congratulations, You win!");
				cont = false;
			}
			else {
				if(pointSet == 0) {
					pointSet = sumDice;
					System.out.println("Point is (established) set to " + pointSet);
				}
			}
		}
	}
	
	public static int rollDice() {
		//Math.random yields random number including 0 to excluding 1.
		return (int)(Math.random()*6+1); //random*range+minimum = random*(6[max]-1[min]+1)+1[min]
	}
}
