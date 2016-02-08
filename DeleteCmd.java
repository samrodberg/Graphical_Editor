import java.awt.Point;

/**
 * The basis of the functionality for the delete button
 * @author Sam Rodberg
 * @version 2/7/16
 */
public class DeleteCmd extends Command {
	
	/**
	 * When clicked the shape that is selected will be deleted
	 * from the drawing
	 * @param p
	 * @param dwg
	 */
	public void executeClick(Point p, Drawing dwg){
		Shape toBeDeleted = dwg.getFrontmostContainer(p);
		dwg.removeShape(toBeDeleted);
	}

}
