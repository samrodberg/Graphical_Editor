import java.awt.Color;
import java.awt.Point;

/**
 * Makes a rectangle
 * @author Sam Rodberg
 * @version 2/7/16
 */
public class MakeRect extends Command {
	private double pressedX;
	private double pressedY;
	private double height;
	private double width;
	private Color color;
	private Rect toBeAdded;
	private Point startPoint;
	private Point endPoint;
	
	/**
	 * When pressed adds the rectangle to the shapes list 
	 * @param p
	 * @param dwg
	 */
	public void executePress(Point p, Drawing dwg){
		this.height = 0;
		this.width = 0;
		this.pressedX = p.x;
		this.pressedY = p.y;
		this.startPoint = p;
		this.color = dwg.getColor();
		toBeAdded = new Rect(color, startPoint);
		dwg.addShape(toBeAdded);
	}
	
	/**
	 * Drags outs the boundaries of the rectangle and actually draws its
	 * final rectangle when released
	 * @param p
	 * @param dwg
	 */
	public void executeDrag(Point p, Drawing dwg){
		this.endPoint = p;
		height = Math.abs(endPoint.x - startPoint.x);
		width = Math.abs(endPoint.y - startPoint.y);
		double minX = Math.min(endPoint.x,startPoint.x);
		double minY = Math.min(endPoint.y,startPoint.y);
		Point setPoint = new Point((int) minX, (int) minY);
		toBeAdded = new Rect(color, setPoint);
		toBeAdded.changeDimensions(height, width);
		dwg.replaceFrontShape(toBeAdded);
		
	}
}