package pages;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Menu{

	public Rectangle playButton=new Rectangle(Game.WIDTH/2+120, 150, 100, 50);
	public Rectangle helpButton=new Rectangle(Game.WIDTH/2+120, 250, 100, 50);
	public Rectangle quitButton=new Rectangle(Game.WIDTH/2+120, 350, 100, 50);
	public Rectangle highscButton=new Rectangle(450, 0, 300, 50);
	
	public void render(Graphics g){
		
		Font fnt0 = new Font("arial", Font.BOLD, 50 );
		g.setFont(fnt0);
		g.setColor(Color.orange);
		g.drawString("  DANZASTLEY", Game.WIDTH/2, 110);
		
		Font fnt1 = new Font("arial", Font.PLAIN, 30 );
		g.setFont(fnt1);
		g.setColor(Color.lightGray);
		g.drawString("PLAY", playButton.x+17, playButton.y+32);		
		g.drawString("HELP", helpButton.x+17, helpButton.y+32);
		g.setColor(Color.yellow);
		g.drawString("EXIT", quitButton.x+17, quitButton.y+32);
		
		
		Font fnt2 = new Font("arial", Font.BOLD, 25 );
		g.setFont(fnt2);
		g.setColor(Color.white);
		g.drawString("HIGHSCORES", highscButton.x+17, highscButton.y+32);	
	}
	
}