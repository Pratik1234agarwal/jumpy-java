package jumpy;

import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Images {
	public static void main(String args[])throws IOException
	{
		JFrame frame =new JFrame ("Image Viewer");
		JPanel panel=new JPanel();
		
		URL url =new Images().url();
		Image image=new Images().getBird1();
		ImageIcon img=new ImageIcon(image);
		JLabel label=new JLabel(img);
		label.setSize(300, 300);
		label.setLocation(20,20);
		panel.add(label);
		panel.setLayout(null);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
	}
	public URL url()
	{
		return this.getClass().getResource("/birdanimated.gif");
	}
	public Image getBackground()throws IOException
	{
		Image image=ImageIO.read(getClass().getResource("/symmback.jpg"));
		Image newimg=image.getScaledInstance(700, 500, Image.SCALE_AREA_AVERAGING);
		return newimg;
	}
	public Image getBird1()throws IOException
	{
		Image image=ImageIO.read(this.url());
		Image newimg=image.getScaledInstance(80, 80 , Image.SCALE_AREA_AVERAGING);
		return newimg;
	}
	public Image getSpike() throws IOException
	{
		Image image=ImageIO.read(getClass().getResource("/spike.png"));
		Image newImage=image.getScaledInstance(20, 40, Image.SCALE_AREA_AVERAGING);
		return newImage;
		
	}
	public Image getTree() throws IOException
	{
		Image image=ImageIO.read(getClass().getResource("/tree.png"));
		Image newImage=image.getScaledInstance(100,200, Image.SCALE_AREA_AVERAGING);
		return newImage;
	}
}
