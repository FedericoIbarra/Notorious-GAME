package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import audio.Player;
import highscore.TabladeRegistros;
import interfaces.Entity1;
import interfaces.Entity2;
import interfaces.EntityA;
import interfaces.EntityB;
import pages.Game;
import pages.Game.STATE;
import track.Track1;
import track.TrackESP;


public class Controller {
	private LinkedList<EntityA> ea=new LinkedList<EntityA>();
	private LinkedList<Entity1> e1=new LinkedList<Entity1>();
	private LinkedList<EntityB> eb=new LinkedList<EntityB>();
	private LinkedList<Entity2> e2=new LinkedList<Entity2>();
	public Rectangle pauseButton=new Rectangle(450, 400, 300, 50);
	TabladeRegistros h=new TabladeRegistros();
	
	public static Timer timer =new Timer();
	public static Timer timert =new Timer();
	private Game game;
	
	EntityA enta;
	Entity1 en1;
	EntityB entb;
	Entity2 en2;
	
	Textures tex;
	
	TimerTask task = new TimerTask(){
		public void run(){
			createTrack();
		}
	};
	
	TimerTask taskt = new TimerTask(){
		public void run(){
			GameStat.keep++;
			GameStat.position++;
		}
	};
	
	public void Time(){
		timer.scheduleAtFixedRate(task, 0, 333);
		timert.scheduleAtFixedRate(taskt, 0, 1000);
	}
	
	public Controller(Textures tex, Game game){
		this.tex=tex;
		this.game=game;
	}
	
	public void createTrack(){//Crea las pistas
		if(Game.State==STATE.GAME && GameStat.keep>=4){
			GameStat.lenght=Player.player.length()/1000;
			switch((GameStat.position<=(GameStat.lenght)-1)?GameStat.getValue():5){
				case 0:
					addEntity(new Track1(100, -10, tex, this, game, GameStat.getValue()));
					break;
				case 1:
					addEntity(new Track1(150, -10, tex, this, game, GameStat.getValue()));
					break;
				case 2:
					addEntity(new Track1(200, -10, tex, this, game, GameStat.getValue()));
					break;
				case 3:
					addEntity(new Track1(250, -10, tex, this, game, GameStat.getValue()));
					break;
				case 4:
					addEntity(new TrackESP(120, -10, tex, this, game));
					break;
				default:
					break;
				}
			
			if(GameStat.getStatus()<=0){
				Game.State=Game.STATE.GAME;
				GameStat.setEnd(1);
				GameStat.setEStat(1);
				h.AgregarPuntuacion("Prueba", GameStat.getNameSong(), GameStat.getScore());
				try{Thread.sleep(50);}catch(Exception ex){}
				Game.State=Game.STATE.ENDG;
				Player.player.close();
			}
			
			if(((GameStat.position)==(GameStat.lenght+3)) && GameStat.getEnd()!=1){
				Game.State=Game.STATE.GAME;
				GameStat.setEnd(1);
				h.AgregarPuntuacion("pasamos todo", GameStat.getNameSong(), GameStat.getScore());
				GameStat.setEStat(0);
				try{Thread.sleep(50);}catch(Exception ex){}
				Game.State=Game.STATE.ENDG;
				Player.player.close();
			}
			
			if(GameStat.keep>=3)
				Player.player.play();
			
			GameStat.i++;
		}
	}

	public void tick(){
		for(int i=0; i<ea.size(); i++){
			enta=ea.get(i);
			enta.tick();
		}
		for(int i=0; i<e1.size(); i++){
			en1=e1.get(i);
			en1.tick();
		}
		for(int i=0; i<eb.size(); i++){
			entb=eb.get(i);
			entb.tick();
		}
		for(int i=0; i<e2.size(); i++){
			en2=e2.get(i);
			en2.tick();
		}
	}
	
	public void render (Graphics g){
		if(GameStat.getEnd()==0){
			Font fnt1 = new Font("arial", Font.PLAIN, 30 );
			g.setFont(fnt1);
			
			g.setColor(Color.black);
			g.drawString("Score: "+GameStat.getScore(), 460, 100);
			
			g.setColor(Color.black);
			g.drawString("Status: "+GameStat.getStatus(), 460, 150);
			
			g.setColor(Color.yellow);
			g.drawString("PAUSE", pauseButton.x+17, pauseButton.y+32);
			
			Font fnt2 = new Font("arial", Font.BOLD, 50 );
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString((GameStat.keep>0 && GameStat.keep<3)?"  "+GameStat.keep:
				(GameStat.keep>=3&&GameStat.keep<=4)?"GO! ":"", 160, 250);
			
		}
		for(int i=0; i<ea.size(); i++){
			enta=ea.get(i);
			enta.render(g);
		}
		for(int i=0; i<e1.size(); i++){
			en1=e1.get(i);
			en1.render(g);
		}
		for(int i=0; i<eb.size(); i++){
			entb=eb.get(i);
			entb.render(g);
		}
		for(int i=0; i<e2.size(); i++){
			en2=e2.get(i);
			en2.render(g);
		}	
	}
	
	///////////////Tecla N�meros//////////////
	public void addEntity(EntityA block){
		ea.add(block);
	}
	public void removeEntity(EntityA block){
		ea.remove(block);
	}
	public LinkedList<EntityA>getEntityA(){
		return ea;
	}
	//////**********************************/////////////////
	public void addEntity(Entity1 block){
		e1.add(block);
	}
	public void removeEntity(Entity1 block){
		e1.remove(block);
	}
	public LinkedList<Entity1>getEntity1(){
		return e1;
	}
	///////////////Tecla Espacio//////////////
	public void addEntity(EntityB block){
		eb.add(block);
	}
	public void removeEntity(EntityB block){
		eb.remove(block);
	}
	public LinkedList<EntityB>getEntityB(){
		return eb;
	}
	//////**********************************/////////////////
	public void addEntity(Entity2 block){
		e2.add(block);
	}
	public void removeEntity(Entity2 block){
		e2.remove(block);
	}
	public LinkedList<Entity2>getEntity2(){
		return e2;
	}
	
}
