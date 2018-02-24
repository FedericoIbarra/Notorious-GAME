package keys;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Controller;
import game.GameStat;
import game.Physics;
import game.Textures;
import interfaces.EntityB;
import pages.Game;

public class TeclaESP implements EntityB{
	
	private double x, y;
	private Textures tex;
	private Game game;
	private Controller c;
	
	public TeclaESP(double x, double y, Textures tex, Controller c, Game game){
		this.x=x;
		this.y=y;
		this.tex=tex;
		this.c=c;
		this.game=game;
	}
	
	public void tick(){
		if(!Physics.Collision(this, game.e2)){
			c.removeEntity(this);
			GameStat.setStatus(GameStat.getStatus()-GameStat.getSDif());
		}
	}
	
	public void render(Graphics g){
		g.drawImage(tex.TeclaESP, (int)x, (int)y, null);
	}
	
	public double getY(){
		return y;
	}
	
	public void setY(double y){
		this.y=y;
	}

	public double getX() {
		return x;
	}
	public Rectangle getBounds(){
		return new Rectangle ((int)x, (int)y,128, 32);
	}
}
