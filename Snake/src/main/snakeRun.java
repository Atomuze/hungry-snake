package main;

import java.util.Random;

public class snakeRun {
	public static int snakeLong = 500;
	public static int Long = 10;
	public static int xp;
	public static int yp;
	public static int[][] snake = new int[snakeLong][2];
	public static int[][] snake2 = new int[snakeLong][2];

	static Random ranIn = new Random();

	public static int priviousPosX = 30;
	public static int priviousPosY = 30;
	int temp = 1;
	public static boolean goUp = false;
	public static boolean goDown = false;
	public static boolean goLeft = false;
	public static boolean goRight = false;
	private boolean eatFood = false;
	int counter = 0;
	public static int score = 0;
	public static int highScore = 0;

	public static boolean stop = false;

	public snakeRun() {
		for (int i = 0; i < snakeLong; i++) {
			for (int j = 0; j < 2; j++) {
				snake[i][j] = -1;
			}
		}
		run();
		goUp = true;
	}

	public static void restart() {
		priviousPosX = 30;
		priviousPosY = 30;
		Long = 10;
		score = 0;
		for (int i = 0; i < snakeLong; i++) {
			for (int j = 0; j < 2; j++) {
				snake[i][j] = -1;
			}
		}
	}

	public void run() {
		if (!stop) {
			for (int i = 0; i < Long; i++) {
				for (int j = 0; j < 2; j++) {
					snake2[i][j] = snake[i][j];
				}
			}

			snake[0][0] = priviousPosX;
			snake[0][1] = priviousPosY;

			for (int i = 1; i < Long; i++) {
				for (int j = 0; j < 2; j++) {
					snake[i][j] = snake2[i - 1][j];
				}
			}

			if (goRight) {
				priviousPosX++;
				if (priviousPosX > 60) {
					priviousPosX = 0;
				}
			}
			if (goLeft) {
				priviousPosX--;
				if (priviousPosX < 0) {
					priviousPosX = 60;
				}
				temp++;
			}
			if (goUp) {
				priviousPosY--;
				if (priviousPosY < 0) {
					priviousPosY = 60;
				}
				temp++;
			}
			if (goDown) {
				priviousPosY++;
				if (priviousPosY > 60) {
					priviousPosY = 0;
				}
				temp++;
			}
		}

		if (score > highScore) {
			highScore = score;
		}

		if (eatFood) {
			Paint.ranX = ranIn.nextInt(60);
			Paint.ranY = ranIn.nextInt(60);
			Long = Long + 4;
			eatFood = false;
			score++;
		}

		if (priviousPosX == Paint.ranX && priviousPosY == Paint.ranY) {
			eatFood = true;
		}

		counter++;
		if (counter > 10) {
			for (int i = 0; i < snakeLong; i++) {
				if (priviousPosX == snake[i][0] && priviousPosY == snake[i][1]) {
					stop = true;
				}
			}
		}

		// System.out.println("priviousPosX "+ priviousPosX + "priviousPosY
		// "+priviousPosY);
		// System.out.println("run");
	}

	public static void slong(int i) {
		xp = snake[i][0];
		yp = snake[i][1];
	}
}
