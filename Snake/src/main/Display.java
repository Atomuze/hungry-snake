package main;

import javax.swing.JFrame;

public class Display {
	public static int x = 10;
	public static int y = 10;

	public static void main(String args[]) {
		JFrame frame = new JFrame("Hungry Snake");
		Paint p = new Paint();
		Controller control;
		control = new Controller();
		frame.setVisible(true);
		frame.setSize(626, 646);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.addKeyListener(control);
		
		frame.add(p);
	}
}
