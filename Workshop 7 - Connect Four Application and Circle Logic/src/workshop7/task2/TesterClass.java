/************************************
 * Workshop #7
 * Course: JAC444 - Semester 4
 * Last Name: Truong
 * First Name: Hung
 * ID: 147779193
 * Section: NEE
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signature
 * Date: 3/20/2021
 */

package workshop7.task2;

public class TesterClass {
	public static void main(String[] arg) {
		Circle2D c1 = new Circle2D(2, 2, 5.5);
		
		System.out.println("The origin of c1 is x = " + c1.getX() + ", y = " + c1.getY() +
				" with the radius of " + c1.getRadius());
		System.out.println("The Area of c1 is: " + c1.getArea() + " and the Parameter is: " +c1.getParameter());
		System.out.println("The point, x = 3, y = 3, is inside c1: " + c1.contains(3,3));
		System.out.println("The origin of the circle is x = 4, y = 5, and "
				+ "radius of 10.5 is inside c1: " + c1.contains(new Circle2D(4, 5, 10.5)));
		System.out.println("The origin of the circle is x = 3, y = 5, and "
				+ "radius of 2.3 overlaps c1: " + c1.overlaps(new Circle2D(3, 5, 2.3)));
	}
}
