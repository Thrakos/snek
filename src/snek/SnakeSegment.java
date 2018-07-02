package snek;

import java.awt.Color;
import java.awt.Graphics;

public class SnakeSegment {

	Location location;
	
	Color color;
	
	int size = 50;
	
	boolean change;
	
	SnakeSegment(int x, int y, int r, int g, int b, boolean change) {
		
		color = new Color(r, g, b);
		
		location = new Location(x, y);
		
		this.change = change;
		
	}
	
	public void draw(Graphics g, int red, int green, int blue) {
		
		if (change) {
			g.setColor(new Color(red, green, blue));
		} else {
			g.setColor(color);
		}
		g.fillRect(location.x, location.y, size, size);

	}
	
}
