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

public class SavingsAccount extends Account {
	private double interestRate;
	
	public SavingsAccount(double iniBalance, double iniInterestRate){
		super(iniBalance);
		interestRate = iniInterestRate;
	}
	
	public double CalculateInterest() {
		return interestRate*getaBalance();
	}
}
