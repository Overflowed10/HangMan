package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import logic.HangManException;
import model.MainModel;
import view.BottomInputPane;

public class BottomInputPaneController {
	private final MainModel mainModel;
	private BottomInputPane bottomInputPane;

	public BottomInputPaneController(MainModel mainModel) {
		this.mainModel = mainModel;

	}

	public BottomInputPane getBottomInputPane() {
		return bottomInputPane;
	}

	public void setBottomInputPane(BottomInputPane bottomInputPane) {
		this.bottomInputPane = bottomInputPane;
	}

	public void enterLetter() {
		TextField textfield = bottomInputPane.getInputField();
		String input = textfield.getText().toUpperCase();
		textfield.clear();
		try {
			mainModel.processLetter(input);
		} catch (HangManException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid input!");
			alert.setHeaderText("Error");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

}
