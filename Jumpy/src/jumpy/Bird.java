package jumpy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;

public class Bird {
	
	double x,y;
	int xVel;
	double yVel;
	double oy;
	Color color;
	Image img;
	public Bird(int x,int y) {
		try {
			img = new Images().getBird1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		color=getRandom();
		this.x=x;
		this.oy=y;
		this.y=y;
		xVel=2;
		yVel=0.2;
	}
	public void draw(Graphics g,Launcher l) {
		g.drawImage(img,(int)x,(int)y,l);
	}
	public void move()
	{
		if(x<0)
		{
			color=getRandom();
			x=705+getRandomX();
			int tmp=getRandomY();
			oy=tmp;
			y=tmp;
		}
		x=x-xVel;
		y=y+yVel;
		if(y<oy-30)
		{
			yVel=-yVel;
		}
		else if(y>oy+30)
		{
			yVel=-yVel;
		}
	}
	public int getRandomX()
	{
		Random in=new Random();
		return in.nextInt(200);
		
	}
	public int getRandomY()
	{
		Random in=new Random();
		return in.nextInt(220)+20;
	}
	public Color getRandom()
	{
		Random in=new Random();
		int t1=in.nextInt(255);
		int t2=in.nextInt(255);
		int t3=in.nextInt(255);
		return new Color(t1,t2,t3);
	}

}
