package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.GameStat;

public class EndGame{

	public Rectangle returnButton=new Rectangle(450, 400, 300, 50);
	
	public void render(Graphics g){
		
		Font fnt0 = new Font("arial", Font.BOLD, 80 );
		g.setFont(fnt0);
		g.setColor(Color.yellow);
		g.drawString("GAME OVER", 100, 150);
		
		Font fnt1 = new Font("arial", Font.PLAIN, 40 );
		g.setFont(fnt1);
		
		g.setColor(Color.orange);
		g.drawString("STATUS: "+((GameStat.getStatus()<0)?0:GameStat.getStatus()), Game.WIDTH/2, 250);
		g.drawString("SCORE: "+GameStat.getScore(), Game.WIDTH/2, 300);
		g.drawString("SONG", Game.WIDTH/2, 450);
		
		g.setColor(Color.white);
		g.drawString("RETURN", returnButton.x+17, returnButton.y+38);	
		
		Font fnt2 = new Font("arial", Font.BOLD, 50 );
		g.setFont(fnt2);
		
		if(GameStat.getEStat()==1){
			g.setColor(Color.red);
			g.drawString("PUNK ASS LOSER", Game.WIDTH/2, 400);
		}
		else if(GameStat.getEStat()==0){
			g.setColor(Color.cyan);
			g.drawString("WINNER", Game.WIDTH/2, 400);
		}
		else{
			g.setColor(Color.LIGHT_GRAY);
			g.drawString("QUITTER", Game.WIDTH/2, 400);
		}	
	}
	
}

