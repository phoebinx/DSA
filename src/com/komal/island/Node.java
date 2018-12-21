package com.komal.island;

public class Node {
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	int x,y;
	
	public String toString() {
		return "Node[x="+x+",y="+y+"]";
	}
}
