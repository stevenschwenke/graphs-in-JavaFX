package de.stevenschwenke.java.javafx.graphsInJavaFX;

import javax.swing.JFrame;

import com.mxgraph.layout.mxGraphLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class DisplayAGraphInSwing extends JFrame {

	public DisplayAGraphInSwing() {

		Node root = new Node("root");
		Node c1 = new Node("Children 1");
		root.addChildren(c1);
		Node c2 = new Node("Children 2");
		root.addChildren(c2);
		Node c21 = new Node("Children 2.1");
		c2.addChildren(c21);
		Node c22 = new Node("Children 2.2");
		c2.addChildren(c22);

		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
		graph.getModel().beginUpdate();
		try {
			insertRecursivelyIntoGraph(root, null, graph);
		} finally {
			graph.getModel().endUpdate();
		}

		mxGraphLayout layouter = new mxHierarchicalLayout(graph);
		layouter.execute(parent);

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
	}

	private void insertRecursivelyIntoGraph(Node node, Object jGraphXParent, mxGraph graph) {

		if (jGraphXParent == null) {
			// node is the root node
			Object jGraphXRoot = graph.insertVertex(graph.getDefaultParent(), null, node.getName(), 0, 0, 80, 30);

			for (Node c : node.getChildren()) {
				insertRecursivelyIntoGraph(c, jGraphXRoot, graph);
			}
		} else {
			// node is an inner node or a leaf
			Object jGraphXChild = graph.insertVertex(graph.getDefaultParent(), null, node.getName(), 0, 0, 80, 30);
			graph.insertEdge(graph.getDefaultParent(), null, "", jGraphXParent, jGraphXChild);

			for (Node c : node.getChildren()) {
				insertRecursivelyIntoGraph(c, jGraphXChild, graph);
			}
		}
	}

	public static void main(String[] args) {
		DisplayAGraphInSwing frame = new DisplayAGraphInSwing();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 320);
		frame.setVisible(true);
	}
}
