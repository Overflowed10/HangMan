package controller;

import model.MainModel;
import view.MainView;

public class MainController {
	private final MainModel mainModel;
	private MainView mainView;

	public MainController(MainModel mainModel) {
		this.mainModel = mainModel;
	}

	public void startUp() {
		BottomInputPaneController bottomInputPaneController = new BottomInputPaneController(mainModel);
		MenuBarController menuBarController = new MenuBarController(mainModel, bottomInputPaneController);

		MainView mView = new MainView(this, menuBarController, bottomInputPaneController, mainModel);
		mView.setResizable(false);
		setMainView(mView);

		menuBarController.setMenuBarTop(mView.getMenuBar());
		menuBarController.setmView(mView);
		bottomInputPaneController.setBottomInputPane(mView.getBottomInputPane());

		mainModel.setBottomInputPane(mainView.getBottomInputPane());
		mainModel.setDottedLineCanvas(mainView.getBottomDottedLinePaneResizableCanvas());
		mainModel.setUsedLetterCanvas(mainView.getUsedLetterCanvas());
		mainModel.setCenterPaneCanvas(mainView.getCenterPaneCanvas());

		mView.show();
		mainModel.startNewRound();
	}

	public MainView getMainView() {
		return this.mainView;
	}

	public void setMainView(MainView mView) {
		this.mainView = mView;
	}

}
