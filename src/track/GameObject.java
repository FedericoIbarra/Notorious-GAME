package track;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Controller;
import game.Textures;
import pages.Game;

public abstract class GameObject {

	public double x, y;
	protected Textures tex;
	protected Game game;
	protected Controller c;

	public double getY(){
		return y;
	}

	public double getX() {
		return x;
	}
	
	public void setData(double x, double y, Textures tex, Controller c, Game game){
		this.y=y;
		this.x=x;
		this.tex=tex;
		this.c=c;
		this.game=game;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
}
