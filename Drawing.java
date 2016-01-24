/*	Drawing class handles painting and other related tasks
 * @author Sam Rodberg
 * @version 1/23/16
 */

import java.awt.*;
import java.util.ArrayList;

public class Drawing {
	
	private Color color;
	private ArrayList<Shape> shapes;
	
	// Start with mandated methods for the Drawing class
	
	/**
	 * Constructor which creates an empty drawing sets the default color given the
	 * value of defColor.  Also creates an array list of all shapes in the drawing
	 * initially there will be no shapes in the array list.
	 * @param defColor
	 */
	public Drawing(Color defColor){
		this.color = defColor;
		this.shapes = new ArrayList<Shape>();
	}
	
	/**
	 * Given a reference to a Graphics object has each shape in the drawing draw
	 * itself
	 * @param gObject
	 */
	public void draw(Graphics gObject){
		for(Shape listShapes:shapes){
			listShapes.draw(gObject);
		}
		
	}
	
	// Basic thoughts
	// 1. Point is passed in the method point p
	// 2. For the shapes in the shape list
	// 3. if shape contains point front most shape
	// 4. return front most shape
	public Shape getFrontmostContainer(Point p){
		for(Shape shape:shapes){
			if(shape.containsPoint(p)){
				return shape; 
			}
		}
		return null;
	}

}
