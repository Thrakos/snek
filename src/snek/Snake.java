package snek;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Snake {
			
	ArrayList<SnakeSegment> segments = new ArrayList<SnakeSegment>();
	SnakeSegment head = new SnakeSegment(100, 100);
	
	int direction;
	
	Snake() {
		
		segments.add(head);
		
		direction = 2;
		
	}
	
	public Location getHeadLocation() {
		
		return head.location;
		
	}
	
	public void feed() {
		
	}
	
	public void update() {
		
		for (int i = segments.size() - 1; i > 0; i--) {
			segments.get(i).location = segments.get(i-1).location;
		}
				
		if (direction == 0) {
			head.location.y -= 50;
		} else if (direction == 1) {
			head.location.x += 50;
		} else if (direction == 2) {
			head.location.y += 50;
		} else if (direction == 3) {
			head.location.x -= 50;
		}
		
		for (int i = segments.size() - 1; i > 0; i--) {
			System.out.println("y of " + i + ": " + segments.get(i).location.y);
		}
		
		System.out.println("y of head: " + head.location.y);
		
		System.out.println(".");
		
	}
	
	public void draw(Graphics g) {
		
		for (int i = 0; i < segments.size(); i++) {
			segments.get(i).draw(g);
		}
				
	}
	
}
