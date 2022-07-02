package jumpy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;
public class Obstacles {
	double x,y;
	double xVel;
	Color color;
	Image img;
	public Obstacles(int x,Color color)
	{
		this.x=x;
		y=450;
		xVel=2;
		try {
			img=new Images().getSpike();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.color=color;
	}

	public void move()
	{
		if(x<0)
		{
			color=getRandom();
			x=700+getRandomX();
		}
		x=x-xVel;
	}
	
	public boolean checkCollision(int hy)
	{
		if(x==198 || x==199)
		{
			Score.score++;
		}
		if(x>=200 && x<=210)
		{
			if(hy>y)
			{
				return true;
			}
		}
		return false;
		
	}
	
	public void draw(Graphics g,Launcher l)
	{
		g.drawImage(img,(int)x-3,(int)y-3,l);
		//g.fillRect((int)x, (int)y, 10, 30);
	}
	public Color getRandom()
	{
		Random in=new Random();
		int t1=in.nextInt(255);
		int t2=in.nextInt(255);
		int t3=in.nextInt(255);
		return new Color(t1,t2,t3);
	}
	public int getRandomX()
	{
		Random in=new Random();
		return in.nextInt(200);
	}
}
