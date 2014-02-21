package de.stevenschwenke.java.javafx.graphsInJavaFX;

public class GraphGenerator {

	public static BusinessNode generateGraph() {
		BusinessNode root = new BusinessNode("root");
		BusinessNode c1 = new BusinessNode("Children 1");
		root.addChildren(c1);
		BusinessNode c2 = new BusinessNode("Children 2");
		root.addChildren(c2);
		BusinessNode c21 = new BusinessNode("Children 2.1");
		c2.addChildren(c21);
		BusinessNode c22 = new BusinessNode("Children 2.2");
		c2.addChildren(c22);
		return root;
	}
}
