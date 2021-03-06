
import java.awt.Graphics;

/**
 * @author Furkan Ozev
 * @since 17-01-2019
 * SepClass includes static methods. drawAll, convertAll, sortShapes.
 */
public class SepClass
{
	/**
	 * Method drawAll takes an array of Shape references and draws all shapes to an JPanel.
	 * @param shapes Array of Shapes Shape[]
	 * @param g Graphics object
	 * @throws MyException if type is unknown, throw object of MyException.
	 */
	public static void drawAll(Shape[] shapes, Graphics g) throws MyException
	{
		// Method drawAll takes an array of Shape references and draws all shapes to an JPanel
		for(int i=0; i<shapes.length; i++)
		{
			if(shapes[i] != null)
				shapes[i].Draw(g);
			else if(shapes[i] == null) break;
			else throw new MyException("Unknown variable");
		}
	}
	
	/**
	 * Method convertAll takes an array of Shape references, converts all shapes to Polygons and returns a new array with the new shapes.
	 * @param shapes Array of Shapes Shape[]
	 * @return new_shapes Array of Shapes Shape[]
	 * @throws MyException if type is unknown, throw object of MyException.
	 */
	public static Shape[] convertAll(Shape[] shapes) throws MyException
	{
		// Method convertAll takes an array of Shape references, converts all shapes to Polygons and returns a new array with the new shapes.
		Shape[] new_shapes = new Shape[shapes.length];
		int i = 0;
		for(Shape x: shapes)
		{
			
			if(x instanceof Rectangle)
			{	
				Rectangle rec = (Rectangle) (x);
				new_shapes[i] = new PolygonVect((rec));
			}
			else if(x instanceof Circle)
			{	
				Circle cir = (Circle) (x);
				new_shapes[i] = new PolygonVect((cir));
			}
			else if(x instanceof Triangle)
			{	
				Triangle tri = (Triangle) (x);
				new_shapes[i] = new PolygonVect((tri));
			}
			else if(x instanceof ComposedShape)
			{	
				ComposedShape com = (ComposedShape) (x);
				Shape[] temp_shapes = convertAll(com.get_inners());
				
				for(Shape y : temp_shapes)
				{
					new_shapes[i] = (y);
				}
			}
			else if(x instanceof PolygonVect)
			{
				PolygonVect vect = (PolygonVect) (x);
				new_shapes[i] = new PolygonVect(vect);
			}
			else if(x instanceof PolygonDyn)
			{
				PolygonDyn dyn = (PolygonDyn) (x);
				new_shapes[i] = new PolygonVect(dyn);
			}
			else if (x != null) throw new MyException("Unknown type!");
			i++;
		}
		return new_shapes;
	}

	/**
	 * Method sortShapes takes an array of Shapes and increasingly sorts them with respect to their areas.
	 * @param shapes Array of Shapes Shape[]
	 */
	public static void sortShapes(Shape[] shapes)
	{
		// Method sortShapes takes an array of Shapes and increasingly sorts them with respect to their areas.
		int i,j;
		int size = 0;
		double area1, area2;
		Shape shp;
		for(i=0 ; i<shapes.length; i++)
			if(shapes[i] != null)
		size = i+1;
		for(i = 0 ; i < size ; i++)
		{
			for(j = 0 ; j < size ; j++)
			{
				area1 = shapes[i].area();
				area2 = shapes[j].area();
				if(area1 < area2)
				{
					shp = shapes[i];
					shapes[i] = shapes[j];
					shapes[j] = shp;
				}
			}
		}
	}
}
