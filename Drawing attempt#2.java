package hw7;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Drawing extends Application {
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Drawing"); // Set the stage title
		primaryStage.setScene(scene);
		primaryStage.show();
		pane.requestFocus();

		Polyline line = new Polyline(100.0, 100.0);
		line.setStroke(Color.BLACK);
		line.setFill(Color.WHITE);

		pane.getChildren().add(line);
		ObservableList<Double> list = line.getPoints();

		pane.setOnKeyPressed(e -> {
			double x = 0, y = 0;
			double length = 10;
			switch (e.getCode()) {
			case DOWN:
				x = list.get(list.size() - 2);
				y = list.get(list.size() - 1) + length;
				break;
			case UP:
				x = list.get(list.size() - 2);
				y = list.get(list.size() - 1) - length;
				break;
			case RIGHT:
				x = list.get(list.size() - 2) + length;
				y = list.get(list.size() - 1);
				break;
			case LEFT:
				x = list.get(list.size() - 2) - length;
				y = list.get(list.size() - 1);
				break;
			default:
				break;

			}
			list.add(x);
			list.add(y);

		});

	}

	public static void main(String[] args) {
		launch(args);
	}
}