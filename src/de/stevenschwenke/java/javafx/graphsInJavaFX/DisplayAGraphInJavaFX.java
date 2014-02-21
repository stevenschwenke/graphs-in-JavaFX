package de.stevenschwenke.java.javafx.graphsInJavaFX;

import java.util.HashSet;
import java.util.Set;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.model.mxICell;
import com.mxgraph.util.mxPoint;
import com.mxgraph.view.mxGraph;

public class DisplayAGraphInJavaFX extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello World!");

		AnchorPane root = new AnchorPane();
		de.stevenschwenke.java.javafx.graphsInJavaFX.BusinessNode generateGraph = GraphGenerator.generateGraph();
		mxGraph graph = BusinessGraphToJGraphXConverter.convertIntoJGraphXGraph(generateGraph);
		root.getChildren().addAll(convertIntoFXNodes(graph));
		primaryStage.setScene(new Scene(root, 600, 500));
		primaryStage.show();
	}

	private Set<Node> convertIntoFXNodes(mxGraph graph) {
		Set<Node> nodes = new HashSet<Node>();

		Object[] cells = graph.getCellsForGroup(new Object[] { graph.getDefaultParent() });
		mxCell cell = (mxCell) cells[0];
		for (int i = 0; i < cell.getChildCount(); i++) {
			mxICell childAt = cell.getChildAt(i);
			if (childAt.isVertex()) {
				mxGeometry geometry = childAt.getGeometry();

				String value = (String) childAt.getValue();
				Button b = new Button(value);
				double x = geometry.getX();
				b.translateXProperty().set(x);
				double y = geometry.getY();
				b.translateYProperty().set(y);
				nodes.add(b);

				System.out.println("Added node \"" + value + "\" at (" + x + ", " + y + ")");
			}
			if (childAt.isEdge()) {

				mxGeometry geometry = childAt.getGeometry();

				mxPoint lastPoint = null;
				for (mxPoint controlPoint : geometry.getPoints()) {
					if (lastPoint == null) {
						lastPoint = controlPoint;
						continue;
					}

					Line l = new Line(controlPoint.getX(), controlPoint.getY(), lastPoint.getX(), lastPoint.getY());
					nodes.add(l);
					lastPoint = controlPoint;
				}

				System.out.println("Added edge " + childAt.getValue() + " with " + geometry.getPoints().size() + " control points");
			}
		}

		return nodes;
	}
}