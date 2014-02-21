package de.stevenschwenke.java.javafx.graphsInJavaFX;

import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class DisplayAGraphInSwing extends JFrame {

	public DisplayAGraphInSwing() {

		mxGraph graph = GraphConverter.convertIntoJGraphXGraph(GraphGenerator.generateGraph());

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
