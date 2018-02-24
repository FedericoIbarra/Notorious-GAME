package interfaces;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface Entity2 {

	public void tick();
	public void render (Graphics g);
	public Rectangle getBounds();
}
