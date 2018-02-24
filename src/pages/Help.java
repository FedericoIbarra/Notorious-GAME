package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Help{

	public Rectangle returnButton=new Rectangle(450, 400, 300, 50);
	
	public void render(Graphics g){
		
		Font fnt0 = new Font("arial", Font.BOLD, 50 );
		g.setFont(fnt0);
		g.setColor(Color.orange);
		g.drawString("CONTROLS", Game.WIDTH/2, 50);
		
		Font fnt1 = new Font("arial", Font.PLAIN, 30 );
		g.setFont(fnt1);
		
		g.setColor(Color.green);
		g.drawString("1: GREEN TRACK", Game.WIDTH/2, 100);
		g.setColor(Color.red);
		g.drawString("2: RED TRACK", Game.WIDTH/2, 150);
		g.setColor(Color.orange);
		g.drawString("3: ORANGE TRACK", Game.WIDTH/2, 200);
		g.setColor(Color.blue);
		g.drawString("4: BLUE TRACK", Game.WIDTH/2, 250);
		g.setColor(Color.black);
		g.drawString("SPACE: BLACK TRACK", Game.WIDTH/2, 300);
		g.setColor(Color.yellow);
		g.drawString("P: PAUSE", Game.WIDTH/2, 370);
		g.drawString("ESC: RETURN", Game.WIDTH/2, 430);
		
		g.setColor(Color.white);
		g.drawString("RETURN", returnButton.x+17, returnButton.y+32);		
	}
	
}
