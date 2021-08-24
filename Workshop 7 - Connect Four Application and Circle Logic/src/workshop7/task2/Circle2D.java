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

public class Circle2D {
	private double x;
	private double y;
	private double radius;
	
	public Circle2D() {
		setX(0);
		setY(0);
		setRadius(1);
	}
	
	public Circle2D(double src_x, double src_y, double src_rad) {
		setX(src_x);
		setY(src_y);
		setRadius(src_rad);
	}
	
	public double getArea() {
		return(Math.PI*radius*radius);
	}
	
	public double getParameter() {
		return(2*Math.PI*radius);
	}
	
	//checks if a point is within the circle using the formula sqrt(x^2 + y^2) = radius
	public boolean contains(double src_x, double src_y) {
		boolean inside = false;
		
		if(Math.sqrt(Math.pow(this.getX() - src_x, 2) + Math.pow(this.getY() - src_y, 2)) < this.getRadius()) {
			inside = true;
		}
		
		return inside;
	}
	
	
	//checks (x - srcx)^2 + (y - srcy)^2) <= (rad - srcrad)^2 which translates to sqrt of left side <= rad - srcrad
	//which checks if the inputted circle is within the circle object and is only valid if the condition is true
	public boolean contains(Circle2D circle) {
		boolean inside = false;
		
		if(Math.sqrt(Math.pow(this.getX() - circle.getX(), 2) + Math.pow(this.getY() - circle.getY(), 2))
				<= this.getRadius() - circle.getRadius()) {
			inside = true;
		}
		
		return inside;
	}
	
	//same as above but rad + srcrad to see if the circle overlaps instead of fully contains
	public boolean overlaps(Circle2D circle) {
		boolean overlap = false;

		if(Math.sqrt(Math.pow(this.getX() - circle.getX(), 2) + Math.pow(this.getY() - circle.getY(), 2)) 
				<= this.getRadius() + circle.getRadius() ) {
			overlap = true;
		}
		
		return overlap;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
}
