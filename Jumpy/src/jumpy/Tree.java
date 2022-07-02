package jumpy;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;

public class Tree {
	
	Image img;
	int x,y;
	int vVel=0;
	public Tree()
	{
		try {
			img=new Images().getTree();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		x=550;
		y=240;
		vVel=1;
	}
	public void draw(Graphics g,Launcher l)
	{
		g.drawImage(img, x, y, l);
	}
	public void move()
	{
		x=x-vVel;
		if(x<-20)
		{
			x=getRandom();
		}
	}
	private int getRandom() {
		Random rand=new Random();
		return rand.nextInt(500)+500;
	}

}
