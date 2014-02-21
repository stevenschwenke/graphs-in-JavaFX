package de.stevenschwenke.java.javafx.graphsInJavaFX;

import com.mxgraph.layout.mxGraphLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.view.mxGraph;

import de.stevenschwenke.java.javafx.graphsInJavaFX.business.BusinessNode;

public class BusinessGraphToJGraphXConverter {

	public static mxGraph convertIntoJGraphXGraph(BusinessNode generatedGraph) {
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

	private static void insertRecursivelyIntoGraph(BusinessNode node, Object jGraphXParent, mxGraph graph) {

		if (jGraphXParent == null) {
			// node is the root node
			Object jGraphXRoot = graph.insertVertex(graph.getDefaultParent(), null, node.getName(), 0, 0, 80, 30);

			for (BusinessNode c : node.getChildren()) {
				insertRecursivelyIntoGraph(c, jGraphXRoot, graph);
			}
		} else {
			// node is an inner node or a leaf
			Object parent = Start.interpretChildrenAsInnerNodes ? jGraphXParent : graph.getDefaultParent();

			Object jGraphXChild = graph.insertVertex(parent, null, node.getName(), 0, 0, 80, 30);
			graph.insertEdge(parent, null, "", jGraphXParent, jGraphXChild);

			for (BusinessNode c : node.getChildren()) {
				insertRecursivelyIntoGraph(c, jGraphXChild, graph);
			}
		}
	}
}
