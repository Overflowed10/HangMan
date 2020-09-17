package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class CenterPaneResizableCanvas extends ResizableCanvas {
	private int numberOfWrongGuesses;

	public CenterPaneResizableCanvas() {
		super();
	}

	protected void draw() {
		if (gc == null) {
			gc = this.getGraphicsContext2D();
		}
		clearCanvas();
		int x = 0;
		while (x <= numberOfWrongGuesses) {
			switch (x) {
			case 0:
				drawGallow();
				break;
			case 1:
				drawHead();
				break;
			case 2:
				drawBase();
				break;
			case 3:
				drawRightFoot();
				break;
			case 4:
				drawLeftFoot();
				break;
			case 5:
				drawRightHand();
				break;
			case 6:
				drawLeftHand();
				break;
			case 7:
				drawSadFace();
				break;
			}
			x++;
		}

	}

	private void drawSadFace() {
		gc.setLineWidth(2);
		gc.fillOval(372, 85, 5, 5);
		gc.fillOval(388, 85, 5, 5);
		gc.strokeArc(372, 95, 20, 5, 0, 180, ArcType.OPEN);
	}

	private void drawLeftHand() {
		gc.strokeLine(378, 120, 420, 170);
	}

	private void drawRightHand() {
		gc.strokeLine(382, 120, 340, 170);

	}

	private void drawLeftFoot() {
		gc.setLineWidth(4);
		gc.strokeLine(378, 220, 340, 270);

	}

	private void drawRightFoot() {
		gc.setLineWidth(4);
		gc.strokeLine(382, 220, 420, 270);

	}

	private void drawBase() {
		gc.setLineWidth(12);
		gc.strokeLine(380, 117, 380, 120);
		gc.setLineWidth(4);
		gc.strokeLine(380, 120, 380, 220);

	}

	private void drawHead() {
		gc.setLineWidth(4);
		gc.strokeOval(360, 72, 40, 40);

	}

	private void drawGallow() {
		gc.setLineWidth(7);
		gc.setStroke(Color.BLACK);
		gc.strokeLine(20, 400, 580, 400);
		gc.setLineWidth(7);
		gc.setStroke(Color.BLACK);
		// bottom bar
		gc.strokeLine(60, 394, 260, 394);
		// vertical bar
		gc.strokeLine(160, 394, 160, 50);
		// upper bar
		gc.strokeLine(160, 50, 380, 50);
		// crossbar
		gc.strokeLine(162, 150, 278, 52);
		// neck rope
		gc.strokeLine(380, 50, 380, 70);
	}

	public int getNumberOfWrongGuesses() {
		return numberOfWrongGuesses;
	}

	public void setNumberOfWrongGuesses(int numberOfWrongGuesses) {
		this.numberOfWrongGuesses = numberOfWrongGuesses;
		draw();
	}
}
