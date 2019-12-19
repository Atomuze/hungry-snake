package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Paint extends JPanel implements ActionListener {
	private final int space = 10;
	Timer time = new Timer(100, this);
	static Random ranIn = new Random();

	public static int ranX = ranIn.nextInt(60);
	public static int ranY = ranIn.nextInt(60);

	snakeRun sr = new snakeRun();
	int xPosition = 0;
	int yPosition = 0;

	int snakeLong = snakeRun.snakeLong;

	public Paint() {
		time.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.black);
		g.setColor(Color.green);
		g.fillRect(ranX * space, ranY * space, space, space);
		g.setColor(Color.WHITE);

		for (int i = 0; i < snakeLong; i++) {
			snakeRun.slong(i);
			xPosition = snakeRun.xp;
			yPosition = snakeRun.yp;
			g.fillRect(xPosition * space, yPosition * space, space, space);
			if (snakeRun.stop) {
				g.setColor(Color.RED);
				g.setFont(new Font("Verdana", 0, 80));
				g.drawString("GAME OVER", 60, 646 / 2);
				g.setFont(new Font("Verdana", 0, 30));
				g.setColor(Color.lightGray);
				g.drawString("YOUR SCORE " + snakeRun.score, 190, 646 / 2 + 100);
				g.setColor(Color.CYAN);
				g.drawString("YOUR HIGH SCORE " + snakeRun.highScore, 140, 646 / 2 + 150);
				g.setFont(new Font("Verdana", 0, 10));
				g.setColor(Color.WHITE);
				g.drawString("PRESS R TO RESTART ", 250, 646 / 2 + 200);
			}

			// System.out.print(xPosition + " " + yPosition + " / " );
		}
		//System.out.println();
		sr.run();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
