/************************************
 * Workshop #9
 * Course: JAC444 - Semester 4
 * Last Name: Truong
 * First Name: Hung
 * ID: 147779193
 * Section: NEE
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signature
 * Date: 04/03/2021
 */

package workshop9.task2;

public class TestClass {
	public static void main(String[] arg) {
		final int numMembers = 5;
		final Philosopher[] members = new Philosopher[numMembers];
		Object[] chopsticks = new Object[numMembers];
		
		System.out.println("Workshop 9 Task 2");
		System.out.println("------------------------");
		System.out.println("Demonstrating Solution 2");
		System.out.println("------------------------\n");
		
		for(int i = 0; i < chopsticks.length; i++) {
			chopsticks[i] = new Object();
		}
		
		//setting all but last member chopstick positions
		for(int i = 0; i < members.length - 1; i++) {
			members[i] = new Philosopher(chopsticks[i], chopsticks[i+1]);
		}
		
		//setting last member chopstick positions
		members[members.length-1] = new Philosopher(chopsticks[chopsticks.length-1], chopsticks[0]);
		
		for(int i = 0; i < members.length; i++) {
			Thread eat = new Thread(members[i], "Philosopher " + (i+1) + ": ");
			eat.start();
		}
	}
}
