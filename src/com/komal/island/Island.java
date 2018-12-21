package com.komal.island;

import java.util.Set;

public class Island {

	Set<Node> nodes = null;
	
	public void addNode(Node n) {
		nodes.add(n);
	}
	
	public String toString() {
		return "Island["+nodes.toString()+"]";
	}
}
