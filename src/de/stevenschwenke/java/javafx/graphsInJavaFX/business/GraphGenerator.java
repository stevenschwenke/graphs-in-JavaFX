package de.stevenschwenke.java.javafx.graphsInJavaFX.business;

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
		BusinessNode c221 = new BusinessNode("Children 2.2.1");
		c22.addChildren(c221);
		BusinessNode c2211 = new BusinessNode("Children 2.2.1.1");
		c221.addChildren(c2211);
		BusinessNode c2212 = new BusinessNode("Children 2.2.1.2");
		c221.addChildren(c2212);
		BusinessNode c2213 = new BusinessNode("Children 2.2.1.3");
		c221.addChildren(c2213);
		return root;
	}
}
