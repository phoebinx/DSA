package com.komal.island;

public class FindIslands {
	
	public static void main(String args[]) {
		
		int map[][] = {
			{1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
		};
		
		for(int row = 0; row < map.length; row++) {
			for(int col = 0; col < map[row].length; col++) {
				//System.out.println("val="+arr[row][col]);
				traverse(new Node(row, col));
			}
		}
	}
	
	public static void traverse(Node n) {
		
		
	}
	
	public static Node goRight(Node n) {
		if (n.)
		return new Node(n.getX(), n.getY()+1);
	}

}
