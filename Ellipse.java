import java.awt.*;

/**
 * Ellipse.java
 * Class for an ellipse.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Thomas H. Cormen 
 * @see Shape
 */
public class Ellipse extends Shape {
	
	//Similar instance variables to built in Ellipse2D.Double
	//Need then double types of height, width, x, and y
	private double height;
	private double width;
	private double xCord;
	private double yCord;
	private Color color;
	
	//Experimenting with bounding block free constructor latter set through dimensions
	//when MakeEllipse button is triggered
	/**
	 * Constructor for creating an ellipse based on the current point
	 * and drawing color
	 * @param c
	 * @param p
	 */
	public Ellipse(Color c, Point p) {
		super(c);
		this.xCord = p.x;
		this.yCord = p.y;
	}
	
	
	
  // Helper method that returns whether Point p is in an Ellipse with the given
  // top left corner and size.
  private static boolean pointInEllipse(Point p, int left, int top, int width,
      int height) {
    double a = width / 2.0; // half of the width
    double b = height / 2.0; // half of the height
    double centerx = left + a; // x-coord of the center
    double centery = top + b; // y-coord of the center
    double x = p.x - centerx; // horizontal distance between p and center
    double y = p.y - centery; // vertical distance between p and center

    // Now we just apply the standard geometry formula.
    // (See CRC, 29th edition, p. 178.)
    return Math.pow(x / a, 2) + Math.pow(y / b, 2) <= 1;
  }

  	@Override
  	/** Draws the ellipse on the graphics page
  	 * @param page
  	 */
  	public void drawShape(Graphics page) {
  		page.setColor(color);
  		page.fillOval((int) xCord, (int) yCord, (int) width, (int) height);
	
  	}	

	@Override
	/**
	 * Take a point and see if the ellipse contains that point
	 * @param p
	 */
	public boolean containsPoint(Point p) {
		return pointInEllipse(p, (int) xCord, (int) yCord, (int) width, (int) height);
	}
	
	
	@Override
	/**
	 * The distance you want to move the ellipse
	 * @param deltaX
	 * @param deltaY
	 */
	public void move(int deltaX, int deltaY) {
		xCord += deltaX;
		yCord += deltaY;
	
	}
	
	//Account for bounding box
	@Override
	/**
	 * Returns the center point of the ellipse
	 */
	public Point getCenter() {
		double centerX = (xCord + width) / 2;
		double centerY = (yCord + height) /2;
		Point centerPoint = new Point((int) centerX, (int) centerY);
		return centerPoint;
	}
	
	/**
	 * Extra public method for changing the dimensions of ellipse if need be
	 * @param newHeight
	 * @param newWidth
	 */
	public void changeDimensions(double newHeight, double newWidth){
		height = newHeight;
		width = newWidth;
	}
}