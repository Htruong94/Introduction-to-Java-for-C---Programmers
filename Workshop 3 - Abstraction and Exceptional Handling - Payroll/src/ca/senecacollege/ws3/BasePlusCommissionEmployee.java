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

public class BasePlusCommissionEmployee extends CommissionEmployee{
	private double baseSalary;
	public BasePlusCommissionEmployee(String fn, String ln, String ssn, double gross, double cRate, double bSalary) {
		super(fn, ln, ssn, gross, cRate);
		try {
			if(bSalary > 0.0) {
				setBaseSalary(bSalary);
			}
			else {
				throw new Exception("Base Salary of employee must be greater than 0.");
			}
		}
		catch(Exception err) {
			setBaseSalary(0);
			System.out.println(err);
		}
	}
	
	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return ((super.getPaymentAmount() * 0.1) + getBaseSalary());
	}
	
	@Override
	public String toString() {
		return String.format(super.toString() + "; Base Salary: %5.2f", getBaseSalary());
	}
	
}
