package view;

import java.util.LinkedList;

import javafx.scene.paint.Color;

public class UsedLetterPaneResizableCanvas extends ResizableCanvas {
	private static final int START_X = 10;
	private static final int STEP_X = 15;

	private LinkedList<String> wrongLetters;

	/**
	 * Draws all wrongly used letters.
	 */
	protected void draw() {
	}

	public void drawLetters() {
		gc.setLineWidth(1);
		gc.setStroke(Color.INDIANRED);
		for (int i = 0; i < wrongLetters.size(); i++) {
			gc.strokeText(wrongLetters.get(i), START_X + STEP_X * i, 12);
		}

	}

	public LinkedList<String> getUsedLetters() {
		return wrongLetters;
	}

	public void setWrongLetters(LinkedList<String> wrongLetters) {
		this.wrongLetters = wrongLetters;
		clearCanvas();
		drawLetters();
	}
}
