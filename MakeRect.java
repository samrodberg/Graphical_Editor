import java.awt.Color;
import java.awt.Point;

/**
 * Makes a rectangle
 * @author Sam Rodberg
 * @version 1/26/15
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