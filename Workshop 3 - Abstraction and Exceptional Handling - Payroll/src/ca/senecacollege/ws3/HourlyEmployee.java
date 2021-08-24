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

public class HourlyEmployee extends Employee{
	private double wage;
	private double hours;
	
	public HourlyEmployee(String fn, String ln, String ssn, double wg, double hrs) {
		super(fn, ln, ssn);
		try {
			if(wg > 0.0) {
				setWage(wg);
			}
			else {
				throw new Exception("Wage must be greater than 0.");
			}
		}
		catch(Exception err) {
			setWage(0);
			System.out.println(err);
		}
		
		try {
			if(hrs >= 0.0 & hrs <= 168.0) {
				setHours(hrs);
			}
			else {
				throw new Exception("Number of hours worked by worker should be between 0.0 to 168.0.");
			}
		}
		catch(Exception err) {
			setHours(0);
			System.out.println(err);
		}
	}
	
	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return getWage() * getHours();
	}
	
	@Override
	public String toString() {
		return String.format(super.toString() + "Salary {Wage: %.2f Hours: %.0f }", getWage(), getHours());
	}
}
