/************************************
 * Workshop #3
 * Course: JAC444 - Semester 4
 * Last Name: Truong
 * First Name: Hung
 * ID: 147779193
 * Section: NEE
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signature
 * Date: 2/14/2021
 */

package ca.senecacollege.ws3;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PayRollTest {
	public static void main(String[] args) {
		boolean exit = false;
		int options = 0;
		
		String t_fName = "";
		String t_lName = "";
		String t_SSN = "";
		double t_gross = 0;
		double t_rate = 0;
		double t_wsal = 0;
		double t_wage = 0;
		double t_hours = 0;
		double t_bsalary = 0;
		
		CommissionEmployee commissionEmployee = new CommissionEmployee("One", "Commissioned", "111-11-1111", 100.00, 0.1);
		SalariedEmployee salariedEmployee = new SalariedEmployee("Two", "Salaried", "222-22-2222", 200.00);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Three", "Hourly", "333-33-3333", 300.00, 30);
		BasePlusCommissionEmployee bpcEmployee = new BasePlusCommissionEmployee("Four", "BPC", "444-44-4444", 400.00, 0.4, 4000);
		
		Employee[] empArray = new Employee[4];
		empArray[0] = commissionEmployee;
		empArray[1] = salariedEmployee;
		empArray[2] = hourlyEmployee;
		empArray[3] = bpcEmployee;
		
		System.out.printf("Employees Processed Individually:%n%n");
		
		System.out.printf(commissionEmployee.toString() + "%n");
		System.out.printf("earned: $%.2f%n%n", commissionEmployee.getPaymentAmount());
		System.out.printf("----------------------------------------------------%n");
		
		System.out.printf(salariedEmployee.toString() + "%n");
		System.out.printf("earned: $%.2f%n%n", salariedEmployee.getPaymentAmount());
		System.out.printf("----------------------------------------------------%n");
		
		System.out.printf(hourlyEmployee.toString() + "%n");
		System.out.printf("earned: $%.2f%n%n", hourlyEmployee.getPaymentAmount());
		System.out.printf("----------------------------------------------------%n");
		
		System.out.printf(bpcEmployee.toString() + "%n");
		System.out.printf("earned: $%.2f%n%n", bpcEmployee.getPaymentAmount());
		System.out.printf("----------------------------------------------------%n");
		System.out.printf("----------------------------------------------------%n");
		
		System.out.printf("Employees Processed in Array: %n%n");
		
		for(int i = 0; i < empArray.length; i++) {
			System.out.printf(empArray[i].toString() + "%n%n");
			System.out.printf("earned: $%.2f%n%n", empArray[i].getPaymentAmount());
			
			System.out.printf("----------------------------------------------------%n");
		}
		
		System.out.printf("----------------------------------------------------%n");
		
		System.out.printf("Employees classified to their specific class: %n%n");
		
		for(int i = 0; i < empArray.length; i++) {
			System.out.printf("Employee: " + empArray[i].getFirstName() + " " + empArray[i].getLastName());
			System.out.printf(" is of class ");
			if(empArray[i] instanceof BasePlusCommissionEmployee) {
				System.out.printf("BasePlusCommisssionEmployee%n%n");
			}
			else if(empArray[i] instanceof CommissionEmployee) {
				System.out.printf("CommissionEmployee%n%n");
			}
			else if(empArray[i] instanceof HourlyEmployee) {
				System.out.printf("HourlyEmployee%n%n");
			}
			else if(empArray[i] instanceof SalariedEmployee) {
				System.out.printf("SalariedEmployee%n%n");
			}
		}
		
		System.out.println("Workshop 3 Exception Handling Test");
		
		while(!exit) {
			try {
				menu();
				options = getInt();
				
				if(options < 0 || options > 4) {
					throw new Exception("Pick an option between 0 to 4.");
				}
				
				if(options == 0) {
					System.out.println("Creating Commission Employee");
					System.out.println("Enter First Name");
					t_fName = getString();
					System.out.println("Enter Last Name");
					t_lName = getString();
					System.out.println("Enter SSN");
					t_SSN = getString();
					System.out.println("Enter Gross");
					t_gross = getDouble();
					System.out.println("Enter Commission Rate");
					t_rate = getDouble();
					
					CommissionEmployee testEmployeeCE = new CommissionEmployee(t_fName, t_lName, t_SSN, t_gross, t_rate);
					System.out.printf(testEmployeeCE.toString() + "%n%n");
				}
				else if (options == 1) {
					System.out.println("Creating Salaried Employee");
					System.out.println("Enter First Name");
					t_fName = getString();
					System.out.println("Enter Last Name");
					t_lName = getString();
					System.out.println("Enter SSN");
					t_SSN = getString();
					System.out.println("Enter Salary");
					t_wsal = getDouble();
					
					SalariedEmployee testEmployeeSE = new SalariedEmployee(t_fName, t_lName, t_SSN, t_wsal);
					System.out.printf(testEmployeeSE.toString() + "%n%n");
				}
				else if (options == 2) {
					System.out.println("Creating Hourly Employee");
					System.out.println("Enter First Name");
					t_fName = getString();
					System.out.println("Enter Last Name");
					t_lName = getString();
					System.out.println("Enter SSN");
					t_SSN = getString();
					System.out.println("Enter Wage");
					t_wage = getDouble();
					System.out.println("Enter Hours");
					t_hours = getDouble();
					
					HourlyEmployee testEmployeeH = new HourlyEmployee(t_fName, t_lName, t_SSN, t_wage, t_hours);
					System.out.printf(testEmployeeH.toString() + "%n%n");
				}
				else if (options == 3) {
					System.out.println("Creating Base Plus Commission Employee");
					System.out.println("Enter First Name");
					t_fName = getString();
					System.out.println("Enter Last Name");
					t_lName = getString();
					System.out.println("Enter SSN");
					t_SSN = getString();
					System.out.println("Enter Gross");
					t_gross = getDouble();
					System.out.println("Enter Commission Rate");
					t_rate = getDouble();
					System.out.println("Enter Base Salary");
					t_bsalary = getDouble();
					
					BasePlusCommissionEmployee testEmployeeBPC = new BasePlusCommissionEmployee(t_fName, t_lName, t_SSN, t_gross, t_rate, t_bsalary);
					System.out.printf(testEmployeeBPC.toString() + "%n%n");
				}
				else {
					System.out.println("Workshop 3 Exception Handling Test Exit");
					exit = true;
				}
			}
			catch(Exception err) {
				System.out.println(err);
			}
		}
	}
	
	public static void menu() {
		System.out.println("Employee Creation Test");
		System.out.println("-------------------");
		System.out.println("0: Commission Employee");
		System.out.println("1: Hourly Employee");
		System.out.println("2: Salaried Employee"); 
		System.out.println("3: Base Plus Commission Employee"); 
		System.out.println("4: Exit");
	}
	
	public static int getInt() {
		Scanner scan = new Scanner(System.in);
		int input = 0;
		try {
			input = scan.nextInt();
		}
		catch(InputMismatchException ime) {
			System.out.println("Input was not a Integer.");
		}
		return input;
	}
	
	public static double getDouble() {
		Scanner scan = new Scanner(System.in);
		double input = 0;
		try {
			input = scan.nextDouble();
		}
		catch(InputMismatchException ime) {
			System.out.println("Input was not a Double.");
		}
		return input;
	}
	
	public static String getString() {
		Scanner scan = new Scanner(System.in);
		String string = scan.nextLine();
		
		return string;
	}
}
