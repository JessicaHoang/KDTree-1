
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rect extends JPanel 
{
	JFrame frame;
	Rectangle rec;
	
	public Rect()
	{
		rec = new Rectangle(100, 200, 50, 75);
	}
	
	public void drawRect()
	{
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(600, 600);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		
	}
	
	public void paintComponent (Graphics g)
	{
		//Any time you want to change the color
		g.setColor(Color.blue);
		
		//the following draws a rectangle at top left corner 50, 50 width and a height of 400, 400
		g.drawRect(50,  50, 400, 400);
		
		g.setColor(Color.red);
		
		//the following draws a vertical line at top coordinate 50, 50 and bottom coordinate 100, 200
		g.drawLine(100, 100, 100, 200);
		g.setColor(Color.black);
		
		//The following is a circle with a radius of 10, 10 and coordinate 150, 150
		//belongs to a rectangle top left coordinate of width 10 and height 10 encompassing the circle
		//g.drawOval does not fill the circle
		g.fillOval(150, 150, 10, 10);
		
		g.setColor(Color.green);
		//the following is a horizontal line
		g.drawLine(50, 155, 300, 155);
	}
	
	
}
