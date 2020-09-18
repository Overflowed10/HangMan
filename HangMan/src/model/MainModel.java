package model;

import logic.HangMan;
import logic.HangManException;
import view.BottomDottedLinePaneResizableCanvas;
import view.BottomInputPane;
import view.CenterPaneResizableCanvas;
import view.UsedLetterPaneResizableCanvas;

public class MainModel {
	private HangMan hangman;
	private BottomDottedLinePaneResizableCanvas dottedLineCanvas;
	private BottomInputPane bottomInputPane;
	private UsedLetterPaneResizableCanvas usedLetterCanvas;
	private CenterPaneResizableCanvas centerPaneCanvas;

	public MainModel() {
		hangman = new HangMan();
	}

	public void startNewRound() {
		hangman.startNewRound();
		dottedLineCanvas.setCorrectLetters(hangman.getCorrectIndicesOfWord());
		usedLetterCanvas.setWrongLetters(hangman.getWrongLetters());
		centerPaneCanvas.setNumberOfWrongGuesses(hangman.getNumberOfWrongGuesses());
		dottedLineCanvas.setSelectedWord(hangman.getSelectedWord());
		bottomInputPane.setLost(false);
		bottomInputPane.setWon(false);

	}

	public void processLetter(String input) throws HangManException {
		hangman.processLetter(input);
		dottedLineCanvas.setCorrectLetters(hangman.getCorrectIndicesOfWord());
		usedLetterCanvas.setWrongLetters(hangman.getWrongLetters());
		centerPaneCanvas.setNumberOfWrongGuesses(hangman.getNumberOfWrongGuesses());
		bottomInputPane.setLost(false);
		bottomInputPane.setWon(hangman.isRoundOver());
		bottomInputPane.setLost(hangman.isRoundWon());

	}

	public BottomDottedLinePaneResizableCanvas getDottedLineCanvas() {
		return dottedLineCanvas;
	}

	public void setDottedLineCanvas(BottomDottedLinePaneResizableCanvas dottedLineCanvas) {
		this.dottedLineCanvas = dottedLineCanvas;
	}

	public BottomInputPane getBottomInputPane() {
		return bottomInputPane;
	}

	public void setBottomInputPane(BottomInputPane bottomInputPane) {
		this.bottomInputPane = bottomInputPane;
	}

	public UsedLetterPaneResizableCanvas getUsedLetterCanvas() {
		return usedLetterCanvas;
	}

	public void setUsedLetterCanvas(UsedLetterPaneResizableCanvas usedLetterCanvas) {
		this.usedLetterCanvas = usedLetterCanvas;
	}

	public CenterPaneResizableCanvas getCenterPaneCanvas() {
		return centerPaneCanvas;
	}

	public void setCenterPaneCanvas(CenterPaneResizableCanvas centerPaneCanvas) {
		this.centerPaneCanvas = centerPaneCanvas;
	}

}
