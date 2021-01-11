
import java.awt.Graphics;
import java.lang.Math;
/**
 * @author Furkan Ozev
 * @since 17-01-2019
 * Class ComposedShape all implement the Shape interface.
 */
public class ComposedShape implements Shape
{
	private double area_;
	private double perimeter_;
	int arr_size; // Actually not necessary, can length method but it is just for check.
	private Shape[] arr;
	
	/**
	 * Constructor that take 2 shape. container = Rectangle , inner = Rectangle.
	 * @param shape1 container Rectangle
	 * @param shape2 inner Rectangle
	 */
	ComposedShape(Rectangle shape1, Rectangle shape2)
	{	
		int temp = (int)(shape1.area() / shape2.area());
		temp = temp + 1;
		arr = new Shape[temp];
		area_ = shape1.area();
		perimeter_ = shape1.perimeter();
		OptimalFit(shape1, shape2);
	}
	/**
	 * Constructor that take 2 shape. container = Rectangle , inner = Circle.
	 * @param shape1 container Rectangle
	 * @param shape2 inner Circle
	 */
	ComposedShape(Rectangle shape1, Circle shape2)
	{	
		int temp = (int)(shape1.area() / shape2.area());
		temp = temp + 1;
		arr = new Shape[temp];
		area_ = shape1.area();
		perimeter_ = shape1.perimeter();
		OptimalFit(shape1, shape2);
	}
	/**
	 * Constructor that take 2 shape. container = Rectangle , inner = Triangle.
	 * @param shape1 container Rectangle
	 * @param shape2 inner Triangle
	 */
	ComposedShape(Rectangle shape1, Triangle shape2)
	{	
		int temp = (int)(shape1.area() / shape2.area());
		temp = temp + 1;
		arr = new Shape[temp];
		area_ = shape1.area();
		perimeter_ = shape1.perimeter();
		OptimalFit(shape1, shape2);
	}
	/**
	 * Constructor that take 2 shape. container = Circle , inner = Rectangle.
	 * @param shape1 container Circle
	 * @param shape2 inner Rectangle
	 */
	ComposedShape(Circle shape1, Rectangle shape2)
	{	
		int temp = (int)(shape1.area() / shape2.area());
		temp = temp + 1;
		arr = new Shape[temp];
		area_ = shape1.area();
		perimeter_ = shape1.perimeter();
		OptimalFit(shape1, shape2);
	}
	/**
	 * Constructor that take 2 shape. container = Circle , inner = Circle.
	 * @param shape1 container Circle
	 * @param shape2 inner Circle
	 */
	ComposedShape(Circle shape1, Circle shape2)
	{	
		int temp = (int)(shape1.area() / shape2.area());
		temp = temp + 1;
		arr = new Shape[temp];
		area_ = shape1.area();
		perimeter_ = shape1.perimeter();
		OptimalFit(shape1, shape2);
	}
	/**
	 * Constructor that take 2 shape. container = Circle , inner = Triangle.
	 * @param shape1 container Circle
	 * @param shape2 inner Triangle
	 */
	ComposedShape(Circle shape1, Triangle shape2)
	{	
		int temp = (int)(shape1.area() / shape2.area());
		temp = temp + 1;
		arr = new Shape[temp];
		area_ = shape1.area();
		perimeter_ = shape1.perimeter();
		OptimalFit(shape1, shape2);
	}
	/**
	 * Constructor that take 2 shape. container = Triangle , inner = Rectangle.
	 * @param shape1 container Triangle
	 * @param shape2 inner Rectangle
	 */
	ComposedShape(Triangle shape1, Rectangle shape2)
	{	
		int temp = (int)(shape1.area() / shape2.area());
		temp = temp + 1;
		arr = new Shape[temp];
		area_ = shape1.area();
		perimeter_ = shape1.perimeter();
		OptimalFit(shape1, shape2);
	}
	/**
	 * Constructor that take 2 shape. container = Triangle , inner = Circle.
	 * @param shape1 container Triangle
	 * @param shape2 inner Circle
	 */
	ComposedShape(Triangle shape1, Circle shape2)
	{	
		int temp = (int)(shape1.area() / shape2.area());
		temp = temp + 1;
		arr = new Shape[temp];
		area_ = shape1.area();
		perimeter_ = shape1.perimeter();
		OptimalFit(shape1, shape2);
	}
	/**
	 * Constructor that take 2 shape. container = Triangle , inner = Triangle.
	 * @param shape1 container Triangle
	 * @param shape2 inner Triangle
	 */
	ComposedShape(Triangle shape1, Triangle shape2)
	{	
		int temp = (int)(shape1.area() / shape2.area());
		temp = temp + 1;
		arr = new Shape[temp];
		area_ = shape1.area();
		perimeter_ = shape1.perimeter();
		OptimalFit(shape1, shape2);
	}
	
