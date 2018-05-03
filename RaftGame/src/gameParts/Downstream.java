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
import java.lang.Math;
import javax.imageio.ImageIO;
import gameParts.*;
import java.awt.Image;


public class Downstream extends Canvas implements KeyListener, Runnable
{

	private BufferedImage back;
	private Raft raft;
	private boolean[] keys;
	private Image backgroundPic;
	private int randX;
	
	private Log branch;
	
	private ManyLogs send;
	private Log[][] transfer;
	private ArrayList<Log> logStream;
	
	public Downstream(){
		raft = new Raft();
		keys = new boolean[2];
		
		logStream = new ArrayList<Log>();
		
		for(int e = 0; e < 5; e++){
			randX = (int)(Math.random() * 600);
			logStream.add(new Log(randX, (e-1)*200, 2));
		}
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
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

			graphToBack.drawImage(backgroundPic, 0, 0, 750, 992, null);
			
			//********don't change the lines above this*********
			
			raft.draw(graphToBack);
			
			for(int e = 0; e < 5; e++){
				(logStream.get(e)).move("DOWN");
				logStream.get(e).draw(graphToBack);
			}
			
			//add code to move stuff
			if(keys[0] == true)
			{
				if(raft.getX() >= -10){
					raft.move("LEFT");
				}
			}
			
			if(keys[1] == true)
			{
				if(raft.getX() <= 720){
					raft.move("RIGHT");
				}
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

