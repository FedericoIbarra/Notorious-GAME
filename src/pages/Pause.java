package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pause {
public Rectangle returnButton=new Rectangle(220, 230, 300, 50);
public Rectangle quitButton=new Rectangle(210, 330, 300, 50);
	
	public void render(Graphics g){
		
		Font fnt0 = new Font("arial", Font.PLAIN, 30 );
		g.setFont(fnt0);
		g.setColor(Color.orange);
		g.drawString("PAUSE", 275, 100);
		
		Font fnt1 = new Font("arial", Font.BOLD, 50 );
		g.setFont(fnt1);
		
		g.setColor(Color.yellow);
		g.drawString("RESUME", returnButton.x,  returnButton.y);
		
		g.setColor(Color.lightGray);
		g.drawString("BAIL OUT", quitButton.x, quitButton.y);		
	}
	
}
