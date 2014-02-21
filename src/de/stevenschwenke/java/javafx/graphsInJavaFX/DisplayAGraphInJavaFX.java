package de.stevenschwenke.java.javafx.graphsInJavaFX;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.mxgraph.view.mxGraph;

public class DisplayAGraphInJavaFX extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello World!");

		StackPane root = new StackPane();
		de.stevenschwenke.java.javafx.graphsInJavaFX.Node generateGraph = GraphGenerator.generateGraph();
		mxGraph graph = GraphConverter.convertIntoJGraphXGraph(generateGraph);
		root.getChildren().addAll(convertIntoFXNodes(graph));
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}

	private Node convertIntoFXNodes(mxGraph graph) {
		// TODO
		return new Button("Test");
	}
}