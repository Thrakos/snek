package snek;

import java.awt.Color;
import java.awt.Graphics;

public class SnekSegment {

	Location location;
	
	SnekSegment(int x, int y) {
		
		location = new Location(x, y);
		
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.blue);
		g.drawRect(location.x, location.y, 50, 50);
		
	}
	
}
