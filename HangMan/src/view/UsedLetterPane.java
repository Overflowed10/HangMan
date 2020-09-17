package view;

import javafx.scene.layout.Pane;
import model.MainModel;

public class UsedLetterPane extends Pane {
	private Pane wrapperPane;

	public UsedLetterPane(MainModel mainModel, MainView mainView) {

		Pane wrapperPane = new Pane();
		wrapperPane.setMinHeight(20);
		UsedLetterPaneResizableCanvas canvas = new UsedLetterPaneResizableCanvas();
		mainView.setUsedLetterCanvas(canvas);
		wrapperPane.getChildren().add(canvas);

		// Bind canvas size to stack pane size.
		canvas.widthProperty().bind(wrapperPane.widthProperty());
		canvas.heightProperty().bind(wrapperPane.heightProperty());

		setWrapperPane(wrapperPane);
	}

	public Pane getWrapperPane() {
		return wrapperPane;
	}

	public void setWrapperPane(Pane wrapperPane) {
		this.wrapperPane = wrapperPane;
	}

}
