package snek;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SnekPanel extends JPanel implements ActionListener {
	
	int width;
	int height;
	
	Timer timer;
	
	SnekPanel(int width, int height) {
		
		this.width = width;
		this.height = height;
		
		timer = new Timer(300, this);
		
	}
	
	public void paintComponent(Graphics g) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
