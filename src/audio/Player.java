package audio;
import processing.core.*;

import javax.swing.JFrame;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;

public class Player extends PApplet implements Runnable{
	
	private static Minim minim;
	public static AudioPlayer player;

	public static void main(){
		(new Thread(new Player())).start();
		PApplet.main(Player.class.getName());
	}
	
	public void settings(){
		//size(100,100);
	}

	public void setup(){
		surface.setVisible(false);
		minim = new Minim(this);
		player = minim.loadFile(game.GameStat.path);
		player.play();
	}
	
	public void draw(){}
	
	public void stop() {
		player.close();
		minim.stop();
		super.stop();
	}

	public void keyPressed(){
		
		this.frame.setExtendedState(JFrame.ICONIFIED);  // Minimize window
	 
	}

	public void run(){
	}
	
	public static void pauseSong(){
		player.pause();
	}
	
	public static void playSong(){
		player.play();
	}
	
}
