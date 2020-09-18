package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Random;

public class HangMan {
	private static final String WORD_LIST_PATH = "wordList.txt";
	private static final int MAX_TRIES = 7;

	private LinkedList<String> wordList;
	private LinkedList<String> usedLetters;
	private LinkedList<String> wrongLetters;
	private String selectedWord;
	private LinkedList<Integer> correctIndicesOfWord;
	private int numberOfWrongGuesses;
	private boolean roundOver;
	private boolean roundWon;

	/**
	 * Stores the relevant logic for the HangMan game.
	 */
	public HangMan() {
		loadWordList();
		setUsedLetters(new LinkedList<String>());
	}

	/**
	 * Starts a new Round of HangMan. A new word is selected and all dependent
	 * attributes are set correctly.
	 */
	public void startNewRound() {
		setUsedLetters(new LinkedList<String>());
		setWrongLetters(new LinkedList<String>());
		setNewRandomWordFromWordList();
		setCorrectIndicesOfWord(new LinkedList<Integer>());
		setNumberOfWrongGuesses(0);
		setRoundOver(false);
		setRoundWon(false);
	}

	/**
	 * Chooses a random word from the wordList.
	 */
	private void setNewRandomWordFromWordList() {
		Random rand = new Random();
		String word = this.wordList.get(rand.nextInt(wordList.size()));
		setSelectedWord(word.toUpperCase());
	}

	/**
	 * Takes the userInput and checks it for validity. If valid, adds the letter to
	 * the solution. Otherwise it adds one wrong guess.
	 * 
	 * @param letter - One letter String containing a letter of the alphabet
	 * @throws HangManException
	 */
	public void processLetter(String letter) throws HangManException {
		if (roundOver || roundWon) {
			if (roundOver) {
				System.out.println("Game Lost");
			} else {
				System.out.println("Game Won");
			}
			return;
		}

		if (!isStringValid(letter)) {
			throw new HangManException("Input must be one letter from A to Z!");
		}
		if (usedLetters.contains(letter)) {
			throw new HangManException("You have used this letter already. Please choose another one");
		}
		for (int i = 0; i < selectedWord.length(); i++) {
			if (selectedWord.substring(i, i + 1).equals(letter)) {
				correctIndicesOfWord.add(i);
			}
		}
		if (!selectedWord.contains(letter)) {
			numberOfWrongGuesses++;
			wrongLetters.add(letter);
		}
		addLetterToUsedLetterList(letter);
		checkIfRoundIsWon();
		checkIfRoundIsLost();

	}

	private void checkIfRoundIsWon() {
		if (correctIndicesOfWord.size() == selectedWord.length()) {
			setRoundWon(true);
		}
	}

	/**
	 * Checks if the number of wrong guesses is >= the allowed tries.
	 * 
	 * @return true or false
	 */
	private void checkIfRoundIsLost() {
		if (numberOfWrongGuesses >= MAX_TRIES) {
			setRoundOver(true);
		}
	}

	public void addLetterToUsedLetterList(String letter) {
		usedLetters.add(letter);
	}

	/**
	 * Loads the word list from File wordList.txt and sets it as the wordList
	 * attribute.
	 * 
	 * @throws IOException
	 */
	private void loadWordList() {
		LinkedList<String> words = new LinkedList();
		Path path = Path.of(WORD_LIST_PATH);
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			String line = reader.readLine();
			while (line != null) {
				words.add(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			System.err.println("Couldnt load wordList! " + e.getMessage());
		}
		setWordList(words);
	}

	private boolean isStringValid(String input) {
		if (input == null || !input.matches("[a-zA-Z]")) {
			return false;
		}
		return true;
	}

	public LinkedList<String> getWordList() {
		return wordList;
	}

	public void setWordList(LinkedList<String> wordList) {
		this.wordList = wordList;
	}

	public String getSelectedWord() {
		return selectedWord;
	}

	public void setSelectedWord(String selectedWord) {
		this.selectedWord = selectedWord;
	}

	public int getNumberOfWrongGuesses() {
		return numberOfWrongGuesses;
	}

	public void setNumberOfWrongGuesses(int numberOfTries) {
		this.numberOfWrongGuesses = numberOfTries;
	}

	public LinkedList<String> getUsedLetters() {
		return usedLetters;
	}

	public void setUsedLetters(LinkedList<String> usedLetters) {
		this.usedLetters = usedLetters;
	}

	public LinkedList<Integer> getCorrectIndicesOfWord() {
		return correctIndicesOfWord;
	}

	public void setCorrectIndicesOfWord(LinkedList<Integer> correctIndicesOfWord) {
		this.correctIndicesOfWord = correctIndicesOfWord;
	}

	public boolean isRoundOver() {
		return roundOver;
	}

	public void setRoundOver(boolean roundOver) {
		this.roundOver = roundOver;
	}

	public boolean isRoundWon() {
		return roundWon;
	}

	public void setRoundWon(boolean roundWon) {
		this.roundWon = roundWon;
	}

	public LinkedList<String> getWrongLetters() {
		return wrongLetters;
	}

	public void setWrongLetters(LinkedList<String> wrongLetters) {
		this.wrongLetters = wrongLetters;
	}
}
