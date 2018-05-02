package gameParts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Raft extends MovingThing{
	private int speed;
	private Image image;

	public Raft(){
		this(300, 800, 2);
	}
	
	public Raft(int x, int y){
		this(x, y, 2);
	}
	
	public Raft(int x, int y, int s) {
		super(x,y);
		speed = s;
		
		try
		{
			image = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\gameParts\\raft.png"));
		}
		catch(Exception e)
		{
			System.out.println("hi");
		}
	}

	public void setSpeed(int s) {
		speed = s;
		
	}

	public int getSpeed() {
		return speed;
	}
	
	public void draw(Graphics window) {
		window.drawImage(image,getX(),getY(),100,100,null);
		
	}
	
	public String toString(){
		return super.toString() + "Speed: " + getSpeed();
	}
	
}
