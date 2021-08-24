/************************************
 * Workshop #2
 * Course: JAC444 - Semester 4
 * Last Name: Truong
 * First Name: Hung
 * ID: 147779193
 * Section: NEE
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signature
 * Date: 2/6/2021
 */

import java.util.Scanner;

public class Task2App {
	
	public static void main(String[] args) {
		Account[] accArray = new Account[100];
		int options = 0;
		int numAccounts = 0;
		int aNum = 0;
		double tempIniBal = 0;
		double tempIniInterest = 0;
		double tempIniTFee = 0;
		double tempAmount = 0;
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
	
		do {
			menu();
			System.out.print("Enter your input: >");
			options = scan.nextInt();
			if(options == 0) {
				System.out.println("Creating new Checkings Account");
				System.out.print("Enter the initial balance and transaction fee: ");
				tempIniBal = scan.nextDouble();
				tempIniTFee = scan.nextDouble();
				accArray[numAccounts] = new CheckingAccount(tempIniBal, tempIniTFee);
				numAccounts++;
			}
			else if(options == 1) {
				System.out.println("Creating new Savings Account");
				System.out.print("Enter the initial balance and interest: ");
				tempIniBal = scan.nextDouble();
				tempIniInterest = scan.nextDouble();
				accArray[numAccounts] = new SavingsAccount(tempIniBal, tempIniInterest);
				numAccounts++;
			}
			else if(options == 2) {
				System.out.println("Withdraw");
				System.out.print("Input account number: ");
				aNum = scan.nextInt();
				if(accArray[aNum] instanceof CheckingAccount) {
					System.out.println("This is a checkings account.");
					System.out.print("Input the amount you want to withdraw: ");
					tempAmount = scan.nextDouble();
					((CheckingAccount)accArray[aNum]).debit(tempAmount);
					displayAccount(accArray[aNum]);
				}
				else if(accArray[aNum] instanceof SavingsAccount) {
					System.out.println("This is a savings account.");
					System.out.print("Input the amount you want to withdraw: ");
					tempAmount = scan.nextDouble();
					((SavingsAccount)accArray[aNum]).debit(tempAmount);
					System.out.println("Interest creditted to the account balance: " + ((SavingsAccount)accArray[aNum]).CalculateInterest());
					tempAmount = ((SavingsAccount)accArray[aNum]).CalculateInterest();
					((SavingsAccount)accArray[aNum]).credit(tempAmount);;
					displayAccount(accArray[aNum]);
				}
				else {
					System.out.println("There is no accounts under this account number.");
				}
			}
			else if(options == 3) {
				System.out.println("Deposit");
				System.out.print("Input account number: ");
				aNum = scan.nextInt();
				if(accArray[aNum] instanceof CheckingAccount) {
					System.out.println("This is a checkings account.");
					System.out.print("Input the amount you want to Deposit: ");
					tempAmount = scan.nextDouble();
					((CheckingAccount)accArray[aNum]).credit(tempAmount);
					displayAccount(accArray[aNum]);
				}
				else if(accArray[aNum] instanceof SavingsAccount) {
					System.out.println("This is a savings account.");
					System.out.print("Input the amount you want to Deposit: ");
					tempAmount = scan.nextDouble();
					((SavingsAccount)accArray[aNum]).credit(tempAmount);
					System.out.println("Interest creditted to the account balance: " + ((SavingsAccount)accArray[aNum]).CalculateInterest());
				tempAmount = ((SavingsAccount)accArray[aNum]).CalculateInterest();
					((SavingsAccount)accArray[aNum]).credit(tempAmount);
					displayAccount(accArray[aNum]);
				}
				else {
					System.out.println("There is no accounts under this account number.");
				}
			}
			else if(options == 4) {
				exit = true;
				System.out.println("Task 2 App end");
			}
		}while(!exit);
	
	}
	public static void menu() {
		System.out.println("Task 2 Menu Options");
		System.out.println("-------------------");
		System.out.println("0: Create Checking Account");
		System.out.println("1: Create Savings Account");
		System.out.println("2: Withdraw from Account"); //Debit
		System.out.println("3: Deposit from Account"); //Credit
		System.out.println("4: Exit");
	}
	public static void displayAccount(Account src) {
		System.out.println("The current balance of this account is: $" + src.getaBalance());
	};
}
