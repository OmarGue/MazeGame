package GamePack;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

public class GamePanel {
	public static void main(String[] args) {

		JFrame frame = new JFrame("Labyrinthe Game");
        frame.setSize(400, 400);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        LectureCommand control= new LectureCommand();
        frame.add(control);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                control.movePoint(e.getKeyCode());
            }
        });
        frame.pack();
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.requestFocus();
	}
}

class LectureCommand extends JPanel {

	  double r=Math.random();
	  double r1=Math.random();
	  private int pointX = (int) (r*400);
	  private int pointY = (int) (r1*400);
	  public void movePoint(int keyCode) {
	        int stepSize = 10; // c la vitesse de controle
	        
	        if (keyCode == KeyEvent.VK_LEFT) {
	            pointX -= stepSize;
	        } else if (keyCode == KeyEvent.VK_RIGHT) {
	            pointX += stepSize;
	        } else if (keyCode == KeyEvent.VK_UP) {
	            pointY -= stepSize;
	        } else if (keyCode == KeyEvent.VK_DOWN) {
	            pointY += stepSize;
	        }
	        
	        repaint(); // pour actualiser la pos du point
	    }
	  
	  protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        
	        g.setColor(Color.BLUE);
	        g.fillOval(pointX, pointY, 10, 10);
	    }
}
