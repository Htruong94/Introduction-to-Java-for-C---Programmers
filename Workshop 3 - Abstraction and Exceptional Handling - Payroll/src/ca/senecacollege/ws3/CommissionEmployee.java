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

public class CommissionEmployee extends Employee {
	private double grossSales;
	private double commissionRate;
	
	public CommissionEmployee(String fn, String ln, String ssn, double gross, double cRate) {
		super(fn, ln, ssn);
		try {
			if(gross > 0) {
				setGrossSales(gross);
			}
			else {
				throw new Exception("Gross Sales must be greater than or equal to 0.");
			}
		}
		catch(Exception err) {
			setGrossSales(0);
			System.out.println(err);
		}
		
		try {
			if(cRate >= 0 & cRate <= 1) {
				setCommissionRate(cRate);
			}
			else {
				throw new Exception("Commission Rate of Employee should be between 0.0 to 1.0.");
			}
		}
		catch(Exception err) {
			setCommissionRate(0);
			System.out.println(err);
		}
	}
	
	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return getGrossSales() * getCommissionRate();
	}
	
	@Override
	public String toString() {
		return String.format(super.toString() + "Commission {Gross Sales: %.2f, Commission Rate: %.2f }", getGrossSales(), getCommissionRate());
	}
}
