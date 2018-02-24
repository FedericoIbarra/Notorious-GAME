package audio;
import javax.swing.JFrame;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import game.GameStat;
import processing.core.PApplet;


public class AudioProcessor extends PApplet implements Runnable{
	
	private Minim minim;
	private static  AudioPlayer player;
	private FFT fft;
	private float lenght=0;
	
	public static void main(){
		(new Thread(new AudioProcessor())).start();
		PApplet.main(AudioProcessor.class.getName());
	}
	
	public static Boolean isRunning(){
		if(player.isPlaying()) return true;
		return false;
	}
	
	
	public void settings(){
	}

	public void setup(){
		surface.setVisible(false);
		minim = new Minim(this);
		player = minim.loadFile(game.GameStat.path);
		fft = new FFT( player.bufferSize(), player.sampleRate() );
		player.play();
	}
	
	
	public void draw()
	{
		this.frame.setExtendedState(JFrame.ICONIFIED);  // Minimize window
		player.mute();
		fft.forward(player.left);
		lenght=(fft.getFreq(GameStat.i)>10)?(fft.getFreq(GameStat.i)/10):
			(fft.getFreq(GameStat.i)>100)?(fft.getFreq(GameStat.i)/100):fft.getFreq(GameStat.i);
		
		if((GameStat.position<=(GameStat.lenght-1)) && Player.player.isPlaying()){
			if((lenght) > -1 && (lenght) < 2) {
				 GameStat.setValue(0);
			 }
			 else if((lenght) > 2 && (lenght) < 4){
				 GameStat.setValue(1);
			 }
			 else if((lenght) > 4 && (lenght) < 6){
				 GameStat.setValue(2);
			 }
			 else if((lenght) > 6 && (lenght) < 8){
				 GameStat.setValue(3);
			 }
			 else if((lenght) > 8 && (lenght) < 9){
				 GameStat.setValue(4);
			 }
			 else{
				 GameStat.setValue(5);
			 }
		}
	}
	
	public void stop(){
		
		player.close();
		minim.stop();
		super.stop();
	}

	public void run() {
		
	}
	
	

	
}

