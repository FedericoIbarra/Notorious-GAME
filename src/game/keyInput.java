package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import pages.Game;

public class keyInput extends KeyAdapter{
	
	Game game;

	public keyInput (Game game){
		this.game=game;
		
	}
	public void keyPressed(KeyEvent e){
		game.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e){
		game.keyReleased(e);
	}
}
