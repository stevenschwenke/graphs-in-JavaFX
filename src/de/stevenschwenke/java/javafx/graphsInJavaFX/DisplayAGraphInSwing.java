package de.stevenschwenke.java.javafx.graphsInJavaFX;

import javax.swing.JFrame;

import com.mxgraph.layout.mxGraphLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class DisplayAGraphInSwing extends JFrame {

	public DisplayAGraphInSwing() {

		// Node root = new Node("root");
		// Node c1 = new Node("Children 1");
		// root.addChildren(c1);
		// Node c2 = new Node("Children 2");
		// root.addChildren(c2);

		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
		graph.getModel().beginUpdate();
		try {
			Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80, 30);
			Object v2 = graph.insertVertex(parent, null, "World!", 240, 150, 80, 30);
			graph.insertEdge(parent, null, "Edge", v1, v2);

		} finally {
			graph.getModel().endUpdate();
		}

		mxGraphLayout layouter = new mxHierarchicalLayout(graph);
		layouter.execute(parent);

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
	}

	public static void main(String[] args) {
		DisplayAGraphInSwing frame = new DisplayAGraphInSwing();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 320);
		frame.setVisible(true);
	}
}
