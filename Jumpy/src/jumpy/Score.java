package jumpy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score {
	static int score=0;
	
	public void draw(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(270, 10, 150, 20);
		g.setColor(Color.blue);
		g.setFont(new Font("Georgia",Font.BOLD,20));
		g.drawString("Score : "+score, 300,25);
	}

}
