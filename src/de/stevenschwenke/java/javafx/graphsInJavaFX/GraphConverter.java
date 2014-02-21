package de.stevenschwenke.java.javafx.graphsInJavaFX;

import com.mxgraph.layout.mxGraphLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.view.mxGraph;

public class GraphConverter {

	public static mxGraph x(Node generatedGraph) {
		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
		graph.getModel().beginUpdate();
		try {
			insertRecursivelyIntoGraph(generatedGraph, null, graph);
		} finally {
			graph.getModel().endUpdate();
		}

		mxGraphLayout layouter = new mxHierarchicalLayout(graph);
		layouter.execute(parent);
		return graph;
	}

	private static void insertRecursivelyIntoGraph(Node node, Object jGraphXParent, mxGraph graph) {

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
}