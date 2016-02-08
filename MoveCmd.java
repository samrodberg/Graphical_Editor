import java.awt.Point;

/**
 * The basis of the move button functionality 
 * @author Sam Rodberg
 * @version 1/25/16
 */
public class MoveCmd extends Command {
	private Point startPoint;
	private Point endPoint;
	private Shape toBeMoved;
	
	//Try executePress to prevent null pointers
	/**
	 * Records a start point as the basis for moving
	 * @param p
	 * @param dwg
	 */
	public void executePress(Point p, Drawing dwg){
			toBeMoved = dwg.getFrontmostContainer(p);
			if(toBeMoved != null){
				startPoint = p;
			}
		
	}
	
	/**
	 * Keeps updating the start and end points to move
	 * to the desired spot
	 * @param p
	 * @param dwg
	 */
	public void executeDrag(Point p, Drawing dwg){
		endPoint = p;
		int moveDistanceX = endPoint.x - startPoint.x;
		int moveDistanceY = endPoint.y - startPoint.y;
		if(toBeMoved != null){
			toBeMoved.move(moveDistanceX, moveDistanceY);
			startPoint = p;
		}
	}

}
