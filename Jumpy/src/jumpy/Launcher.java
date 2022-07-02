package jumpy;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;

/*import jumpyBird;
import jumpy.Human;
import jumpy.Obstacles;
import jumpy.Score;
*/
public class Launcher extends Canvas implements Runnable,KeyListener{
	
	Human human ;
	Image img;
	Graphics gfx;
	Score sc;
	Obstacles ob1,ob2,ob3;
	Bird b1,b2,b3;
	Image background;
	BackGround back;
	boolean started,pause;
	Tree tree;
	Launcher()
	{
		tree=new Tree();
		back=new BackGround();
		try {
			background=new Images().getBackground();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		started=false;
		pause=false;
		ob1=new Obstacles(550,Color.blue);
		ob2=new Obstacles(650,Color.red);
		ob3=new Obstacles(100,Color.yellow);
		b1=new Bird(600,50);
		b2=new Bird(200,150);
		b3=new Bird(350,350);
		sc=new Score();
		human=new Human();
		
		Thread thread =new Thread(this);
		thread.start();
	}
	
	public static void main(String args[])
	{
		Launcher launcher =new Launcher();
		launcher.draw();
	}
	public void draw()
	{
		JFrame frame =new JFrame("Jumpy");
		Canvas canvas =this;
		canvas.setSize(700,500);
		frame.setSize(700,550);
		canvas.addKeyListener(this);
		frame.add(canvas);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public void paint(Graphics g)
	{
		img = createImage(700,500);
		gfx=img.getGraphics();
		/*gfx.setColor(new Color(56,7,3));
		gfx.fillRect(0, 0, 700,500);*/
		//gfx.drawImage(background,0,0,this);
		if(started && !pause) {
			back.draw(gfx, this);
			tree.draw(gfx, this);
			human.draw(gfx);
			sc.draw(gfx);
			ob1.draw(gfx,this);
			ob2.draw(gfx,this);
			ob3.draw(gfx,this);
			b1.draw(gfx,this);
			b2.draw(gfx,this);
			b3.draw(gfx,this);
			
		}
		else if(pause)
		{
			gfx.drawImage(background,0,0,this);
			gfx.setColor(Color.red);
			gfx.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
			gfx.drawString("Game Over", 200,250);
			sc.draw(gfx);
		}
		else
		{
			gfx.drawImage(background,0,0,this);
			gfx.setColor(Color.green);
			gfx.setFont(new Font("Georgia",Font.BOLD,20));
			gfx.drawString("Press Enter to start",250,250);
		}
		g.drawImage(img, 0, 0,this);
		
	}
	public void update(Graphics g)
	{
		paint(g);
	}

	@Override
	public void run() {
		while(true)
		{
			
			if(started && !pause) {
				repaint();
				human.move();
				ob1.move();
				ob2.move();
				ob3.move();
				b1.move();
				b2.move();
				b3.move();
				back.move();
				tree.move();
				if(!pause)
				pause=ob1.checkCollision(human.getY());
				if(!pause)
				pause=ob2.checkCollision(human.getY());
				if(!pause)
				pause=ob3.checkCollision(human.getY());
			}
			
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int t=e.getKeyCode();
		if(t==KeyEvent.VK_UP || t==KeyEvent.VK_SPACE)
		{
			human.jump();
		}
		else if(t==KeyEvent.VK_ENTER)
		{
			started=true;
		}
		else if(t==KeyEvent.VK_ESCAPE)
		{
			System.exit(ABORT);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
