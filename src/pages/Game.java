package pages;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.JFrame;

import audio.Player;
import game.BufferedImageLoader;
import game.Controller;
import game.GameStat;
import game.MouseInput;
import game.Textures;
import game.keyInput;
import interfaces.Entity1;
import interfaces.Entity2;
import interfaces.EntityA;
import interfaces.EntityB;
import keys.Tecla1;
import keys.TeclaESP;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	public static final int WIDTH=320;
	public static final int HEIGHT = WIDTH/12*9;
	public static final int SCALE =2;
	public final String TITLE="I live for the Funk, I die by the Funk - Biggie";

	private boolean running =false;
	private Thread thread;
	
	private BufferedImage image=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_BGR);
	private BufferedImage spriteSheet=null;
	private BufferedImage backgroundTrack=null;
	private BufferedImage backgroundMenu=null;
	private boolean is_hit=false;

	private Controller c;
	private HighScores highsc;
	private Textures tex;
	private Menu menu;
	private Difficulty level;
	private Pause pause;
	private Help help;
	private EndGame endg;
	private Song song;
	
	public LinkedList<Entity1>e1;
	public LinkedList<EntityA>ea;
	public LinkedList<Entity2>e2;
	public LinkedList<EntityB>eb;
	
	public static enum STATE{MENU, GAME, HELP, PAUSE, LEVEL, ENDG, HIGHSC, SONG};
	public static STATE State=STATE.MENU;
	
	public void init(){
		requestFocus();
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			spriteSheet=loader.loadImage("/Track.png");
			backgroundTrack=loader.loadImage("/BackgroundTrack.png");
			backgroundMenu=loader.loadImage("/BackgroundMenu.png");
		}catch (Exception ex){
			ex.printStackTrace();
		}
		
		tex=new Textures(this);
		c=new Controller(tex, this);
		highsc=new HighScores();
		menu=new Menu();
		song=new Song();
		level=new Difficulty();
		pause=new Pause();
		help=new Help();
		endg=new EndGame();
		
		ea=c.getEntityA();
		e1=c.getEntity1();
		eb=c.getEntityB();
		e2=c.getEntity2();
		
		this.addKeyListener(new keyInput(this));	
		this.addMouseListener(new MouseInput());
		c.Time();
	}
	
	
	public synchronized void start(){
		if(running)
			return;
		
		running=true;
		thread=new Thread (this);
		thread.start();
	}
	
	private synchronized void stop(){
		if(!running)
			return;
		
		running=false;
		try{
			thread.join();
		}catch (Exception ex){
			ex.printStackTrace();
		}
		System.exit(1);
	}
	
	public void run(){
		init();
			
		long lastTime=System.nanoTime();
		final double amountofTicks=60.0;
		double ns=1000000000/amountofTicks;
		double delta=0;
		
		while(running){//Ciclo del Juego
			long now=System.nanoTime();
			delta+=(now-lastTime)/ns;
			lastTime=now;
			
			if(delta>=1){
				tick();
				delta--;
			}		
			render();
		}
		stop();
	}
	
	private void tick(){
		if(State==STATE.GAME){
			c.tick();			
		}
	}
	
	private void render(){
		BufferStrategy bs=this.getBufferStrategy();
		
		if(bs==null){
			createBufferStrategy(3);
			return;
		}
		Graphics g=bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		
		if(State!=STATE.GAME)
			g.drawImage(backgroundMenu, 0, 0, null);
		
		if(State==STATE.GAME){
			g.drawImage(backgroundTrack, 0, 0, null);	
			c.render(g);
		}
		else if(State==STATE.MENU)
			menu.render(g);
		else if(State==STATE.LEVEL)
			level.render(g);
		else if(State==STATE.HELP)
			help.render(g);
		else if(State==STATE.PAUSE)
			pause.render(g);
		else if(State==STATE.ENDG)
			endg.render(g);
		else if(State==STATE.SONG)
			song.render(g);
		else if(State==STATE.HIGHSC)
			highsc.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public void keyPressed(KeyEvent e){
		int key=e.getKeyCode();
		if(State==STATE.GAME){
			int y=300, x=0;
			if(key==KeyEvent.VK_1 || key==KeyEvent.VK_2 || key==KeyEvent.VK_3 || key==KeyEvent.VK_4){
				if(key==KeyEvent.VK_1 && !is_hit){
					x=100;
				}
				else if(key==KeyEvent.VK_2 && !is_hit){
					x=150;
				}
				else if(key==KeyEvent.VK_3 && !is_hit){
					x=200;	
				}
				else if(key==KeyEvent.VK_4 && !is_hit){
					x=250;
				}
				is_hit=true;
				if(GameStat.keep>=3)
					c.addEntity(new Tecla1(x, y, tex, c , this));	
			}
			else if(key==KeyEvent.VK_SPACE && !is_hit){
				is_hit=true;
				if(GameStat.keep>=3)
					c.addEntity(new TeclaESP(130, y, tex, c, this));
			}
			else if((key==KeyEvent.VK_P  || key==KeyEvent.VK_ESCAPE) && !is_hit){
				is_hit=true;
				Game.State=Game.STATE.PAUSE;
				Player.pauseSong();
			}
		}
		if(State==STATE.PAUSE  && key==KeyEvent.VK_P && !is_hit){
			is_hit=true;
			Game.State=Game.STATE.GAME;
			GameStat.keep=0;
			//Player.player.play();
		}
		if(State==STATE.PAUSE  && key==KeyEvent.VK_ESCAPE && !is_hit){
			is_hit=true;
			Game.State=Game.STATE.GAME;
			GameStat.setEnd(1);
			GameStat.setEStat(2);
			try{Thread.sleep(50);}catch(Exception ex){}
			Game.State=Game.STATE.ENDG;
			Player.player.close();
		}
		if((State==STATE.HELP || State==STATE.HIGHSC || State==STATE.SONG)  && key==KeyEvent.VK_ESCAPE && !is_hit){
			is_hit=true;
			Game.State=Game.STATE.MENU;
		}
		if(State==STATE.LEVEL && key==KeyEvent.VK_ESCAPE && !is_hit ){
			is_hit=true;
			Game.State=Game.STATE.SONG;
		}
		if(State==STATE.ENDG  && key==KeyEvent.VK_ESCAPE && !is_hit){
			is_hit=true;
			GameStat.i=0;
			GameStat.setScore(0);
			GameStat.setEnd(1);
			GameStat.setStatus(50);
			try{Thread.sleep(5);}catch(Exception ex){}
			Game.State=Game.STATE.MENU;
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_1 || key==KeyEvent.VK_2 || key==KeyEvent.VK_3 || key==KeyEvent.VK_4
				|| key==KeyEvent.VK_SPACE ||key==KeyEvent.VK_ESCAPE || key==KeyEvent.VK_P ){
			is_hit=false;
		}
	}
	
	public BufferedImage getSpriteSheet(){
		return spriteSheet;
	}	
	
	public static void main(String []args){
		Game game=new Game();
		game.setPreferredSize(new Dimension(WIDTH * SCALE,HEIGHT*SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE,HEIGHT*SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE,HEIGHT*SCALE));
		
		JFrame frame= new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}
}
