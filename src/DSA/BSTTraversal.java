package DSA;

import java.util.ArrayList;

public class BSTTraversal {
	Node root;
	Node prev;
	ArrayList<Integer> arr = new ArrayList<>(); 
	static class Node {
		int data;
		Node left, right;
		Node( int data ) {
			this.data=  data;
			this.left = this.right = null;
		}
	}
	public boolean isBST() {
		prev = null;
		return isBST(root);
	}
	
	public boolean isBST(Node current) {
		if (current != null) {
			if (!isBST(current.left)) {
				return false;
			}
			if (prev!= null && prev.data > current.data) {
				return false;
			}
			prev = current;
			return isBST(current.right);
		}
		return true;
	}
	public static void main(String args[]) {
		BSTTraversal bst = new BSTTraversal();
		bst.root = new Node(3);
		bst.root.left = new Node(2);
		bst.root.left.left = new Node(1);
		bst.root.left.right = new Node(4);
		//bst.root.right = new Node(5);
		System.out.println(String.valueOf(bst.isBST()));
		for (int i = 0; i<bst.arr.size(); i++) {
			System.out.print(bst.arr.get(i)+" ");
		}
	}
}
