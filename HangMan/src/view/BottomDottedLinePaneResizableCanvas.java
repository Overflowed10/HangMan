package view;

import java.util.LinkedList;

import javafx.scene.paint.Color;

public class BottomDottedLinePaneResizableCanvas extends ResizableCanvas {
	private static final int START_X = 5;
	private static final int STEP_X = 20;
	private static final int LENGTH_OF_LINE = 12;
	private static final int START_Y = 20;

	private String selectedWord;
	private LinkedList<Integer> correctIndicesOfWord;

	public void drawCanvas() {
		clearCanvas();
		drawLines();
		drawLetters();
	}

	/**
	 * Draws a black line for each character of the given word.
	 */
	private void drawLines() {
		for (int i = 0; i < selectedWord.length(); i++) {
			gc.setStroke(Color.BLACK);
			gc.setLineWidth(2);
			gc.strokeLine(START_X + STEP_X * i, START_Y, START_X + STEP_X * i + LENGTH_OF_LINE, START_Y);
		}
	}

	private void drawLetters() {
		for (int i = 0; i < correctIndicesOfWord.size(); i++) {
			int index = correctIndicesOfWord.get(i);
			gc.setStroke(Color.DARKGREEN);
			gc.setLineWidth(1);
			gc.strokeText(selectedWord.substring(index, index + 1), START_X + 1 + STEP_X * index, START_Y - 3, STEP_X);

		}
	}

	public String getSelectedWord() {
		return selectedWord;
	}

	public void setSelectedWord(String correctWord) {
		this.selectedWord = correctWord;
		drawLines();
	}

	public LinkedList<Integer> getCorrectLetters() {
		return correctIndicesOfWord;
	}

	public void setCorrectLetters(LinkedList<Integer> correctIndicesOfWord) {
		this.correctIndicesOfWord = correctIndicesOfWord;
		drawCanvas();
	}
}
