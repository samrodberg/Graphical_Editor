import java.awt.*;

/**
 * Segment.java
 * Class for a line segment.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Thomas H. Cormen
 * @see Shape
 */

public class Segment extends Shape {


	// Instance variables similar to that of java.awt.geom.Line2D.double
	private double x1;
	private double x2;
	private double y1;
	private double y2;
	private static final double TOLERANCE = 3.0;
	private Color color;

	public Segment(Color c, Point startPoint, Point endPoint) {
		super(c);
		this.x1 = startPoint.x;
		this.x2 = endPoint.x;
		this.y1 = startPoint.y;
		this.y2 = endPoint.y;
	}

	// Helper method that returns true if Point p is within a tolerance of a
	// given bounding box. Here, the bounding box is given by the coordinates of
	// its left, top, right, and bottom.
	private static boolean almostContainsPoint(Point p, int left, int top,
			int right, int bottom, double tolerance) {
		return p.x >= left - tolerance && p.y >= top - tolerance
				&& p.x <= right + tolerance && p.y <= bottom + tolerance;
	}

	// Helper method that returns the distance from Point p to the line
	// containing a line segment whose endpoints are given.
	private static double distanceToPoint(Point p, int x1, int y1, int x2,
			int y2) {
		if (x1 == x2) // vertical segment?
			return (double) (Math.abs(p.x - x1)); // yes, use horizontal distance
		else if (y1 == y2) // horizontal segment?
			return (double) (Math.abs(p.y - y1)); // yes, use vertical distance
		else {
			// Here, we know that the segment is neither vertical nor
			// horizontal.
			// Compute m, the slope of the line containing the segment.
			double m = ((double) (y1 - y2)) / ((double) (x1 - x2));

			// Compute mperp, the slope of the line perpendicular to the
			// segment.
			double mperp = -1.0 / m;

			// Compute the (x, y) intersection of the line containing the
			// segment and the line that is perpendicular to the segment and that
			// contains Point p.
			double x = (((double) y1) - ((double) p.y) - (m * x1) + (mperp * p.x))
					/ (mperp - m);
			double y = m * (x - x1) + y1;

			// Return the distance between Point p and (x, y).
			return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
		}
	}

	@Override
	public void drawShape(Graphics page) {
		page.setColor(color);
		page.drawLine((int) x1,(int) y1,(int) x2,(int) y2);


	}

	@Override
	//Use almost contains point helper and distance to point helper
	//If the distance to the point is within the tolerance and almost contains
	//the point its true else false
	public boolean containsPoint(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move(int deltaX, int deltaY) {
		x1 += deltaX;
		x2 += deltaX;
		y1 += deltaY;
		y2 += deltaY;

	}

	@Override
	// According to purplemath.com the center point formula for a line is
	//[(x1 + x2)/2,(y1 + y2)/2]
	public Point getCenter() {
		double xCenter = (x1 + x2) / 2;
		double yCenter = (y1 + y2) / 2;
		Point centerPoint = new Point((int) xCenter, (int) yCenter);
		return centerPoint;
	}
}
