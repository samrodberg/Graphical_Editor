import java.awt.Point;

/**
 * Will be the basis of the back button functionality
 * @author Sam Rodberg
 * @version 1/25/16
 */
public class BackCmd extends Command {
	
	/**
	 * On click being executed move the shape to the back
	 * of shapes array
	 * @param p
	 * @param dwg
	 */
	public void executeClick(Point p, Drawing dwg){
		dwg.moveShapeToBack(p);
	}

}
