package track;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Controller;
import game.GameStat;
import game.Physics;
import game.Textures;
import interfaces.Entity1;
import pages.Game;


public class Track1 extends GameObject implements Entity1{

	private int statusdif;
	private int place;
	
	public Track1(double x, double y, Textures tex, Controller c, Game game, int place){
		super.setData(x, y, tex, c, game);
		this.place=place;
		this.x=x;
		statusdif=(GameStat.getSDif()==1)?2:(GameStat.getSDif()==2)?3:4;
	}
	
	public void tick(){
		y+=GameStat.getDifficulty();
		if(y==280)
			System.out.println("check");
		if(y>(Game.HEIGHT*Game.SCALE)){
			c.removeEntity(this);
			GameStat.setStatus(GameStat.getStatus()-GameStat.getSDif());
		}
		if(Physics.Collision(this, game.ea)||GameStat.getEnd()==1){
			c.removeEntity(this);
			if(GameStat.getEnd()!=1){
				GameStat.setScore(GameStat.getScore()+2);
				GameStat.setStatus(GameStat.getStatus()+statusdif);
			}
		}
	}
	
	public void render(Graphics g){
		if(GameStat.getStatus()!=-1){
			if(place==0)
				g.drawImage(tex.Track1, (int)x, (int)y, null);
			else if(place==1)
				g.drawImage(tex.Track2, (int)x, (int)y, null);
			else if(place==2)
				g.drawImage(tex.Track3, (int)x, (int)y, null);
			else if(place==3)
				g.drawImage(tex.Track4, (int)x, (int)y, null);
		}
	}
	
	public Rectangle getBounds(){		
		return new Rectangle ((int)x, (int)y,32, 32);
	}

}
