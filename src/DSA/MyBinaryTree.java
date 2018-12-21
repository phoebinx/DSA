package DSA;

public class MyBinaryTree {
	Node root;
	static class Node {
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			this.left=this.right=null;
		}
	}
	
	private boolean search(int val) {
		
		return this.preorderSearch(root, val);
	}
	
	private boolean preorderSearch(Node start, int val) {
		if (start != null) {
			if (start.data == val) {
				return true;
			} else {
				return (preorderSearch(start.left, val) ||
						preorderSearch(start.right, val));
			}
		}
		return false;
	}
	
	private void printTree() {
		String traversal = "";
		this.printPreorder(root, traversal);
		System.out.println();
		this.printInOrder(root, traversal);
	}
	
	
	private void printPreorder(Node start, String traversal) {
		if (start != null) {
			System.out.print(traversal+start.data+">>");
			printPreorder(start.left, traversal);
			printPreorder(start.right, traversal);
		}
		return;
	}
	
	private void printInOrder(Node start, String traversal) {
		if (start != null) {
			printInOrder(start.left, traversal);
			System.out.print(traversal+start.data+">>");
			printInOrder(start.right, traversal);
		}
	}
	public static void main(String args[]) {
		MyBinaryTree bt = new MyBinaryTree();
		bt.root = new Node(1);
		bt.root.left =  new Node(2);
		bt.root.right =  new Node(3);
		bt.root.left.left =  new Node(4);
		bt.root.left.right =  new Node(5);
		
		System.out.println(String.valueOf(bt.search(4)));
		System.out.println(String.valueOf(bt.search(7)));
		bt.printTree();
	}
	
}
