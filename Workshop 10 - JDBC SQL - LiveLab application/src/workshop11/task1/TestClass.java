/************************************
 * Workshop #11
 * Course: JAC444 - Semester 4
 * Last Name: Truong
 * First Name: Hung
 * ID: 147779193
 * Section: NEE
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signature
 * Date: 4/17/2021
 */

package workshop11.task1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestClass {
	public static void main(String[] arg) throws SQLException {
		LiveLab test = new LiveLab();
		
		Connection conn = test.connect();
		Statement stmt = conn.createStatement();
		
		Student abc = new Student("abc", "p1", "Kyle Wright", "a@senencacollege.ca");
		Student cde = new Student("cde", "p2", "Yao Mi", "c@senecacollege.ca");
		Student wbc = new Student("wbc", "p3", "Jack Jill", "a@senencacollege.ca");
		
		System.out.println("Workshop 11 Live Lab Test Demonstration");
		System.out.println("---------------------------------------");
		System.out.println("Initializing tables");
		
		test.dropTable();
		test.createTable();
		
		test.arAGSStudent(stmt, abc);
		test.arAGSStudent(stmt, cde);
		test.arAGSStudent(stmt, wbc);
		
		test.arExerciseAssigned(stmt, "a@senencacollege.ca", "e1", 10);
		test.arExerciseAssigned(stmt, "a@senencacollege.ca", "e2", 10);
		test.arExerciseAssigned(stmt, "c@senecacollege.ca", "e1", 4);
		test.arExerciseAssigned(stmt, "c@senecacollege.ca", "e4", 20);
		
		test.arAGSLog(stmt, "abc", "e1", 9, 1);
		test.arAGSLog(stmt, "wbc", "e2", 7, 1);
		
		test.showAGSStudent();
		test.showExerciseAssigned();
		test.showAGSLog();
		
		System.out.println("\nPress enter to continue");
		
		pause();
		
		System.out.println("Adding records to AGSLog");
		
		test.noSubmit();
		test.showAGSLog();
		
		System.out.println("---------------------------------------");
		System.out.println("Workshop 11 Demonstration End");
	}
	
	public static void pause() { //pauses application
		@SuppressWarnings("resource")
		Scanner o = new Scanner(System.in);
		@SuppressWarnings("unused")
		String temp = null;
		
		temp = o.nextLine();
	}
}
