package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			snakeRun.goLeft = false;
			snakeRun.goRight = false;
			if (snakeRun.goDown == true) {
				snakeRun.goUp = false;
				snakeRun.goDown = true;
			} else {
				snakeRun.goUp = true;
				snakeRun.goDown = false;
			}
			
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			snakeRun.goUp = false;
			snakeRun.goDown = false;
			if (snakeRun.goRight == true) {
				snakeRun.goLeft = false;
				snakeRun.goRight = true;
			} else {
				snakeRun.goRight = false;
				snakeRun.goLeft = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			snakeRun.goLeft = false;
			snakeRun.goRight = false;
			if (snakeRun.goUp == true) {
				snakeRun.goUp = true;
				snakeRun.goDown = false;
			} else {
				snakeRun.goUp = false;
				snakeRun.goDown = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			snakeRun.goUp = false;
			snakeRun.goDown = false;
			if (snakeRun.goLeft == true) {
				snakeRun.goLeft = true;
				snakeRun.goRight = false;
			} else {
				snakeRun.goRight = true;
				snakeRun.goLeft = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			// System.out.println("stop");
			snakeRun.stop = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_R) {
			// System.out.println("restart");
			snakeRun.stop = false;
			snakeRun.restart();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
