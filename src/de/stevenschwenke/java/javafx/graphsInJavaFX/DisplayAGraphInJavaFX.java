package de.stevenschwenke.java.javafx.graphsInJavaFX;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.model.mxICell;
import com.mxgraph.view.mxGraph;

public class DisplayAGraphInJavaFX extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello World!");

		StackPane root = new StackPane();
		de.stevenschwenke.java.javafx.graphsInJavaFX.BusinessNode generateGraph = GraphGenerator.generateGraph();
		mxGraph graph = BusinessGraphToJGraphXConverter.convertIntoJGraphXGraph(generateGraph);
		root.getChildren().addAll(convertIntoFXNodes(graph));
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}

	private Node convertIntoFXNodes(mxGraph graph) {
		Object[] cells = graph.getCellsForGroup(new Object[] { graph.getDefaultParent() });
		mxCell cell = (mxCell) cells[0];
		for (int i = 0; i < cell.getChildCount(); i++) {
			mxICell childAt = cell.getChildAt(i);
			if (childAt.isVertex()) {
				System.out.println("Vertex " + i + ": " + childAt.getValue());
				mxGeometry geometry = childAt.getGeometry();
				Button b = new Button((String) childAt.getValue());
				b.translateXProperty().set(geometry.getCenterX());
				b.translateYProperty().set(geometry.getCenterY());
			}
			if (childAt.isEdge()) {
				System.out.println("Edge " + i + ": " + childAt.getValue());
			}
		}

		return new Button("Test");
	}
}