	/**
	 * Default constructor
	 */
	ComposedShape()
	{	
		area_ = 0;
		perimeter_ = 0;
	}
	
	/**
	 * OptimalFit function that add container and inner small shapes into the Array.
	 * @param shape1 container Rectangle
	 * @param shape2 inner Rectangle
	 */
	public void OptimalFit(Rectangle shape1, Rectangle shape2)
	{
		int inco = 0;
		arr[inco] = new Rectangle(shape1.getwidth(),shape1.getheight(),0,0,"red");
		inco++;
		/* Get container and inner shapes values. */
		double width = shape1.getwidth(), height = shape1.getheight(), width2 = shape2.getwidth(), height2 = shape2.getheight();
		/* pos1 and pos2 => To calculate possibility to rotate, x and y => to keep coordinate */
		double x=0 ,y=0, temp;
		int pos1, pos2;
		/* tempx and tempy keep coordinate, count_x keep numbers of shapes that fit horizontally, count_y keep numbers of shapes that fit vertically, temp_count keep numbers of shapes fitted in big rectangle */
		double tempx, tempy;
		int count_x=0;

		
		pos1 = (int)((width / width2) * (height / height2));			/* If we place rectangles as user enters */
		pos2 = (int)((width / height2) * (height / width2));			/* If we place rectangles as rotate 90 degrees */
		
		/* Compared to which one can have more shapes*/
		if(pos2 > pos1)			/* Rotate 90 degrees and fit in big Rectangle */
		{
			temp = width2;
			width2 = height2;
			height2 = temp;
		}
		
		/* Small shapes will be placed upwards from the bottom of the large rectangle. */
		while(height - y >= height2)
		{
			x=0;		/* Started point is 0 for x axis */
			/* Small shapes will be placed from the left of the large rectangle to the right. */
			while(width - x >= width2)
			{
				/* Create new inner shape and send pointer of this shape to array */
				Rectangle small_shape = new Rectangle();
				/* For different colors */
				if(count_x % 3 == 0) small_shape.setcolor("green");
				else if(count_x % 3 == 1) small_shape.setcolor("yellow");
				else small_shape.setcolor("pink");
				/* Set values in small_shape then small_shape pushed in array to keep */
				small_shape.setposx(x);
				small_shape.setposy(y);
				small_shape.setwidth(width2);
				small_shape.setheight(height2);
				small_shape.add_total_area();
				small_shape.add_total_perimeter();
				arr[inco] = small_shape;
				inco++;
				/* Next possible coordinate */
				x += width2;
				count_x++;
			}
			y += height2;
		}
		
		/* Let's fit shapes on the empty parts of right. */
		tempx = x;
		tempy = y;
		
		y=0;
		/* It is trying to fit the small rectangles by rotate 90 degrees on the right side of the large rectangle. Start from the top of y axis.*/
		while(height - y >= width2)
		{
			x = tempx;
			while(width - x >= height2)
			{
				/* Create new inner shape and send pointer of this shape to array */
				Rectangle small_shape2 = new Rectangle();
				/* For different colors */
				if(count_x % 3 == 0) small_shape2.setcolor("green");
				else if(count_x % 3 == 1) small_shape2.setcolor("yellow");
				else small_shape2.setcolor("pink");
				/* Set values in small_shape then small_shape pushed in array to keep */
				small_shape2.setposx(x);
				small_shape2.setposy(y);
				small_shape2.setwidth(height2);
				small_shape2.setheight(width2);
				small_shape2.add_total_area();
				small_shape2.add_total_perimeter();
				arr[inco] = small_shape2;
				inco++;
				/* Next possible coordinate */
				x += height2;
				count_x++;
			}
			y += width2;
		}
		/* Let's fit shapes on the empty parts of bottom. */
		/* It is trying to fit the small rectangles by rotate 90 degrees on the bottom side of the large rectangle. Start from the top of x axis.*/
		y=tempy;
		x=0;
		while(height - y >= width2)
		{
			x = 0;
			while(width - x >= height2)
			{
				/* Create new inner shape and send pointer of this shape to array */
				Rectangle small_shape3 = new Rectangle();
				/* For different colors */
				if(count_x % 3 == 0) small_shape3.setcolor("green");
				else if(count_x % 3 == 1) small_shape3.setcolor("yellow");
				else small_shape3.setcolor("pink");
				/* Set values in small_shape then small_shape pushed in array to keep */
				small_shape3.setposx(x);
				small_shape3.setposy(y);
				small_shape3.setwidth(height2);
				small_shape3.setheight(width2);
				small_shape3.add_total_area();
				small_shape3.add_total_perimeter();
				arr[inco] = small_shape3;
				inco++;
				/* Next possible coordinate */
				x += height2;
				count_x++;
			}
			y += width2;
		}
		
		arr_size = inco;
	}
	
