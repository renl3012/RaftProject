package gameParts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import gameParts.*;

import java.awt.Image;


public class Downstream extends Canvas implements KeyListener, Runnable
{

	private BufferedImage back;
	private Raft ship;
	private boolean[] keys;
	private Image backgroundPic;
	
	private ManyLogs send;
	private Log[][] transfer;

	private ArrayList<Log> logStream;
	
	public Downstream(){
		ship = new Raft();
		keys = new boolean[3];
	}
	
	public void update(Graphics window)
	   {
		   paint(window);
	   }

		public void paint( Graphics window )
		{

			Graphics2D twoDGraph = (Graphics2D)window;


			if(back==null)
			   back = (BufferedImage)(createImage(getWidth(),getHeight()));


			Graphics graphToBack = back.createGraphics();
			
			try
			{
				backgroundPic = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\gameParts\\movingWater.png"));
			}
			catch(Exception e)
			{
				//feel free to do something here
				System.out.println("hi");
			}
	
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("RAFTING", 25, 50);
			graphToBack.drawImage(backgroundPic, 0, 0, null);
			//graphToBack.setColor(Color.BLACK);
			//graphToBack.fillRect(0,0,800,1000);
			
			//********don't change the lines above this*********
			
			ship.draw(graphToBack);
			
			
			//add code to move stuff
			if(keys[0] == true)
			{
				if(ship.getX() >= -10){
					ship.move("LEFT");
				}
				
			}
			
			if(keys[1] == true)
			{
				if(ship.getX() <= 720){
					ship.move("RIGHT");
				}
			}
			
			if(keys[2] == true)
			{
				
			}
			
			twoDGraph.drawImage(back, null, 0, 0);
		}

		
		//********no need to change the lines below**********
		
		public void keyPressed(KeyEvent e)
		{
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				keys[0] = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				keys[1] = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				keys[2] = true;
			}
			repaint();
		}

		public void keyReleased(KeyEvent e)
		{
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				keys[0] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				keys[1] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				keys[2] = false;
			}
			repaint();
		}

		public void keyTyped(KeyEvent e)
		{
			
		}

	   public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }catch(Exception e)
	      {
	      }
	  	}

}

