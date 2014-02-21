package de.stevenschwenke.java.javafx.graphsInJavaFX;

public class GraphGenerator {

	public static Node generateGraph() {
		Node root = new Node("root");
		Node c1 = new Node("Children 1");
		root.addChildren(c1);
		Node c2 = new Node("Children 2");
		root.addChildren(c2);
		Node c21 = new Node("Children 2.1");
		c2.addChildren(c21);
		Node c22 = new Node("Children 2.2");
		c2.addChildren(c22);
		return root;
	}
}
