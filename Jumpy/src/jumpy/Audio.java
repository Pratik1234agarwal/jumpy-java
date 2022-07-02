package jumpy;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
	
		AudioInputStream in;
		Clip clip;
		volatile boolean ended;
		long length;
		
		Runnable controller=new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(length);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ended=true;
			}
			
		};
		
		Runnable play=new Runnable() {
			public void run()
			{
				clip.start();
				while(!ended) {
				
				}
				clip.stop();
			}
		};
		
        public Audio(URL url)
        {
        	ended=false;
        	
        	try {
				in=AudioSystem.getAudioInputStream(url);
				
				
			} catch (UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	try {
				clip=AudioSystem.getClip();
				try {
					clip.open(in);
					length=clip.getMicrosecondLength()/1000+200;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	new Thread(play).start();
        	new Thread(controller).start();
        	
        }
        
        public static void main(String args[])
        {
        	URL url=Audio.class.getResource("/jump.wav");
        	Audio audio=new Audio(url);
        }

}
