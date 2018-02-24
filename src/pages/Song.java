package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Song {

	public Rectangle returnButton=new Rectangle(450, 400, 300, 50);
	
	public void render(Graphics g){
		
		Font fnt0 = new Font("arial", Font.BOLD, 50 );
		g.setFont(fnt0);
		g.setColor(Color.orange);
		g.drawString("SELECT SONG", Game.WIDTH/2, 50);
		
		Font fnt1 = new Font("arial", Font.PLAIN, 30 );
		g.setFont(fnt1);
		
		g.drawString("SELECT", 60, 300);
		g.drawString("DIFFICULTY", 260, 300);
		
		g.setColor(Color.yellow);
		g.drawString("SONG CHOSEN:", 40, 150);
		g.setColor(Color.lightGray);
		g.drawString("XXXXXXXX", 40, 200);
		
		g.setColor(Color.white);
		g.drawString("RETURN", returnButton.x+17, returnButton.y+32);		
	}
}
