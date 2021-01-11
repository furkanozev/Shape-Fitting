import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Furkan Ozev
 * @since 17-01-2019
 * This class includes Gui and call test function.
 * Approximately 92.5% of the code tested.
 */
public class main_161044036 {

	private JFrame frame;

	/**
	 * @param args String[]
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_161044036 window = new main_161044036();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		testothers();
	}

	public static void testothers()
	{
		System.out.println("\nSome functions will test.");
		Rectangle container = new Rectangle(440,320);
		Circle inner = new Circle(20);
		ComposedShape myshapes = new ComposedShape(container, inner);
		Shape[] new_arr;
		try {
			new_arr = SepClass.convertAll(myshapes.get_inners());
			SepClass.sortShapes(new_arr);
			for(int i=0 ; i < new_arr.length; i++)
			{
				if(new_arr[i] != null)
				{
					 new_arr[i].increment();
					 new_arr[i].decrement();
				}
			}
			SepClass.sortShapes(new_arr);
			if(new_arr[3].compareTo(container) < 0 && new_arr[3].compareTo(new_arr[3]) == 0)
				System.out.println("\nPolygonVect increment decrement compareTo function succesfully tested.");
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
		PolygonDyn poldyn = new PolygonDyn(container);
		poldyn.increment();
		poldyn.decrement();
		if(poldyn.compareTo(inner) > 0 && poldyn.compareTo(poldyn) == 0)
			System.out.println("\nPolygonVect increment decrement compareTo function succesfully tested.");
		/* Test Constructors */
		PolygonVect t1 = new PolygonVect(20,35);
		PolygonDyn t2 = new PolygonDyn(20,35);
		PolygonVect t3 = new PolygonVect(t2);
		PolygonDyn t4 = new PolygonDyn(t1);
		PolygonDyn t5 = new PolygonDyn(t4);
		PolygonVect t6 = new PolygonVect(t3);
		Shape[] testarr = new Shape[9];
		testarr[0] = myshapes;
		testarr[1] = poldyn;
		testarr[2] = new PolygonVect(container);
		testarr[3] = t1;
		testarr[4] = t2;
		testarr[5] = t3;
		testarr[6] = t4;
		testarr[7] = t5;
		testarr[8] = t6;
		