	/* Circles within A Rectangle */
	/**
	 * OptimalFit function that add container and inner small shapes into the Array.
	 * @param shape1 container Rectangle
	 * @param shape2 inner Circle
	 */
	public void OptimalFit(Rectangle shape1, Circle shape2)
	{
		int inco = 0;
		arr[inco] = new Rectangle(shape1.getwidth(),shape1.getheight(),0,0,"red");
		inco++;
		/* Get container and inner shapes values. */
		double width = shape1.getwidth(), height = shape1.getheight(), radius2 = shape2.getradius();
		
		int numx=0, numy=0, countx=0, county=0, temp;
		double tempx, tempy;
		/* numx =>  Number of horizontally fits , numy =>  Number of vertically fits, countx keep fitted shapes, county keep step of vertically */
		double wastex, wastey;
		/* wastex and wastey keep free places */

		/* Calculate how many shapes by horizontal and vertical  will be placed. */
		numx = temp = (int)(width / (2*radius2));
		numy = (int)(height / (2*radius2));
		/*It can center the small shapes by sharing the free places equally.*/
		wastex = (width - numx * radius2 * 2) / 2;
		wastey = (height - numy * radius2 * 2) / 2;
		
		while(numy > 0)
		{
			/* Calculate y coordinate */
			tempy = (radius2 + county * radius2 * 2);
			countx = 0;
			numx = temp;		/* Started point for x axis */
			while(numx > 0)
			{
				/* Create new inner shape and send pointer of this shape to array */
				
				Circle small_shape = new Circle();
				/* Calculate x coordinate */
				tempx = radius2 + countx * radius2 * 2;
				/* Set values in small_shape then small_shape pushed in array to keep */
				small_shape.setcolor("green");
				small_shape.setradius(radius2);
				small_shape.setcenterx(wastex+tempx);
				small_shape.setcentery(wastey+tempy);
				small_shape.add_total_area();
				small_shape.add_total_perimeter();
				arr[inco] = small_shape;
				inco++;
				countx++;
				numx--;
			}
			county++;
			numy--;
		}
		
		arr_size = inco;
		
	}
	
