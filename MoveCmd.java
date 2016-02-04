import java.awt.Point;

/**
 * Will be the basis of the move button functionality 
 * @author Sam Rodberg
 * @version 1/25/16
 */
public class MoveCmd extends Command {
	private Point startPoint;
	private Point endPoint;
	private Shape toBeMoved;
	
	//Try executePress to prevent null pointers
	public void executePress(Point p, Drawing dwg){
			toBeMoved = dwg.getFrontmostContainer(p);
			if(toBeMoved != null){
				startPoint = p;
			}
		
	}
	
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
