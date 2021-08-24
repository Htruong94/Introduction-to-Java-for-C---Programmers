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

abstract class Employee implements Payable {
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	
	public Employee(String fn, String ln, String ssn) {
		setFirstName(fn);
		setLastName(ln);
		setSocialSecurityNumber(ssn);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String toString() {
		return "Employee: " + getFirstName() + " " + getLastName() + "; SSN: " + getSocialSecurityNumber() + "; ";
	}
}
