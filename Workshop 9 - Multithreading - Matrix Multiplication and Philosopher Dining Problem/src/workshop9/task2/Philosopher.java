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

public class Philosopher implements Runnable{
	private Object left;
	private Object right;
	private static boolean finishEat;
	
	public Philosopher(Object lChop, Object rChop) {
		left = lChop;
		right = rChop;
		setFinishEat(false);
	}
	
	public void action(String src) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + src);
		Thread.sleep((int)(Math.random()*100)); 
		//pausing with random time between each action to randomize action
	}


	public static boolean isFinishEat() {
		return finishEat;
	}


	public static void setFinishEat(boolean finishEat) {
		Philosopher.finishEat = finishEat;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!finishEat) {
			try {
				action("Getting ready to pick up chopsticks");
				synchronized(left) {
					synchronized(right) { //picks up both chopsticks at once
						action("Picked up chopsticks");
						action("Eating in progress");
						finishEat = true;
					}
					action("Finished eating");
					action("Put down chopsticks");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
		}
	}
}
