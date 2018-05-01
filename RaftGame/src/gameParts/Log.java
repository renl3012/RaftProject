package gameParts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Log extends MovingThing{

	private int speed;
	private Image image;
	
	private Log[][] stream;
	
	public Log()
	{
		this(0,0,0);
	}

	public Log(int x, int y)
	{
		this(x,y,0);
	}

	public Log(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\gameParts\\log.png"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("hi");
		}
	}

	public void setSpeed(int s)
	{
	   //add code
		speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}
	
	public void invisible(Graphics window )
	{
		window.drawImage(null, getX(), getY(), 80, 80, null);
	}

	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),80,80,null);
	}

	public String toString()
	{
		return super.toString() + "Speed: " + getSpeed();
	}
}
