import java.awt.Point;

/**
 * Will be the basis of the front button functionality
 * @author Sam Rodberg
 * @version 1/25/16
 */
public class FrontCmd extends Command {
	
	public void executeClick(Point p, Drawing dwg){
		dwg.moveShapeToFront(p);
	}

}
