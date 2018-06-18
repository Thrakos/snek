package snek;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Snek {

	public static final int WIDTH = 750;
	public static final int HEIGHT = 750;
	
	JFrame frame;
	
	SnekPanel sp = new SnekPanel(WIDTH, HEIGHT);
	
	ArrayList<SnekSegment> segments = new ArrayList<SnekSegment>();
	SnekSegment head = new SnekSegment(0, 0);
	
	Snek() {
		
		segments.add(head);
		frame = new JFrame();
		
	}
	
	public static void main(String[] args) {
		
		Snek s = new Snek();
		s.launchGame();
		
	}
	
	public void launchGame() {
		
		frame.add(sp);
		frame.setVisible(true);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();
		
		sp.timer.start();
		
	}
	
	public Location getHeadLocation() {
		
		return head.location;
		
	}
	
	public void feed() {
		
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics g) {
		
		for (int i = 0; i < segments.size(); i++) {
			segments.get(i).draw(g);
		}
		
	}
	
}
