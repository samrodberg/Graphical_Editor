import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Basis for rectangle creation
 * @author Sam Rodberg
 * @version 1/26/16
 */

//Rewritten rectangle class reflects more of a mashup between 
//professor Barr's thinking and my own approach

public class Rect extends Shape {
	private double height;
	private double width;
	private double xCord;
	private double yCord;
	private Color color;
	

	public Rect(Color c, Point p) {
		super(c);
		this.height = 0;
		this.width = 0;
		this.xCord = p.x;
		this.yCord = p.y;
	}

	@Override
	public void drawShape(Graphics page) {
		page.fillRect((int) xCord,(int) yCord,(int) width,(int) height);
		
	}

	@Override
	//Boundary containment for points is critical
	public boolean containsPoint(Point p) {
		if(p.x >= xCord && p.x <= xCord + width 
				&& p.y >= yCord && p.y <= yCord + height){
			return true;
		}
		return false;
	}

	@Override
	public void move(int deltaX, int deltaY) {
		xCord += deltaX;
		yCord += deltaY;
		
	}

	@Override
	// Geometrically the center of a rectangle is
	// half the height and half the width
	public Point getCenter() {
		int xCenter = (int) ((xCord + width) / 2);
		int yCenter = (int) ((yCord + height) / 2);
		Point centerPoint = new Point(xCenter, yCenter);
		return centerPoint;
	}
	
	/**
	 * Method for changing the dimensions of the rectangle as needed
	 * @param newHeight
	 * @param newWidth
	 */
	public void changeDimensions(double newHeight, double newWidth){
		this.height = newHeight;
		this.width = newWidth;
	}
	
	/**
	 * Gets the height of the rectangle
	 * @return height
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Sets the height of the rectangle
	 * @param height
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * Gets the width of the rectangle
	 * @return width
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * Sets the width of the rectangle
	 * @param width
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	
	/**
	 * Gets the x-coordinate
	 * @return xCord
	 */
	public double getxCord() {
		return xCord;
	}
	
	/**
	 * Sets the x-coordinate
	 * @param xCord
	 */
	public void setxCord(double xCord) {
		this.xCord = xCord;
	}
	
	/**
	 * Gets the y-coordinate
	 * @return yCord
	 */
	public double getyCord() {
		return yCord;
	}
	
	/**
	 * Sets the y-coordinate
	 * @param yCord
	 */
	public void setyCord(double yCord) {
		this.yCord = yCord;
	}
	
	/**
	 * Get the rectangles color
	 * @return color
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Sets the color of the rectangle
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
}