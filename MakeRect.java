import java.awt.Point;

/**
 * Makes a rectangle
 * @author Sam Rodberg
 * @version 1/26/15
 */
public class MakeRect extends Command {
	private Point creationPoint;
	private int numberOfOperations;
	
	public MakeRect(){
		this.creationPoint = null;
		this.numberOfOperations = 0;
		
	}
	
	public void executePress(Point p, Drawing dwg){
		creationPoint = p;
		numberOfOperations = 0;
	}
	
	public void executeDrag(Point p, Drawing dwg){
		if(numberOfOperations == 0){
			dwg.addShape(new Rect(Math.min(creationPoint.x, p.x), 
					Math.min(creationPoint.y, p.y),
					Math.abs(creationPoint.x - p.x), 
					Math.abs(creationPoint.y - p.y), 
					dwg.getColor()));
			System.out.println(creationPoint.toString());
		}
	}
}