	/* Triangles within A Rectangle */
	/**
	 * OptimalFit function that add container and inner small shapes into the Array.
	 * @param shape1 container Rectangle
	 * @param shape2 inner Triangle
	 */
	public void OptimalFit(Rectangle shape1, Triangle shape2)
	{
		int inco = 0;
		arr[inco] = new Rectangle(shape1.getwidth(),shape1.getheight(),0,0,"red");
		inco++;
		/* Get container and inner shapes values. */
		double width = shape1.getwidth(), height = shape1.getheight(), edge2 = shape2.getedge();
		
		int county=0;
		/* Coordinate of triangles */
		double x1, x2, x3, y1, y2, y3;
		double tempx, tempy;
		/* numx =>  Number of horizontally fits , numy =>  Number of vertically fits */

		int i, j, temp_counter = 0, numx, numy, temp;
		
		
		numx = (int)(width / edge2);
		numy = (int)(height / (edge2*Math.sqrt(3)/2));
		temp = numx;
		
		x1 = 0;
		y1 = 0;
		x2 = edge2;
		y2 = 0;
		x3 = edge2/2;
		y3 = edge2/2*Math.sqrt(3);
		
		i = numy;
		j = numx;
		
		/* Calculate to fit shapes by possible horizontal and vertical. */ 
		while(i>0)
		{
			j = temp;
			tempy = county*edge2*Math.sqrt(3)/2;		/* Calculate y coordinate */
			temp_counter = 0;
			while(j>0)
			{
				/* Create new inner shape and send pointer of this shape to array */
				Triangle small_shape = new Triangle();
				/* Calculate x coordinate */
				tempx = temp_counter*edge2;
				/* Set values in small_shape then small_shape pushed in array to keep */
				small_shape.setcolor("yellow");
				small_shape.setedge(edge2);
				small_shape.setposx1(x1+tempx);
				small_shape.setposy1(y1+tempy);
				small_shape.setposx2(x2+tempx);
				small_shape.setposy2(y2+tempy);
				small_shape.setposx3(x3+tempx);
				small_shape.setposy3(y3+tempy);
				small_shape.add_total_area();
				small_shape.add_total_perimeter();
				arr[inco] = small_shape;
				inco++;
				j--;
				temp_counter++;
			}
			county++;
			i--;	
		}
		/* Keep fitted shapes number */
		
		county = 0;
		/* Calculate to fit shapes */
		numx = (int)((width-edge2/2) / edge2);
		numy = (int)(height / (edge2*Math.sqrt(3)/2));
		temp = numx;
		
		/* Calculate new coordinate for triangles' base at the top. */
		x1 = edge2;
		y1 = 0;
		x2 = edge2/2;
		y2 = edge2/2*Math.sqrt(3);
		x3 = edge2*3/2;
		y3 = edge2/2*Math.sqrt(3);
		
		i = numy;
		j = numx;
		/* The triangles are placed with the base on top. */
		while(i>0)
		{
			j = temp;
			tempy = county*edge2*Math.sqrt(3)/2;			/* Calculate y coordinate */
			temp_counter = 0;
			while(j>0)
			{
				/* Create new inner shape and send pointer of this shape to array */
				Triangle small_shape2 = new Triangle();
				tempx = temp_counter*edge2;			/* Calculate x coordinate */
				/* Set values in small_shape then small_shape pushed in array to keep */
				small_shape2.setcolor("green");
				small_shape2.setedge(edge2);
				small_shape2.setposx1(x1+tempx);
				small_shape2.setposy1(y1+tempy);
				small_shape2.setposx2(x2+tempx);
				small_shape2.setposy2(y2+tempy);
				small_shape2.setposx3(x3+tempx);
				small_shape2.setposy3(y3+tempy);
				small_shape2.add_total_area();
				small_shape2.add_total_perimeter();
				arr[inco] = small_shape2;
				inco++;
				j--;
				temp_counter++;
			}
			county++;
			i--;	
		}

		arr_size = inco;

	}
	
	/* Rectangles within A Circle */
	/**
	 * OptimalFit function that add container and inner small shapes into the Array.
	 * @param shape1 container Circle
	 * @param shape2 inner Rectangle
	 */
	public void OptimalFit(Circle shape1, Rectangle shape2)
	{
		int inco = 0;
		arr[inco] = new Circle(shape1.getradius(),shape1.getradius(),shape1.getradius(),"red");
		inco++;
		/* Get container and inner shapes values. */
		double radius = shape1.getradius(), width2 = shape2.getwidth(), height2 = shape2.getheight();
		
		int flag=0, count=0;
		/* Variables to define center coordinate */
		double x; 
		double y;
		/* Start to fit on x=0 and y=0 */
		x = 0;
		y = 0;
		
		/* It places rectangles in the circle from upper to bottom. */
		while(y <= 2*radius)
		{
			x = 0.5;
			flag = 0;
			/* It places rectangles in the circle from left to right. */
			while(x <= 2*radius)
			{
				/* Check that the rectangle is inside the circle. To use circle equation for corners of the rectangle.*/ 
				if((Math.pow(radius-x,2) + Math.pow(radius-y,2) <= Math.pow(radius,2)) && (Math.pow(radius-x-width2,2) + Math.pow(radius-y,2) <= Math.pow(radius,2)) && (Math.pow(radius-x,2) + Math.pow(radius-y-height2,2) <= Math.pow(radius,2)) && (Math.pow(radius-x-width2,2) + Math.pow(radius-y-height2,2) <= Math.pow(radius,2)))
				{
					/* Create new inner shape and send pointer of this shape to array */
					Rectangle small_shape = new Rectangle();
					/* Set values in small_shape then small_shape pushed in array to keep */
					if(count % 3 == 0) small_shape.setcolor("green");
					else if(count % 3 == 1) small_shape.setcolor("yellow");
					else small_shape.setcolor("blue");
					small_shape.setwidth(width2);
					small_shape.setheight(height2);
					small_shape.setposx(x+0.5);
					small_shape.setposy(y+0.5);
					small_shape.add_total_area();
					small_shape.add_total_perimeter();
					arr[inco] = small_shape;
					inco++;
					/* New x coordinate */
					x += (width2+0.5);
					/* If the rectangle is placed, flag will be 1. */
					flag=1;
					count++;
				}
				/* Fit rectangles not possible for this x coordinate then x increase 1 and check again */
				else x += 1;
			}
			/* If the rectangle is placed, determine new y coordinate */
			if(flag==1) y += (height2+0.5);
			/* Fit rectangles not possible for this y coordinate then y increase  1 and check again */
			else y += 1;
		}

		arr_size = inco;

	}
	
