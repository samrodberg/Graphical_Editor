import java.awt.Color;
import java.awt.Point;

/**
 * Makes a ellipse on the drawing
 * @author Sam Rodberg
 * @version 2/7/16
 */
public class MakeEllipse extends Command {
	private double width;
	private double height;
	private double xCord;
	private double yCord;
	private Color color;
	
	// Height and weight changed after using changeDimensions method
	/**
	 * When pressed the ellipse is added to the drawing shape list
	 * @param p
	 * @param dwg
	 */
	public void executePress(Point p, Drawing dwg){
		this.xCord = p.x;
		this.yCord = p.y;
		this.height = 0;
		this.width = 0;
		color = dwg.getColor();
		Ellipse ellipseToBeAdded = new Ellipse(color, p);
		dwg.addShape(ellipseToBeAdded);
	}
	
	/**
	 * When dragged the ellipse is dragged out and then actually drawn
	 * @param p
	 * @param dwg
	 */
	public void executeDrag(Point p, Drawing dwg){
		//Setup a height and width since we hadn't done so before to be passed into
		//changeDimensions method
		//Follow same math procedure as MakeRect
		//Then update and replace our placeholder
		width = Math.abs(p.x - xCord);
		height = Math.abs(p.y - yCord);
		Point setPoint = new Point((int) Math.min(p.x, xCord), 
				(int) Math.min(p.y, yCord));
		Ellipse ellipseToBeAdded = new Ellipse(color, setPoint);
		ellipseToBeAdded.changeDimensions((int) width, (int) height);
		dwg.replaceFrontShape(ellipseToBeAdded);
	}
	
	

}
