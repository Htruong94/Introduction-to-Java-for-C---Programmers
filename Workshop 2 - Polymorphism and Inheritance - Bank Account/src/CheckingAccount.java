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

public class CheckingAccount extends Account{
	private double feeTransaction;
	
	public CheckingAccount(double iniBalance, double feeAmount) {
		super(iniBalance);
		feeTransaction = feeAmount;
	}
	
	public void credit(double amount) {
		super.credit(amount - feeTransaction);
	}
	
	public void debit(double amount) {
		super.debit(amount + feeTransaction);
	}
}
