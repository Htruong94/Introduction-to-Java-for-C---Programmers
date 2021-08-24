/************************************
 * Workshop #2
 * Course: JAC444 - Semester 4
 * Last Name: Truong
 * First Name: Hung
 * ID: 147779193
 * Section: NEE
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signature
 * Date: 2/5/2021
 */

import java.util.Scanner;

public class Task1App {
	public static void main(String[] args) {
		int option = 0;
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
		
		do {
			//creating objects of each class for testing their method
			Account accountTest = new Account(50);
			SavingsAccount savingsAccountTest = new SavingsAccount(75, 0.05);
			CheckingAccount checkingAccountTest = new CheckingAccount(100, 5);
			
			System.out.println("--------------------------------");
			System.out.println("Account balance: " + accountTest.getaBalance());
			System.out.println("Savings Account balance: " + savingsAccountTest.getaBalance() + " || Interest rate of 0.05");
			System.out.println("Checking Account balance: " + checkingAccountTest.getaBalance() + " || Transaction fees of 5");
			System.out.println("--------------------------------");
			System.out.println("Press 0 for Account testing, 1 for Savings testing, 2 for Checking testing");
			System.out.println("--------------------------------");
		
		
			option = scan.nextInt();
		
			if(option == 0) {
				System.out.println("Account Testing");
				System.out.println("--------------------------------");
				System.out.println("crediting 100.50");
				accountTest.credit(100.50);
				System.out.println("Current balance: " + accountTest.getaBalance());
				System.out.println("debiting 100.25");
				accountTest.debit(100.25);
				System.out.println("Current balance: " + accountTest.getaBalance());
				System.out.println("debiting 100.25 again");
				accountTest.debit(100.25);
				System.out.println("Current balance: " + accountTest.getaBalance());
			}
			else if(option == 1) {
				System.out.println("Savings Account Testing");
				System.out.println("--------------------------------");
				System.out.println("crediting 100.50");
				savingsAccountTest.credit(100.50);
				System.out.println("Current balance: " + savingsAccountTest.getaBalance());
				System.out.println("Current Interest: " + savingsAccountTest.CalculateInterest());
				System.out.println("debiting 100.25");
				savingsAccountTest.debit(100.25);
				System.out.println("Current balance: " + savingsAccountTest.getaBalance());
				System.out.println("Current Interest: " + savingsAccountTest.CalculateInterest());
				System.out.println("debiting 100.25 again");
				savingsAccountTest.debit(100.25);
				System.out.println("Current balance: " + savingsAccountTest.getaBalance());
				System.out.println("Current Interest: " + savingsAccountTest.CalculateInterest());
			}
			else if(option == 2) {
				System.out.println("Checkings Account Testing");
				System.out.println("--------------------------------");
				System.out.println("crediting 100.50");
				checkingAccountTest.credit(100.50);
				System.out.println("Current balance: " + checkingAccountTest.getaBalance());
				System.out.println("debiting 100.25");
				checkingAccountTest.debit(100.25);
				System.out.println("Current balance: " + checkingAccountTest.getaBalance());
				System.out.println("debiting 86.25");
				checkingAccountTest.debit(86.25);
				System.out.println("Current balance: " + checkingAccountTest.getaBalance());
			}
			else {
				exit = true;
			}
		} while(!exit);
	}
}
