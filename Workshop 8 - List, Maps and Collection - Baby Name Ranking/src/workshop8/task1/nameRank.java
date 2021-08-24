/************************************
 * Workshop #8
 * Course: JAC444 - Semester 4
 * Last Name: Truong
 * First Name: Hung
 * ID: 147779193
 * Section: NEE
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signature
 * Date: 3/27/2021
 */

package workshop8.task1;


public class nameRank {
	private String name;
	private int rank;
	private int quantity;
	private char gender;
	
	public nameRank() {
		setName("");
		setRank(0);
		setGender(' ');
		setQuantity(0);
	}
	
	public nameRank(String src_Name, int src_Rank, int src_Quantity, char src_Gender) {
		setName(src_Name);
		setRank(src_Rank);
		setQuantity(src_Quantity);
		setGender(src_Gender);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
