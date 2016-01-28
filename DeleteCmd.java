import java.awt.Point;

/**
 * Will be the basis of the functionality for the delete button
 * @author Sam Rodberg
 * @version 1/25/16
 */
public class DeleteCmd extends Command {
	
	public void executeClick(Point p, Drawing dwg){
		Shape toBeDeleted = dwg.getFrontmostContainer(p);
		dwg.removeShape(toBeDeleted);
	}

}
