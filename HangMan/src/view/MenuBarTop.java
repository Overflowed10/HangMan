package view;

import controller.MenuBarController;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MenuBarTop extends Stage {
	private final MenuBarController menuBarController;
	public MenuBar menuBar;

	public MenuBarTop(MenuBarController menuBarController) {
		this.menuBarController = menuBarController;
		createMenuBarPane();
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public void createMenuBarPane() {
		MenuBar menuBar = new MenuBar();
		Menu game = new Menu("Game");

		// Menu Items
		MenuItem newGame = new MenuItem("New");
		MenuItem closeGame = new MenuItem("Close");

		// Logic
		newGame.setOnAction(event -> menuBarController.createNewGame());
		closeGame.setOnAction(event -> menuBarController.closeGame());

		// Add Menu items to Menu
		game.getItems().add(newGame);
		game.getItems().add(closeGame);

		menuBar.getMenus().add(game);
		this.menuBar = menuBar;
	}
}
