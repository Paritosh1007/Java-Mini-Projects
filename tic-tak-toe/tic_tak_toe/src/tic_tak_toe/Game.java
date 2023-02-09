package tic_tak_toe;

import java.util.Scanner;

public class Game {

	final int gridSize = 5;
	int[] boardMatrix = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	private void printGrid() {
		int apTermCount = 1;
		int cellCount = 0;
		for (int i = 1; i <= 11; i++) {
			if (i % 4 == 0)
				System.out.println("- - -+ - - +- - -");
			else if (i == (2 + (apTermCount - 1) * 4)) {
				System.out.println(String.format("  %s  |  %s  |   %s ", boardOutput(cellCount++),
						boardOutput(cellCount++), boardOutput(cellCount++)));
				apTermCount++;
			} else
				System.out.println("     |     |     ");

		}

	}

	private String boardOutput(int index) {
		int temp = boardMatrix[index];
		if (temp == 0)
			return "X";
		else if (temp == -1)
			return "O";
		return Integer.toString(temp);
	}

	private boolean updateMatrix(int indexNum, int player) {

		int index = indexNum - 1;
		if (index > 8 || index < 0) {
			System.out.println("select a valid cell");
			return false;
		}
		int option = player == 1 ? 0 : -1;
		if (boardMatrix[index] == 0 || boardMatrix[index] == -1) {
			System.out.println("Select a valid cell");
			return false;
		}

		boardMatrix[index] = option;
		return true;

	}

	private void checkWinCondition() {
		// HORIZONTAL CASES
		if (boardMatrix[0] == boardMatrix[1] && boardMatrix[1] == boardMatrix[2])
			winnerPlayer(0);
		if (boardMatrix[3] == boardMatrix[4] && boardMatrix[4] == boardMatrix[5])
			winnerPlayer(3);
		if (boardMatrix[6] == boardMatrix[7] && boardMatrix[7] == boardMatrix[8])
			winnerPlayer(6);
		// VERTICAL CASES
		if (boardMatrix[0] == boardMatrix[3] && boardMatrix[3] == boardMatrix[6])
			winnerPlayer(0);
		if (boardMatrix[1] == boardMatrix[4] && boardMatrix[4] == boardMatrix[7])
			winnerPlayer(1);
		if (boardMatrix[2] == boardMatrix[5] && boardMatrix[5] == boardMatrix[8])
			winnerPlayer(2);
		// DIAGONAL CASES
		if (boardMatrix[0] == boardMatrix[4] && boardMatrix[4] == boardMatrix[8])
			winnerPlayer(0);
		if (boardMatrix[2] == boardMatrix[4] && boardMatrix[4] == boardMatrix[6])
			winnerPlayer(2);
		if (boardMatrix[0] == boardMatrix[1] && boardMatrix[0] == boardMatrix[2] && boardMatrix[0] == boardMatrix[3]
				&& boardMatrix[0] == boardMatrix[4] && boardMatrix[0] == boardMatrix[5]
				&& boardMatrix[0] == boardMatrix[6] && boardMatrix[0] == boardMatrix[7]
				&& boardMatrix[0] == boardMatrix[8]) {
			System.out.println("No one wins");
			System.exit(0);
		}

	}

	private void winnerPlayer(int idx) {
		printGrid();
		if (boardMatrix[idx] == 0)
			System.out.println("Player 1 wins");
		if (boardMatrix[idx] == -1)
			System.out.println("Player 2 wins");
		System.exit(0);
	}

	public void gameLoop() {
		boolean gameFlag = true;
		int player = 1;
		Scanner sc = new Scanner(System.in);

		while (gameFlag) {
			printGrid();
			System.out.println("---------------------------------------");
			System.out.println(String.format("Input from player %d", player));
			int in = sc.nextInt();
			boolean pass = updateMatrix(in, player);
			if (pass) {
				checkWinCondition();

				player = (player == 1) ? (player = 2) : (player = 1);
			}

		}
	}

}
