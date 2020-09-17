package view;

import java.util.Objects;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public abstract class ResizableCanvas extends Canvas {
	protected GraphicsContext gc;

	public ResizableCanvas() {
		if (gc == null) {
			gc = this.getGraphicsContext2D();
		}

		// Redraw canvas when size changes.
		widthProperty().addListener(evt -> draw());
		heightProperty().addListener(evt -> draw());
	}

	protected void draw() {};

	/**
	 * Clears the Canvas
	 */
	protected void clearCanvas() {
		Objects.requireNonNull(gc, "GraphicsContent should have been initialised before!");
		double width = getWidth();
		double height = getHeight();
		gc.clearRect(0, 0, width, height);

	}

	@Override
	public boolean isResizable() {
		return true;
	}

	@Override
	public double prefWidth(double height) {
		return getWidth();
	}

	@Override
	public double prefHeight(double width) {
		return getHeight();
	}
}
