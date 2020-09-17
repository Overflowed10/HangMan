package view;

import javafx.scene.layout.Pane;
import model.MainModel;

public class CenterPane extends Pane {
	private Pane wrapperPane;
	private MainView mainView;
	private MainModel mainModel;

	public CenterPane(MainModel mainModel, MainView mainView) {
		this.mainView = mainView;
		this.mainModel = mainModel;
		Pane wrapperPane = new Pane();
		CenterPaneResizableCanvas canvas = new CenterPaneResizableCanvas();
		mainView.setCenterPaneCanvas(canvas);
		wrapperPane.getChildren().add(canvas);

		// Bind canvas size to stack pane size.
		canvas.widthProperty().bind(wrapperPane.widthProperty());
		canvas.heightProperty().bind(wrapperPane.heightProperty());

		canvas.draw();
		setWrapperPane(wrapperPane);
	}

	public Pane getWrapperPane() {
		return wrapperPane;
	}

	public void setWrapperPane(Pane wrapperPane) {
		this.wrapperPane = wrapperPane;
	}

}
