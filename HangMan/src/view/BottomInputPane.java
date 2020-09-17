package view;

import controller.BottomInputPaneController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class BottomInputPane extends Pane {
	private GridPane wrapperPane;
	private BottomInputPaneController bottomInputPaneController;
	private TextField inputField;
	private Button ok;
	private int numberOfWrongGuesses;

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
		return input;
	}

	private Button checkLetterButton() {
		Button checkLetterButton = new Button("Lock in letter!");
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
}
