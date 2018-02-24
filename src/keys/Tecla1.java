package keys;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Controller;
import game.GameStat;
import game.Physics;
import game.Textures;
import interfaces.EntityA;
import pages.Game;


public class Tecla1 implements EntityA{
	//Atributos para utilzar teclado en juego (1,2,3,4)
	private double x, y;//Coordenada de posición
	private Textures tex;//Permite utilizar texturas (imágenes)
	private Game game;//Utiliza elementos del juego
	private Controller c;//Crea 
	
	public Tecla1(double x, double y, Textures tex, Controller c, Game game){
		this.x=x;
		this.y=y;
		this.tex=tex;
		this.c=c;
		this.game=game;
	}

	public void tick(){
		if(!Physics.Collision(this, game.e1)){
			c.removeEntity(this);
			GameStat.setStatus(GameStat.getStatus()-GameStat.getSDif());
		}
	}
	
	public void render(Graphics g){
		g.drawImage(tex.Tecla1, (int)x, (int)y, null);
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
		return new Rectangle ((int)x, (int)y,32, 32);
	}
}