	/* Circles within A Circle */
	/**
	 * OptimalFit function that add container and inner small shapes into the Array.
	 * @param shape1 container Circle
	 * @param shape2 inner Circle
	 */
	public void OptimalFit(Circle shape1, Circle shape2)
	{
		int inco = 0;
		arr[inco] = new Circle(shape1.getradius(),shape1.getradius(),shape1.getradius(),"red");
		inco++;
		/* Get container and inner shapes values. */
		double radius = shape1.getradius(), radius2 = shape2.getradius();
		
		int flag=0;
		double x=0;
		double y=0;
		
		/* It places circles in the circle from upper to bottom. */
		while(y <= 2*radius)
		{
			x = 0;
			flag = 0;
			/* It places rectangles in the circle from left to right. */
			while(x <= 2*radius)
			{
				/* Check that the small circles is inside the circle. To use circle equation for small circle. Think of it as fitting the smallest squares around the circle. But not fit squares , fit circles. So checked squares corners with circle equation.*/ 
				if((Math.pow(radius-x,2) + Math.pow(radius-y,2) <= Math.pow(radius,2)) && (Math.pow(radius-x-radius2*2,2) + Math.pow(radius-y,2) <= Math.pow(radius,2)) && (Math.pow(radius-x,2) + Math.pow(radius-y-radius2*2,2) <= Math.pow(radius,2)) && (Math.pow(radius-x-radius2*2,2) + Math.pow(radius-y-radius2*2,2) <= Math.pow(radius,2)))
				{
					/* Create new inner shape and send pointer of this shape to array */
					Circle small_shape = new Circle();
					/* Set values in small_shape then small_shape pushed in array to keep */
					small_shape.setcolor("green");
					small_shape.setradius(radius2);
					small_shape.setcenterx(x+radius2);
					small_shape.setcentery(y+radius2);
					small_shape.add_total_area();
					small_shape.add_total_perimeter();
					arr[inco] = small_shape;
					inco++;
					/* Update new possible coordinate */
					x += radius2*2;
					/* If circle is fitted, then flag will be 1 .*/
					flag=1;
				}
				/* Circle was not fitted, then increase x coordinate by 1 then check again. */
				else x += 1;
			}
			/* If circle is fitted, then update new possible y coordinate */
			if(flag==1) y += radius2*2;
			/* else increase y coordinate by 1 then check again */
			else y += 1;
		}

		arr_size = inco;

	}
	
