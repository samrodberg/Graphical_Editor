import java.awt.Color;
import java.awt.Point;

/**
 * Will the basis for handling how color buttons function
 * @author Sam Rodberg
 * @version 1/25/16
 */
public class ColorCmd extends Command {
	
	/**
	 * Set the color of the drawing at the current point to the drawings current
	 * color
	 * @param p
	 * @param dwg
	 */
	public void executeClick(Point p, Drawing dwg){
		Shape tempShape = dwg.getFrontmostContainer(p);
		if(tempShape != null){
			tempShape.setColor(dwg.getColor());
		}
		
	}
	
	/**
	 * Set the color of the drawing at the point clicked to Red
	 * @param p
	 * @param dwg
	 */
	public void setClickRed(Point p, Drawing dwg){
		Shape tempShape = dwg.getFrontmostContainer(p);
		if(tempShape != null){
			tempShape.setColor(Color.RED);
		}
		
	}
	
	/**
	 * Set the color of the drawing at the point clicked to Green
	 * @param p
	 * @param dwg
	 */
	public void setClickGreen(Point p, Drawing dwg){
		Shape tempShape = dwg.getFrontmostContainer(p);
		if(tempShape != null){
			tempShape.setColor(Color.GREEN);
		}
		
	}
	
	/**
	 * Set the color of the drawing at the point clicked to Blue
	 * @param p
	 * @param dwg
	 */
	public void setClickBlue(Point p, Drawing dwg){
		Shape tempShape = dwg.getFrontmostContainer(p);
		if(tempShape != null){
			tempShape.setColor(Color.BLUE);
		}
		
	}
}