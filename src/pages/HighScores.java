package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HighScores {

public Rectangle returnButton=new Rectangle(450, 400, 300, 50);
		
	public void render(Graphics g){
		//TabladeRegistros h=new TabladeRegistros();
		Font fnt0 = new Font("arial", Font.BOLD, 50 );
		g.setFont(fnt0);
		g.setColor(Color.orange);
		g.drawString("HIGHSCORES", Game.WIDTH/2, 50);
		
		Font fnt1 = new Font("arial", Font.PLAIN, 30 );
		g.setFont(fnt1);
		
		g.setColor(Color.yellow);
		//g.drawString("1.-"+h.mostrar(1), 20, 150);
		g.setColor(Color.lightGray);
		//g.drawString("2.-"+h.mostrar(2), 20, 200);
		//g.drawString("3.-"+h.mostrar(3), 20, 250);
		//g.drawString("4.-"+h.mostrar(4), 20, 300);
		//g.drawString("5.-"+h.mostrar(5), 20, 350);
		
		g.setColor(Color.white);
		g.drawString("RETURN", returnButton.x+17, returnButton.y+32);		
	}
}
