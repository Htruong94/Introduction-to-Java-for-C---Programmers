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

public class TestClass {
	public static void main(String[] arg) {
		
		System.out.println("Workshop 8 Tast 1");
		
		BabyNameRanking bnr = new BabyNameRanking();
		bnr.start();
		
		System.out.println("Press enter to start part 2.");
		
		bnr.pause();
		bnr.startp2();
		
		System.out.println("End of Workshop 8 Tast 1");
	}
}
