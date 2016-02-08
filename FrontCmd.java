import java.awt.Point;

/**
 * The basis of the front button functionality
 * @author Sam Rodberg
 * @version 2/7/16
 */
public class FrontCmd extends Command {
	
	/**
	 * When clicked the shape is moved to the front of the drawing
	 * @param p
	 * @param dwg
	 */
	public void executeClick(Point p, Drawing dwg){
		dwg.moveShapeToFront(p);
	}

}
