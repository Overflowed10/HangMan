package application;

import controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.MainModel;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		MainModel model = new MainModel();
		MainController mController = new MainController(model);
		mController.startUp();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
