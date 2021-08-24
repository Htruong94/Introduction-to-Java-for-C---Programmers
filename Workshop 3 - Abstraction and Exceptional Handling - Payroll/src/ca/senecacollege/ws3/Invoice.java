/************************************
 * Workshop #3
 * Course: JAC444 - Semester 4
 * Last Name: Truong
 * First Name: Hung
 * ID: 147779193
 * Section: NEE
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signature
 * Date: 2/13/2021
 */

package ca.senecacollege.ws3;

class Invoice implements Payable{
	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;
	
	public String toString() {
		return partNumber + " : " + partDescription;
	}
	
	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return ((double) quantity * pricePerItem);
	}
}
