package jumpy;

import java.awt.Color;
import java.awt.Graphics;

public class Human {
	double x,y;
	double xVel,yVel;
	public Human()
	{
		y=440;
		x=200;
		xVel=0;
	}
	public void jump()
	{
		yVel=2;
	}
	public void move()
	{
		if(y<=395)
		{
			yVel=-yVel;
		}
		y=y-yVel;
		if(y==440)
		{
			yVel=0;
		}
	}
	public int getY()
	{
		return (int)y+40;
	}
	public void draw(Graphics g)
	{
		g.setColor(new Color(255,225,168));
		g.fillRect((int)x, (int)y, 10, 30);
		g.fillRect((int)x+2, (int)y+30, 2, 10);
		g.fillRect((int)x+6, (int)y+30, 2, 10);
		g.fillOval((int)x-5, (int)(y-20), 20, 20);
	}
	

}
