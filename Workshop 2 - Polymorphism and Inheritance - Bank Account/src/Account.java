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

public class Account {
	private double aBalance;
	
	public Account(double iniBalance) {
		aBalance = validate(iniBalance);
	}
	
	public double validate(double amount) {
		if(amount > 0) {
			return amount;
		}
		else {
			System.err.println("Balance must be greater than or equal to 0.0");
			return 0;
		}
	}
	
	public void credit(double amount) {
		aBalance += validate(amount);
	}
	
	public void debit(double amount) {
		if(aBalance >= amount) {
			aBalance -= amount;
		}
		else {
			System.out.println("Debit amount exceeded account balance.");
		}
	}
	
	public double getaBalance() {
		return aBalance;
	}
}
