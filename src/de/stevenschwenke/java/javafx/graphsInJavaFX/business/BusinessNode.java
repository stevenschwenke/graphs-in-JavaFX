package de.stevenschwenke.java.javafx.graphsInJavaFX.business;

import java.util.HashSet;
import java.util.Set;

public class BusinessNode {

	private String name;

	private Set<BusinessNode> children = new HashSet<BusinessNode>();

	public BusinessNode(String name) {
		super();
		this.name = name;
	}

	public void addChildren(BusinessNode newChildren) {
		children.add(newChildren);
	}

	public String getName() {
		return name;
	}

	public Set<BusinessNode> getChildren() {
		return children;
	}

	public void setChildren(Set<BusinessNode> children) {
		this.children = children;
	}

}
