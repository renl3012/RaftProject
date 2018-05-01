package gameParts;
import javax.swing.JFrame;
import java.awt.Component;
import java.awt.Graphics;

public class River extends JFrame
{
	private static final int WIDTH = 750;
	private static final int HEIGHT = 991;

	public River()
	{
		super("RAFTING");
		setSize(WIDTH,HEIGHT);

		Downstream theGame = new Downstream();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		River run = new River();
		
	}
}