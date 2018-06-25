package snek;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakePanel extends JPanel implements ActionListener, KeyListener {
	
	public static final int WIDTH = 750;
	public static final int HEIGHT = 750;
	
	int width;
	int height;
	
	Timer timer;
	
	Snake snake;
	
	JFrame frame;
		
	SnakePanel(int width, int height) {
		
		this.width = width;
		this.height = height;
		
		timer = new Timer(100, this);
		
		snake = new Snake();
		
		frame = new JFrame();

	}
	
	public static void main(String[] args) {
		
		SnakePanel snakePanel = new SnakePanel(WIDTH, HEIGHT);
		snakePanel.launchGame();
		
	}
	
	public void launchGame() {
		
		frame.add(this);
		frame.setVisible(true);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();
		frame.addKeyListener(this);
		
		timer.start();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		snake.draw(g);
		g.setColor(Color.RED);
		g.fillOval(snake.food.x, snake.food.y, 50, 50);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		snake.update();
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_UP && snake.direction != 2) {
			snake.direction = 0;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT && snake.direction != 3) {
			snake.direction = 1;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN && snake.direction != 0) {
			snake.direction = 2;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT && snake.direction != 1) {
			snake.direction = 3;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			snake.segments.add(new SnakeSegment(snake.head.location.x, snake.head.location.y));
		}
				
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
