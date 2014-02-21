package de.stevenschwenke.java.javafx.graphsInJavaFX;

import java.util.HashSet;
import java.util.Set;

public class Node {

	private String name;

	private Set<Node> children = new HashSet<Node>();

	public Node(String name) {
		super();
		this.name = name;
	}

	public void addChildren(Node newChildren) {
		children.add(newChildren);
	}

	public String getName() {
		return name;
	}

	public Set<Node> getChildren() {
		return children;
	}

	public void setChildren(Set<Node> children) {
		this.children = children;
	}

}
