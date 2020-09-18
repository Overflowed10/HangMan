package controller;

import model.MainModel;
import view.MainView;
import view.MenuBarTop;

public class MenuBarController {
	private final MainModel mainModel;
	private BottomInputPaneController bottomInputPaneController;
	private MenuBarTop menuBarTop;
	private MainView mView;

	public MenuBarController(MainModel mainModel, BottomInputPaneController bottomInputPaneController) {
		this.mainModel = mainModel;
		this.bottomInputPaneController = bottomInputPaneController;
	}

	public void createNewGame() {
		mainModel.startNewRound();
		bottomInputPaneController.getBottomInputPane().checkForGameState();
	}

	public void closeGame() {
		mView.close();
	}

	public MenuBarTop getMenuBarTop() {
		return menuBarTop;
	}

	public void setMenuBarTop(MenuBarTop menuBarTop) {
		this.menuBarTop = menuBarTop;
	}

	public MainView getmView() {
		return mView;
	}

	public void setmView(MainView mView) {
		this.mView = mView;
	}

}