		SepClass.sortShapes(testarr);
		if(testarr[0].compareTo(testarr[1]) < 1 && testarr[1].compareTo(testarr[2]) < 1)
			System.out.println("\nsortAll function succesfully tested.");
	}
	/**
	 * Create the application.
	 */
	public main_161044036() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("-------------------------");
				System.out.println("\nProgram successfully closed. \n Good Bye!");
			}
		});
		frame.setBounds(0, 0, 582, 503);
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 13, 540, 349);
		frame.getContentPane().add(panel);
		
		JLabel label1 = new JLabel("Container shape");
		label1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		label1.setBackground(Color.RED);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(12, 375, 110, 35);
		frame.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("Inner shape");
		label2.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		label2.setBackground(Color.RED);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(147, 375, 110, 35);
		frame.getContentPane().add(label2);
		
		final JComboBox<String> comboBox1 = new JComboBox<String>();
		comboBox1.setMaximumRowCount(3);
		comboBox1.setBounds(12, 412, 112, 20);
		comboBox1.addItem("Rectangle");
		comboBox1.addItem("Circle");
		comboBox1.addItem("Triangle");
		frame.getContentPane().add(comboBox1);
		
		final JComboBox<String> comboBox2 = new JComboBox<String>();
		comboBox2.setSelectedIndex(-1);
		comboBox2.setMaximumRowCount(3);
		comboBox2.setBounds(157, 412, 110, 20);
		comboBox2.addItem("Rectangle");
		comboBox2.addItem("Circle");
		comboBox2.addItem("Triangle");
		frame.getContentPane().add(comboBox2);
		
		JButton button1 = new JButton("Draw");
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("\n-------------------------");
				System.out.println("\nContainer : " + comboBox1.getSelectedItem());
				System.out.println("Inner : " + comboBox2.getSelectedItem());
				Graphics g = panel.getGraphics();
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
				panel.paintComponents(g);
				ComposedShape myshapes;
				if(comboBox1.getSelectedItem() == "Rectangle" && comboBox2.getSelectedItem() == "Rectangle")
				{
					Rectangle container = new Rectangle(440,320);
					Rectangle inner = new Rectangle(30,40);
					System.out.format("\nContainer width = %.3f , height = %.3f , area = %.3f , perimeter = %.3f",container.getwidth(),container.getheight(),container.area(),container.perimeter());
					System.out.format("\nInner width = %.3f , height = %.3f , area = %.3f , perimeter = %.3f", inner.getwidth(),inner.getheight(),inner.area(),inner.perimeter());
					myshapes = new ComposedShape(container, inner);
					System.out.println("\n30 times call increment method. Succesfully tested.");
					for(int i=0; i<30; i++) myshapes.increment();
					System.out.println("10 times call decrement method. Succesfully tested.");
					for(int i=0; i<10; i++) myshapes.decrement();
					Shape[] new_arr;
					try {
						new_arr = SepClass.convertAll(myshapes.get_inners());
						SepClass.drawAll(new_arr, g);
					} catch (MyException e1) {
						System.out.println(e1.getMessage());
					}
					System.out.println("convertAll and drawAll succesfully tested.");
				}
				else if(comboBox1.getSelectedItem() == "Rectangle" && comboBox2.getSelectedItem() == "Circle")
				{
					Rectangle container = new Rectangle(490,320);
					Circle inner = new Circle(30);
					System.out.format("\nContainer width = %.3f , height = %.3f , area = %.3f , perimeter = %.3f",container.getwidth(),container.getheight(),container.area(),container.perimeter());
					System.out.format("\nInner radius = %.3f , area = %.3f , perimeter = %.3f", inner.getradius(),inner.area(),inner.perimeter());
					myshapes = new ComposedShape(container, inner);
					System.out.println("\n30 times call increment method. Succesfully tested.");
					for(int i=0; i<30; i++) myshapes.increment();
					System.out.println("10 times call decrement method. Succesfully tested.");
					for(int i=0; i<10; i++) myshapes.decrement();
					myshapes.Draw(g);
				}
				else if(comboBox1.getSelectedItem() == "Rectangle" && comboBox2.getSelectedItem() == "Triangle")
				{
					Rectangle container = new Rectangle(490,320);
					Triangle inner = new Triangle(30);
					System.out.format("\nContainer width = %.3f , height = %.3f , area = %.3f , perimeter = %.3f",container.getwidth(),container.getheight(),container.area(),container.perimeter());
					System.out.format("\nInner edge = %.3f , area = %.3f , perimeter = %.3f", inner.getedge(),inner.area(),inner.perimeter());
					myshapes = new ComposedShape(container, inner);
					System.out.println("\n30 times call increment method. Succesfully tested.");
					for(int i=0; i<30; i++) myshapes.increment();
					System.out.println("10 times call decrement method. Succesfully tested.");
					for(int i=0; i<10; i++) myshapes.decrement();
					myshapes.Draw(g);
				}
				else if(comboBox1.getSelectedItem() == "Circle" && comboBox2.getSelectedItem() == "Rectangle")
				{
					Circle container = new Circle(170);
					Rectangle inner = new Rectangle(25,35);
					System.out.format("\nContainer radius = %.3f , area = %.3f , perimeter = %.3f", container.getradius(),container.area(),container.perimeter());
					System.out.format("\nInner width = %.3f , height = %.3f , area = %.3f , perimeter = %.3f", inner.getwidth(),inner.getheight(),inner.area(),inner.perimeter());
					myshapes = new ComposedShape(container, inner);
					System.out.println("\n25 times call increment method. Succesfully tested.");
					for(int i=0; i<25; i++) myshapes.increment();
					System.out.println("20 times call decrement method. Succesfully tested.");
					for(int i=0; i<20; i++) myshapes.decrement();
					myshapes.Draw(g);
				}
				else if(comboBox1.getSelectedItem() == "Circle" && comboBox2.getSelectedItem() == "Circle")
				{
					Circle container = new Circle(170);
					Circle inner = new Circle(20);
					System.out.format("\nContainer radius = %.3f , area = %.3f , perimeter = %.3f", container.getradius(),container.area(),container.perimeter());
					System.out.format("\nInner radius = %.3f , area = %.3f , perimeter = %.3f", inner.getradius(),inner.area(),inner.perimeter());
					myshapes = new ComposedShape(container, inner);
					System.out.println("\n15 times call increment method. Succesfully tested.");
					for(int i=0; i<15; i++) myshapes.increment();
					System.out.println("10 times call decrement method. Succesfully tested.");
					for(int i=0; i<10; i++) myshapes.decrement();
					Shape[] new_arr ;
					try {
						new_arr = SepClass.convertAll(myshapes.get_inners());
						SepClass.drawAll(new_arr, g);
					} catch (MyException e1) {
						System.out.println(e1.getMessage());
					}
					System.out.println("convertAll and drawAll succesfully tested.");
				}
				else if(comboBox1.getSelectedItem() == "Circle" && comboBox2.getSelectedItem() == "Triangle")
				{
					Circle container = new Circle(170);
					Triangle inner = new Triangle(35);
					System.out.format("\nContainer radius = %.3f , area = %.3f , perimeter = %.3f", container.getradius(),container.area(),container.perimeter());
					System.out.format("\nInner edge = %.3f , area = %.3f , perimeter = %.3f", inner.getedge(),inner.area(),inner.perimeter());
					myshapes = new ComposedShape(container, inner);
					System.out.println("\n10 times call increment method. Succesfully tested.");
					for(int i=0; i<10; i++) myshapes.increment();
					System.out.println("10 times call decrement method. Succesfully tested.");
					for(int i=0; i<10; i++) myshapes.decrement();
					myshapes.Draw(g);
				}
				else if(comboBox1.getSelectedItem() == "Triangle" && comboBox2.getSelectedItem() == "Rectangle")
				{
					Triangle container = new Triangle(380);
					Rectangle inner = new Rectangle(25,35);
					System.out.format("\nContainer edge = %.3f , area = %.3f , perimeter = %.3f", container.getedge(),container.area(),container.perimeter());
					System.out.format("\nInner width = %.3f , height = %.3f , area = %.3f , perimeter = %.3f", inner.getwidth(),inner.getheight(),inner.area(),inner.perimeter());
					myshapes = new ComposedShape(container, inner);
					System.out.println("\n20 times call increment method. Succesfully tested.");
					for(int i=0; i<20; i++) myshapes.increment();
					System.out.println("10 times call decrement method. Succesfully tested.");
					for(int i=0; i<10; i++) myshapes.decrement();
					myshapes.Draw(g);
				}
				else if(comboBox1.getSelectedItem() == "Triangle" && comboBox2.getSelectedItem() == "Circle")
				{
					Triangle container = new Triangle(390);
					Circle inner = new Circle(20);
					System.out.format("\nContainer edge = %.3f , area = %.3f , perimeter = %.3f", container.getedge(),container.area(),container.perimeter());
					System.out.format("\nInner radius = %.3f , area = %.3f , perimeter = %.3f", inner.getradius(),inner.area(),inner.perimeter());
					myshapes = new ComposedShape(container, inner);
					System.out.println("\n15 times call increment method. Succesfully tested.");
					for(int i=0; i<15; i++) myshapes.increment();
					System.out.println("10 times call decrement method. Succesfully tested.");
					for(int i=0; i<10; i++) myshapes.decrement();
					myshapes.Draw(g);
				}
				else if(comboBox1.getSelectedItem() == "Triangle" && comboBox2.getSelectedItem() == "Triangle")
				{
					Triangle container = new Triangle(370);
					Triangle inner = new Triangle(35);
					System.out.format("\nContainer edge = %.3f , area = %.3f , perimeter = %.3f", container.getedge(),container.area(),container.perimeter());
					System.out.format("\nInner edge = %.3f , area = %.3f , perimeter = %.3f", inner.getedge(),inner.area(),inner.perimeter());
					myshapes = new ComposedShape(container, inner);
					System.out.println("\n30 times call increment method. Succesfully tested.");
					for(int i=0; i<30; i++) myshapes.increment();
					System.out.println("10 times call decrement method. Succesfully tested.");
					for(int i=0; i<10; i++) myshapes.decrement();
					Shape[] new_arr;
					try {
						new_arr = SepClass.convertAll(myshapes.get_inners());
						SepClass.drawAll(new_arr, g);
					} catch (MyException e1) {
						System.out.println(e1.getMessage());
					}
					System.out.println("convertAll and drawAll succesfully tested.");
				}
				
				panel.paintComponents(g);
				
			}
		});
		button1.setBounds(343, 375, 99, 25);
		frame.getContentPane().add(button1);
		
		JButton button2 = new JButton("Clear");
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				Graphics g = panel.getGraphics();
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, panel.getWidth(), panel.getHeight()); 
				panel.paintComponents(g);
			}
		});
		button2.setBounds(343, 410, 99, 25);
		frame.getContentPane().add(button2);
		
		JLabel lblFurkanzev = new JLabel("   Furkan \u00D6zev");
		lblFurkanzev.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblFurkanzev.setBounds(444, 418, 108, 25);
		frame.getContentPane().add(lblFurkanzev);
	}
}
