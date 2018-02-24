package track;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Controller;
import game.GameStat;
import game.Physics;
import game.Textures;
import interfaces.Entity2;
import pages.Game;

public class TrackESP implements Entity2{
	
	public double x, y;
	protected Textures tex;
	protected Game game;
	protected Controller c;
	private int statusdif=0;
	
	public TrackESP(double x, double y, Textures tex, Controller c, Game game){
			this.y=y;
			this.x=x;
			this.tex=tex;
			this.c=c;
			this.game=game;
			statusdif=(GameStat.getSDif()==1)?2:(GameStat.getSDif()==2)?3:4;
	}
	
	public void tick(){
		y+=GameStat.getDifficulty();
		x=130;
		if(y==280)
			System.out.println("check");
		if(y>(Game.HEIGHT*Game.SCALE)){
			c.removeEntity(this);
			GameStat.setStatus(GameStat.getStatus()-GameStat.getSDif());
		}
		if(Physics.Collision(this, game.eb)||GameStat.getEnd()==1){
			c.removeEntity(this);
			if(GameStat.getEnd()!=1){
				GameStat.setScore(GameStat.getScore()+2);
				GameStat.setStatus(GameStat.getStatus()+statusdif);
			}
		}
	}
	
	public void render(Graphics g){
		if(GameStat.getStatus()!=-1){
			g.drawImage(tex.TrackESP, (int)x, (int)y, null);
		}
	}
	
	public Rectangle getBounds(){
		return new Rectangle ((int)x, (int)y,128, 32);
	}
}