	/* Triangles within A Circle */
	/**
	 * OptimalFit function that add container and inner small shapes into the Array.
	 * @param shape1 container Circle
	 * @param shape2 inner Triangle
	 */
	public void OptimalFit(Circle shape1, Triangle shape2)
	{
		int inco = 0;
		arr[inco] = new Circle(shape1.getradius(),shape1.getradius(),shape1.getradius(),"red");
		inco++;
		/* Get container and inner shapes values. */
		double radius = shape1.getradius(), edge2 = shape2.getedge();
		
		int flag=0;
		double x1; 
		double x2, x3, y1, y2, y3;			/* Coordinate of triangles */
		
		/* Calculate triangles coordinate */
		x1 = 0;
		y1 = 2*radius;
		x2 = x1+edge2;
		y2 = y1;
		x3 = (x1+x2)/2;
		y3 = y1-edge2*Math.sqrt(3)/2;
		
		/* It places triangles in the circle from bottom to upper. */
		while(y3 >= 0)
		{
			/* Update new coordinate of next possible triangle */
			x1 = 0;
			x2 = x1+edge2;
			x3 = (x1+x2)/2;
			y2 = y1;
			y3 = y1-edge2*Math.sqrt(3)/2;
			flag=0;
			/* It places triangles in the circle from left to right. */
			while(x2 <= 2*radius)
			{
				/* Check that the small triangles are inside the circle. To use circle equation for small triangles. So checked triangles corners with circle equation.*/ 
				if((Math.pow(radius-x1,2) + Math.pow(radius-y1,2) <= Math.pow(radius,2)) && (Math.pow(radius-x2,2) + Math.pow(radius-y2,2) <= Math.pow(radius,2)) && (Math.pow(radius-x3,2) + Math.pow(radius-y3,2) <= Math.pow(radius,2)))
				{
					/* Create new inner shape and send pointer of this shape to array */
					Triangle small_shape = new Triangle();
					/* Set values in small_shape then small_shape pushed in array to keep */
					small_shape.setcolor("green");
					small_shape.setedge(edge2);
					small_shape.setposx1(x1);
					small_shape.setposy1(y1);
					small_shape.setposx2(x2);
					small_shape.setposy2(y2);
					small_shape.setposx3(x3);
					small_shape.setposy3(y3);
					small_shape.add_total_area();
					small_shape.add_total_perimeter();
					arr[inco] = small_shape;
					inco++;
					flag=1;
					/* If possible, print the other triangle that rotated it 60 degrees alongside. Check with circle equation */
					if((Math.pow(radius-x1-edge2*3/2,2) + Math.pow(radius-y1+edge2*Math.sqrt(3)/2,2) <= Math.pow(radius,2)) && (Math.pow(radius-x2,2) + Math.pow(radius-y2,2) <= Math.pow(radius,2)) && (Math.pow(radius-x3,2) + Math.pow(radius-y3,2) <= Math.pow(radius,2)))
					{
						/* Create new inner shape and send pointer of this shape to array */
						Triangle small_shape2 = new Triangle();
						/* Set values in small_shape then small_shape pushed in array to keep */
						small_shape2.setcolor("blue");
						small_shape2.setedge(edge2);
						small_shape2.setposx1(x1+edge2*3/2);
						small_shape2.setposy1(y1-edge2*Math.sqrt(3)/2);
						small_shape2.setposx2(x2);
						small_shape2.setposy2(y2);
						small_shape2.setposx3(x3);
						small_shape2.setposy3(y3);
						small_shape2.add_total_area();
						small_shape2.add_total_perimeter();
						arr[inco] = small_shape2;
						inco++;
					}
					/* If triangle fitted , then next possible x coordinates */
					x1 += edge2;
				}
				/* Else increase x coordinates then checked again */
				/* Calculate new coordinate */
				else x1 += 1;
				x2 = x1+edge2;
				x3 = (x1+x2)/2;
			}
			/* Update new y coordinates */
			if(flag==1) y1 -= edge2*Math.sqrt(3)/2;
			else y1 -= 1;
		}

		arr_size = inco;

	}
	
	/* Rectangles within A Triangle */
	/**
	 * OptimalFit function that add container and inner small shapes into the Array.
	 * @param shape1 container Triangle
	 * @param shape2 inner Rectangle
	 */
	public void OptimalFit(Triangle shape1, Rectangle shape2)
	{
		int inco = 0;
		arr[inco] = new Triangle(shape1.getedge(),shape1.getposx1(),shape1.getposy1(),shape1.getposx2(),shape1.getposy2(),shape1.getposx3(),shape1.getposy3(),"red");
		inco++;
		/* Get container and inner shapes values. */
		double edge = shape1.getedge(), width2 = shape2.getwidth(), height2 = shape2.getheight();
		
		int county = 0, countcolor=0;
		double posx;
		double posy, scroll;
		/* calculate scroll amount */
		scroll = height2 / Math.sqrt(3);
		/* Determine cursor coordinate */
		posx = 0;
		posy = (edge/2)*Math.sqrt(3);
	
		/* It places rectangles in the triangle from bottom to top. */
		while(posy-height2 >= 0)
		{
			county++;
			/* The position of x changes after each step. */
			posx = scroll*county;
			countcolor=0;
			/* It places rectangles in the triangle from x coordinate to new edge. */
			while( (posx+width2 <= edge-scroll*county) ) 
			{	
			/* Create new inner shape and send pointer of this shape to array */
				Rectangle small_shape = new Rectangle();
				/* Choose different color */ 
				if(countcolor % 2 == 0) small_shape.setcolor("green");
				else small_shape.setcolor("yellow");
				/* Set values in small_shape then small_shape pushed in array to keep */
				small_shape.setwidth(width2);
				small_shape.setheight(height2);
				small_shape.setposx(posx);
				small_shape.setposy(posy-height2);
				small_shape.add_total_area();
				small_shape.add_total_perimeter();
				arr[inco] = small_shape;
				inco++;
				countcolor++;
				/* Update new position of x. */
				posx += width2;
			}
			/* Update new position of y. */
			posy -= height2;
		}

		arr_size = inco;

	}
	
