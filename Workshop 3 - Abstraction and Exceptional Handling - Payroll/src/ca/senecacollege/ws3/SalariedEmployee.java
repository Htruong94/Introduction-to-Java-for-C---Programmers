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

public class SalariedEmployee extends Employee{
	private double weeklySalary;
	
	public SalariedEmployee(String fn, String ln, String ssn, double wSalary) {
		super(fn, ln, ssn);
		try {
			if(wSalary > 0.0) {
				setWeeklySalary(wSalary);
			}
			else {
				throw new Exception("Hourly wage of employee must be greater than 0.");
			}
		}
		catch(Exception err) {
			setWeeklySalary(0);
			System.out.println(err);
		}
	}
	
	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return getWeeklySalary();
	}
	
	@Override
	public String toString() {
		return String.format(super.toString() + "Weekly Salary: %.2f", getWeeklySalary());
	}
}
