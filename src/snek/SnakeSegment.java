package snek;

import java.awt.Color;
import java.awt.Graphics;

public class SnakeSegment {

	Location location;
	
	int size = 50;
	
	SnakeSegment(int x, int y) {
		
		location = new Location(x, y);
		
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.blue);
		g.fillRect(location.x, location.y, size, size);

	}
	
}
