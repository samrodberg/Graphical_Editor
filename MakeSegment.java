import java.awt.Color;
import java.awt.Point;

/**
 * Makes a line segment
 * @author Sam Rodberg
 * @version 2/7/16
 */
public class MakeSegment extends Command{
	private double x1;
	private double x2;
	private double y1;
	private double y2;
	private Point startPoint;
	private Point endPoint;
	private Color color;
	
	/**
	 * When pressed creates a line segement and adds to the shapes list
	 * @param p
	 * @param dwg
	 */
	public void executePress(Point p, Drawing dwg){
		x1 = p.x;
		y1 = p.y;
		color = dwg.getColor();
		startPoint = p;
		Segment toBeAdded = new Segment(color, startPoint, p);
		dwg.addShape(toBeAdded);
	}
	
	/**
	 * Actually draws the line segment on the drawing
	 * @param p
	 * @param dwg
	 */
	public void executeDrag(Point p, Drawing dwg){
		x2 = p.x;
		y2 = p.x;
		endPoint = p;
		Segment toBeAdded = new Segment(color, startPoint, endPoint);
		dwg.replaceFrontShape(toBeAdded);
		
	}
	

}
