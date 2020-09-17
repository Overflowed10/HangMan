package controller;

import model.MainModel;
import view.MainView;
import view.MenuBarTop;

public class MenuBarController {
	private final MainModel mainModel;
	private MenuBarTop menuBarTop;
	private MainView mView;

	public MenuBarController(MainModel mainModel) {
		this.mainModel = mainModel;
	}

	public void createNewGame() {
		mainModel.startNewRound();
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
