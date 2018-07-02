package snek;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Snake {
	
	int red = 255;
	int green = 0;
	int blue = 0;
	int color = 1;
	
	int fr = 0;
	int fg = 0;
	int fb = 0;
	
	ArrayList<SnakeSegment> segments = new ArrayList<SnakeSegment>();
	SnakeSegment head = new SnakeSegment(100, 150, red, green, blue, true);

	int direction;

	Random ran1 = new Random();
	Random ran2 = new Random();
	
	Random colRan = new Random();

	Location food = new Location(300, 300);

	Snake() {

		segments.add(head);

		direction = 2;

	}

	public Location getHeadLocation() {

		return head.location;

	}

	public void feed() {

		boolean offSnake = false;
		
		int one = 0;
		int two = 0;

		while (!offSnake) {
			one = ran1.nextInt(15) * 50;
			two = ran2.nextInt(15) * 50;
			Location l = new Location(one, two);

			if (!onSnake(l)) {
				offSnake = true;
			}
		}
		
		food.x = one;
		food.y = two;

		segments.add(new SnakeSegment(head.location.x, head.location.y, fr, fg, fb, false));
		
		fr = colRan.nextInt(256);
		fg = colRan.nextInt(256);
		fb = colRan.nextInt(256);

	}

	public void update() {

		for (int i = segments.size() - 1; i > 0; i--) {
			segments.get(i).location = new Location(segments.get(i - 1).location.x, segments.get(i - 1).location.y);
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

		for (int i = 1; i < segments.size(); i++) {
			if (head.location.x == segments.get(i).location.x && head.location.y == segments.get(i).location.y) {
				for (int j = 1; j < segments.size();) {
					segments.remove(j);
				}
				direction = 2;
				head.location = new Location(100, 150);
				JOptionPane.showMessageDialog(null, "You died. Haha.");
				red = 255;
				green = 0;
				blue = 0;
			}
		}
		
		if (head.location.x > 750 || head.location.x < 0) {
			for (int j = 1; j < segments.size();) {
				segments.remove(j);
			}
			direction = 2;
			head.location = new Location(100, 150);
			JOptionPane.showMessageDialog(null, "You died. Haha.");
			red = 255;
			green = 0;
			blue = 0;
		}
		
		if (head.location.y > 750 || head.location.y < 0) {
			for (int j = 1; j < segments.size();) {
				segments.remove(j);
			}
			direction = 2;
			head.location = new Location(100, 150);
			JOptionPane.showMessageDialog(null, "You died. Haha.");
			red = 255;
			green = 0;
			blue = 0;
		}

		if (head.location.x == food.x && head.location.y == food.y) {
			feed();
		}

		if (red == 255 && green == 0 && blue == 0) {
			color = 1;
		} else if (red == 255 && green == 255 && blue == 0) {
			color = 2;
		} else if (red == 0 && green == 255 && blue == 0) {
			color = 3;
		} else if (red == 0 && green == 255 && blue == 255) {
			color = 4;
		} else if (red == 0 && green == 0 && blue == 255) {
			color = 5;
		} else if (red == 255 && green == 0 && blue == 255) {
			color = 6;
		}
		
		if (color == 1) {
			green += 5;
			if (green > 255) {
				green = 255;
			}
		} else if (color == 2) {
			red -= 5;
			if (red < 0) {
				red = 0;
			}
		} else if (color == 3) {
			blue += 5;
			if (blue > 255) {
				blue = 255;
			}
		} else if (color == 4) {
			green -= 5;
			if (green < 0) {
				green = 0;
			}
		} else if (color == 5) {
			red += 5;
			if (red > 255) {
				red = 255;
			}
		} else if (color == 6) {
			blue -= 5;
			if (blue < 0) {
				blue = 0;
			}
		}
		
	}

	public void draw(Graphics g) {

		for (int i = 0; i < segments.size(); i++) {
			segments.get(i).draw(g, red, green, blue);
		}

	}

	public boolean onSnake(Location l) {

		for (int i = 0; i < segments.size(); i++) {
			if (l.x == segments.get(i).location.x && l.y == segments.get(i).location.y) {
				return true;
			}
		}

		return false;

	}

}