	/* Circles within A Triangle */
	/**
	 * OptimalFit function that add container and inner small shapes into the Array.
	 * @param shape1 container Triangle
	 * @param shape2 inner Circle
	 */
	public void OptimalFit(Triangle shape1, Circle shape2)
	{
		int inco = 0;
		arr[inco] = new Triangle(shape1.getedge(),shape1.getposx1(),shape1.getposy1(),shape1.getposx2(),shape1.getposy2(),shape1.getposx3(),shape1.getposy3(),"red");
		inco++;
		/* Get container and inner shapes values. */
		double edge = shape1.getedge(), radius2 = shape2.getradius();
		
		double y2, h1=0, h2=0, h3=0, h=0;
		y2 = (edge/2)*Math.sqrt(3);
		h = (edge/2)*Math.sqrt(3);
		double posx = 0, posy = y2-radius2;
		int flag=0;
		
		/* It places circles in the triangle from bottom to top. */
		while(posy-radius2 >= 0)
		{
			flag=0;
			posx = 0;
			while(posx+radius2 <= edge)
			{
				/* It controls the corners of the smallest square surrounding the circle. */
				if(posx <= edge/2) h1 = posx*Math.sqrt(3);
				else h1 = (edge-posx)*Math.sqrt(3);
				if(posx-radius2 <= edge/2) h2 = (posx-radius2)*Math.sqrt(3);
				else h2 = (edge-posx+radius2)*Math.sqrt(3);
				if(posx+radius2 <= edge/2) h3 = (posx+radius2)*Math.sqrt(3);
				else h3 = (edge-posx-radius2)*Math.sqrt(3);
				/* Calculates the coordinates of the corners and checks if they are inside. */
				if(h-(posy-radius2) <= h1 && h-(posy-radius2) <= h2 && h-(posy-radius2) <= h3)
				{
					/* Create new inner shape and send pointer of this shape to array */
					Circle small_shape = new Circle();
					/* Set values in small_shape then small_shape pushed in array to keep */
					small_shape.setcolor("green");
					small_shape.setcenterx(posx);
					small_shape.setcentery(posy);
					small_shape.setradius(radius2);
					small_shape.add_total_area();
					small_shape.add_total_perimeter();
					arr[inco] = small_shape;
					inco++;
					/* If circle fitted , then next possible x coordinates */
					posx += 2*radius2;
					flag=1;	
				}
				/* Else posx coordinate increase by 1 and check again */
				posx += 1;
			}
			/* If triangle fitted on x axis, then next possible y coordinates */
			if(flag==1)	posy -= 2*radius2;
			/* Else posy coordinate increase by 1 and check again */
			else posy -= 1;
		}
		
		arr_size = inco;

	}
	
