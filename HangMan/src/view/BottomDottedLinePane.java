package view;

import javafx.scene.layout.Pane;
import model.MainModel;

public class BottomDottedLinePane extends Pane {

	private Pane wrapperPane;
	private MainView mainView;

	public BottomDottedLinePane(MainModel mainModel, MainView mainView) {
		this.mainView = mainView;
		Pane wrapperPane = new Pane();
		BottomDottedLinePaneResizableCanvas canvas = new BottomDottedLinePaneResizableCanvas();
		mainView.setBottomDottedLinePaneResizableCanvas(canvas);
		wrapperPane.getChildren().add(canvas);
		wrapperPane.setMinHeight(20);
		wrapperPane.setMinWidth(380);

		// Bind canvas size to stack pane size.
		canvas.widthProperty().bind(wrapperPane.widthProperty());
		canvas.heightProperty().bind(wrapperPane.heightProperty());

		setWrapperPane(wrapperPane);
	}

	public Pane getWrapperPane() {
		return wrapperPane;
	}

	public void setWrapperPane(Pane lines) {
		this.wrapperPane = lines;
	}

	public MainView getMainView() {
		return mainView;
	}

	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}

}
