package game;

import java.awt.image.BufferedImage;

import pages.Game;

public class Textures {
	
	public BufferedImage Track1,Track2,Track3,Track4,TrackESP;
	public BufferedImage Tecla1,Tecla2,Tecla3,Tecla4,TeclaESP;
	
	private SpriteSheet ss;
	
	public Textures(Game game){
		
		ss= new SpriteSheet(game.getSpriteSheet());
		getTextures();
		
	}
	
	private void getTextures(){
		//x,y,sizex,sizey
		Track1=ss.grabImage(1, 1, 32, 32);
		Track2=ss.grabImage(2, 1, 32, 32);
		Track3=ss.grabImage(3, 1, 32, 32);
		Track4=ss.grabImage(4, 1, 32, 32);
		TrackESP=ss.grabImage(1, 3, 128, 32);
		
		Tecla1=ss.grabImage(1, 2, 32, 32);
		Tecla2=ss.grabImage(2, 2, 32, 32);
		Tecla3=ss.grabImage(3, 2, 32, 32);
		Tecla4=ss.grabImage(4, 2, 32, 32);
		TeclaESP=ss.grabImage(1, 3, 128, 32);
	}
	
}
