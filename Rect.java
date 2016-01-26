import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Basis for rectangle creation
 * @author Sam Rodberg
 * @version 1/26/16
 */
public class Rect extends Shape {
	private int height;
	private int width;
	private int xCord;
	private int yCord;
	

	public Rect(int inHeight, int inWidth, int inX, int inY, Color c) {
		super(c);
		this.height = inHeight;
		this.width = inWidth;
		this.xCord = inX;
		this.yCord = inY;
	}

	@Override
	public void drawShape(Graphics page) {
		page.fillRect(xCord, yCord, width, height);
		
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
		int xCenter = (xCord + width) / 2;
		int yCenter = (yCord + height) / 2;
		Point centerPoint = new Point(xCenter, yCenter);
		return centerPoint;
	}
	
}