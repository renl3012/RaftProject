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
	private Log currentLog;
	private Log partnerLog;
	private int randX;
	private int otherRandX;
	private int lives;
	private int score;
	private boolean freeze;
	
	private ManyLogs send;
	private Log[][] transfer;

	
	public Downstream(){
		raft = new Raft();
		keys = new boolean[2];
		lives = 3;
		score = 0;
		
		send = new ManyLogs();
		transfer = new Log[5][2];
		transfer = send.getLogs();
		
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}
	
	public void intro(Graphics window){
		Graphics2D twoDGraph = (Graphics2D)window;


		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));


		Graphics graphToBack = back.createGraphics();
		
		graphToBack.setColor(Color.BLACK);
		graphToBack.drawRect(0, 0, 750, 992);
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
			graphToBack.setColor(Color.YELLOW);
			graphToBack.drawString("LIVES: " + lives, 50, 50);
			graphToBack.drawString("SCORE: " + score, 650, 50); 
			
			//********don't change the lines above this*********
			
			raft.draw(graphToBack);
			
			//for(int e = 0; e < 10; e++){
			for(int a = 0; a < 5; a++){
				currentLog = transfer[a][0];
				partnerLog = transfer[a][1];
				currentLog.move("DOWN");
				partnerLog.move("DOWN");
				currentLog.draw(graphToBack);
				partnerLog.draw(graphToBack);
				
				//Work on this section a lot
				if(currentLog.getY() + 50 >= raft.getY() && currentLog.getY() + 50 <= raft.getY() + 100){
					if((currentLog.getX() >= raft.getX() && currentLog.getX() <= raft.getX() + 60)||(currentLog.getX()+125 >= raft.getX() && currentLog.getX()+125 <= raft.getX()+60)){
						lives -= 1;
						graphToBack.setColor(Color.YELLOW);
						graphToBack.drawString("LIVES: " + lives, 50, 50);
					}
				}
				
				if(partnerLog.getY() + 50 >= raft.getY() && partnerLog.getY() + 50 <= raft.getY() + 100){
					if(partnerLog.getX() >= raft.getX() && partnerLog.getX() <= raft.getX() + 100){
						lives -= 1;
						graphToBack.setColor(Color.YELLOW);
						graphToBack.drawString("LIVES: " + lives, 50, 50);
					}
				}
				
				if(currentLog.getY() >= 1000){
					currentLog.setY(-200);
					randX = (int)(Math.random() * 450);
					currentLog.setX(randX);
				}
				
				//Change this part a lot too
				if(partnerLog.getY() >= 1000){
					partnerLog.setY(-200);
					otherRandX = (int)((Math.random() * 50)+250);
					partnerLog.setX(randX);
				}
			}	
			
			if(score == -1){
				graphToBack.setColor(Color.BLACK);
				graphToBack.drawString("GAME OVER", 300, 500);
			}
			
			if(keys[0] == true)
			{
				if(raft.getX() >= 0){
					raft.move("LEFT");
				}
			}
			
			if(keys[1] == true)
			{
				if(raft.getX() <= 650){
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

