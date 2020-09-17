package view;

import controller.BottomInputPaneController;
import controller.MainController;
import controller.MenuBarController;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.MainModel;

public class MainView extends Stage {
	private final MainModel mainModel;

	private MenuBarController menuBarController;
	private MainController mController;
	private BottomInputPaneController bottomInputPaneController;

	private MenuBarTop menuBar;
	private UsedLetterPane usedLetterPane;
	private CenterPane centerPane;
	private BottomInputPane bottomInputPane;
	private BottomDottedLinePane bottomDottedLinePane;
	private BottomDottedLinePaneResizableCanvas bottomDottedLinePaneResizableCanvas;
	private UsedLetterPaneResizableCanvas usedLetterCanvas;
	private CenterPaneResizableCanvas centerPaneCanvas;

	public MainView(MainController mController, MenuBarController menuBarController,
			BottomInputPaneController bottomInputPaneController, MainModel mainModel) {
		this.mainModel = mainModel;
		this.mController = mController;
		this.menuBarController = menuBarController;
		this.bottomInputPaneController = bottomInputPaneController;

		Scene scene = new Scene(createRootPane(), 620, 480);
		this.setTitle("HangMan");
		this.setScene(scene);
	}

	private Pane createRootPane() {
		BorderPane rootPane = new BorderPane();
		VBox topVBox = new VBox();
		topVBox.setPrefHeight(40);
		HBox bottomBox = new HBox();
		bottomBox.setMinHeight(20);

		menuBar = new MenuBarTop(this.menuBarController);
		usedLetterPane = new UsedLetterPane(mainModel, this);
		topVBox.getChildren().addAll(menuBar.getMenuBar(), usedLetterPane.getWrapperPane());

		centerPane = new CenterPane(mainModel, this);
		centerPane.setPrefHeight(400);

		bottomDottedLinePane = new BottomDottedLinePane(mainModel, this);
		bottomDottedLinePane.setMinHeight(20);
		bottomInputPane = new BottomInputPane(bottomInputPaneController);
		bottomBox.getChildren().addAll(bottomDottedLinePane.getWrapperPane(), bottomInputPane.getWrapperPane());

		rootPane.setTop(topVBox);
		rootPane.setCenter(centerPane.getWrapperPane());
		rootPane.setBottom(bottomBox);

		return rootPane;
	}

	public MenuBarTop getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(MenuBarTop menuBar) {
		this.menuBar = menuBar;
	}

	public UsedLetterPane getUsedLetterPane() {
		return usedLetterPane;
	}

	public void setUsedLetterPane(UsedLetterPane usedLetterPane) {
		this.usedLetterPane = usedLetterPane;
	}

	public CenterPane getCenterPane() {
		return centerPane;
	}

	public void setCenterPane(CenterPane centerPane) {
		this.centerPane = centerPane;
	}

	public BottomDottedLinePane getBottomPane() {
		return bottomDottedLinePane;
	}

	public void setBottomPane(BottomDottedLinePane bottomPane) {
		this.bottomDottedLinePane = bottomPane;
	}

	public BottomInputPane getBottomInputPane() {
		return bottomInputPane;
	}

	public void setBottomInputPane(BottomInputPane bottomInputPane) {
		this.bottomInputPane = bottomInputPane;
	}

	public BottomDottedLinePaneResizableCanvas getBottomDottedLinePaneResizableCanvas() {
		return bottomDottedLinePaneResizableCanvas;
	}

	public void setBottomDottedLinePaneResizableCanvas(
			BottomDottedLinePaneResizableCanvas bottomDottedLinePaneResizableCanvas) {
		this.bottomDottedLinePaneResizableCanvas = bottomDottedLinePaneResizableCanvas;
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
