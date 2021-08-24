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

public class Student {
	private String username;
	private String password;
	private String fullname;
	private String instructorEmail;
	
	public Student(String un, String pw, String fn, String iE) {
		setUsername(un);
		setPassword(pw);
		setFullname(fn);
		setInstructorEmail(iE);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getInstructorEmail() {
		return instructorEmail;
	}

	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}
}