	/* Triangles within A Triangle */
	/**
	 * OptimalFit function that add container and inner small shapes into the Array.
	 * @param shape1 container Triangle
	 * @param shape2 inner Triangle
	 */
	public void OptimalFit(Triangle shape1, Triangle shape2)
	{
		int inco = 0;
		arr[inco] = new Triangle(shape1.getedge(),shape1.getposx1(),shape1.getposy1(),shape1.getposx2(),shape1.getposy2(),shape1.getposx3(),shape1.getposy3(),"red");
		inco++;
		/* Get container and inner shapes values. */
		double edge = shape1.getedge(), edge2 = shape2.getedge();
		
		int county=0;
		double waste;
		/* Calculate height of big triangle */
		double h = (edge/2)*Math.sqrt(3);
		int num = (int)(edge / edge2);
		waste = (edge - num*edge2)/2;
		double posx = waste, posy = h;
		
		/* It should be 0 but -0.0001 the margin of error due to rounding in double calculations. */
		/* It places triangles in the triangle from bottom to top. */
		while(posy-edge2*Math.sqrt(3)/2 >= -0.0001)
		{
			/* Add waste to center small shapes in the big triangle */
			posx = waste + edge2/2*county;
			/* It places triangles in the triangle from left to right. */
			while(posx+edge2 <= edge-edge2/2*county)
			{
				/* Create new inner shape and send pointer of this shape to array */
				Triangle small_shape = new Triangle();
				/* Set values in small_shape then small_shape pushed in array to keep */
				small_shape.setcolor("green");
				small_shape.setedge(edge2);
				small_shape.setposx1(posx);
				small_shape.setposy1(posy);
				small_shape.setposx2(posx+edge2);
				small_shape.setposy2(posy);
				small_shape.setposx3(posx+edge2/2);
				small_shape.setposy3(posy-edge2/2*Math.sqrt(3));
				small_shape.add_total_area();
				small_shape.add_total_perimeter();
				arr[inco] = small_shape;
				inco++;
				/* If possible, print the other triangle that rotated it 60 degrees alongside. Check corners and fit */
				if(posx+edge2*3/2 <= edge-edge2/2*county)
				{
					Triangle small_shape2 = new Triangle();
					/* Set values in small_shape then small_shape pushed in array to keep */
					small_shape2.setcolor("yellow");
					small_shape2.setedge(edge2);
					small_shape2.setposx1(posx+edge2/2);
					small_shape2.setposy1(posy-edge2/2*Math.sqrt(3));
					small_shape2.setposx2(posx+edge2*3/2);
					small_shape2.setposy2(posy-edge2/2*Math.sqrt(3));
					small_shape2.setposx3(posx+edge2);
					small_shape2.setposy3(posy);
					small_shape2.add_total_area();
					small_shape2.add_total_perimeter();
					arr[inco] = small_shape2;
					inco++;
				}
				/* Update new x location */
				posx += edge2;
			}
			/* Update new y location */
			posy -= edge2/2*Math.sqrt(3);
			county++;
		}
		
		arr_size = inco;

	}
	
	/**
	 * Get amount of shapes or size of array.
	 * @return integer Array size
	 */
	public int get_size()
	{
		return arr_size;
	}
	
	/**
	 * Get array of ComposedShape object.
	 * @return Shape[] Array of Shapes
	 */
	public Shape[] get_inners()
	{
		return arr;
	}
	
	/* 
	 * @see Shape#area()
	 */
	public double area()
	{
		return area_;
	}
	/* 
	 * @see Shape#perimeter()
	 */
	public double perimeter()
	{
		return perimeter_;
	}
	/* 
	 * @see Shape#increment()
	 */
	public void increment()
	{
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i] != null)
				arr[i].increment();
		}
	}
	/* 
	 * @see Shape#decrement()
	 */
	public void decrement()
	{
		int flag = 1;
		if(arr[0] instanceof Rectangle)
		{
			Rectangle temp = (Rectangle) arr[0];
			if(temp.getposx() < 1 || temp.getposy() < 1)
			{
				flag = -1;
			}
		}
		if(arr[0] instanceof Circle)
		{
			Circle temp = (Circle) arr[0];
			if(temp.getcenterx() - 1 < temp.getradius() || temp.getcentery() - 1 < temp.getradius())
			{
				flag = -1;
			}
		}
		if(arr[0] instanceof Triangle)
		{
			Triangle temp = (Triangle) arr[0];
			if(temp.getposx1() < 1 || temp.getposy1() < 1 || temp.getposx2() < 1 || temp.getposy2() < 1 || temp.getposx3() < 1 || temp.getposy3() < 1)
			{
				flag = -1;
			}
		}
		if(flag == 1)
		{
			for(int i=0; i<arr.length; i++)
			{
				if(arr[i] != null)
					arr[i].decrement();
			}
		}
	}
	/* 
	 * @see Shape#compareTo(Shape)
	 */
	public int compareTo( final Shape o)
	{
		if(area() > o.area()) return 1;
		else if(area() < o.area()) return -1; 
		else return 0;
	}
			
	/* 
	 * @see Shape#Draw(java.awt.Graphics)
	 */
	public void Draw(Graphics o)
	{
		for(Shape sp : arr)
		{
			if(sp instanceof Rectangle)
			{
				Rectangle temp = (Rectangle) sp;
				temp.Draw(o);
			}
			else if(sp instanceof Circle)
			{
				Circle temp = (Circle) sp;
				temp.Draw(o);
			}
			else if(sp instanceof Triangle)
			{
				Triangle temp = (Triangle) sp;
				temp.Draw(o);
			}
		}
	}

}
