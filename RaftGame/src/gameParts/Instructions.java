package gameParts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Instructions extends MovingThing{
	private Image image;
	private int speed;

	public Instructions(){
		this(0, 0, 0);
	}
	
	public Instructions(int x, int y){
		this(x, y, 0);
	}
	
	public Instructions(int x, int y, int s) {
		super(x,y);
		speed = 0;
		try
		{
			image = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\gameParts\\instructions.png"));
		}
		catch(Exception e)
		{
			System.out.println("hi");
		}
	}
	
	public void draw(Graphics window) {
		window.drawImage(image,getX(),getY(),750,992,null);
		
	}
	
	public String toString(){
		return super.toString() + "Speed: " + getSpeed();
	}

	public void setSpeed(int s) {
		speed = s;
	}
	
	public int getSpeed() {
		return speed;
	}
	
}
