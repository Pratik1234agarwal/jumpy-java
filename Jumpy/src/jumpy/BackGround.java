package jumpy;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

public class BackGround {
	
	Image img;
	int x,y;
	int xVel;
	public BackGround()
	{
		try {
			img=new Images().getBackground();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		x=0;
		y=0;
		xVel=2;
		
		
	}
	public void move()
	{
		if(x<-736)
		{
			x=0;
		}
		x=x-xVel;
	}
	public void draw(Graphics g,Launcher l)
	{
		g.drawImage(img, x, y,l);
		g.drawImage(img, x+736,y,l);
		
	}

}
