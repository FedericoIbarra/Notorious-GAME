package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Difficulty {
	public void render(Graphics g){
	
		Font fnt0 = new Font("arial", Font.BOLD, 50 );
		g.setFont(fnt0);
		g.setColor(Color.orange);
		g.drawString("  DIFFICULTY ", Game.WIDTH/2, 100);
		
		Font fnt1 = new Font("arial", Font.PLAIN, 30 );
		g.setFont(fnt1);
		g.setColor(Color.yellow);
		g.drawString("EASY", 300, 230);		
		g.drawString("MEDIUM", 285, 330);
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("HARD", 300, 430);
		
		g.setColor(Color.white);
		g.drawString("RETURN", 500, 450);
	}
}
