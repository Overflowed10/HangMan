package view;

import controller.BottomInputPaneController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class BottomInputPane extends Pane {
	private GridPane wrapperPane;
	private BottomInputPaneController bottomInputPaneController;
	private TextField inputField;
	private Button ok;
	private boolean isWon;
	private boolean isLost;

	public BottomInputPane(BottomInputPaneController bottomInputPaneController) {
		GridPane wrapperPane = new GridPane();
		this.bottomInputPaneController = bottomInputPaneController;
		inputField = createInputBox();
		ok = checkLetterButton();
		wrapperPane.add(inputField, 0, 0);
		wrapperPane.add(ok, 1, 0);
		this.wrapperPane = wrapperPane;

	}

	private TextField createInputBox() {
		TextField input = new TextField();
		input.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				bottomInputPaneController.enterLetter();
				input.clear();
			}
		});
		return input;
	}

	private Button checkLetterButton() {
		Button checkLetterButton = new Button("[Enter] / [click]");
		checkLetterButton.setOnMouseClicked(event -> bottomInputPaneController.enterLetter());
		return checkLetterButton;
	}

	public GridPane getWrapperPane() {
		return wrapperPane;
	}

	public void setWrapperPane(GridPane wrapperPane) {
		this.wrapperPane = wrapperPane;
	}

	public TextField getInputField() {
		return inputField;
	}

	public void setInputField(TextField inputField) {
		this.inputField = inputField;
	}

	public boolean isWon() {
		return isWon;
	}

	public void setWon(boolean isWon) {
		this.isWon = isWon;
	}

	public boolean isLost() {
		return isLost;
	}

	public void setLost(boolean isLost) {
		this.isLost = isLost;
	}

	public void checkForGameState() {
		if (isLost || isWon) {
			inputField.setVisible(false);
			inputField.setDisable(true);
			ok.setDisable(true);
		} else {
			if (!inputField.isVisible()) {
				inputField.setVisible(true);
				inputField.setDisable(false);
			}
			if (ok.isDisable()) {
				ok.setDisable(false);
			}
		}

	}
}
