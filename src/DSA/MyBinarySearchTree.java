package DSA;

public class MyBinarySearchTree {
	Node root;
	
	static class Node {
		int data;
		Node left, right;
		
		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	private void insert(int val) {
		this.insertHelper(root, val);
	}
	
	private void insertHelper(Node current,int val) {
		if (current != null) {
			if(current.data < val) {
				if (current.right != null) {
					insertHelper(current.right, val);
				}
				else {
					current.right = new Node(val);
				}
			} if (current.data > val) {
				if (current.left != null) {
					insertHelper(current.left, val);
				}
				else {
					current.left = new Node(val);
				}
			}
		} else {
			root = new Node(val);
		}
	}
	
	private boolean search(int val) {
		return this.searchHelper(root, val);
	}
	
	private boolean searchHelper(Node current, int val) {
		if (current != null) {
			if (current.data == val) {
				return true;
			} else if (current.data > val) {
				searchHelper(current.left, val);
			} else {
				searchHelper(current.right, val);
			}
		}
		return false;
	}
	
	private void printTree() {
		this.printHelper(root);
	}
	
	private void printHelper(Node current) {
		if (current != null) {
			System.out.print(current.data+">>");
		} else {
			return;
		}
		printHelper(current.left);
		printHelper(current.right);
	}
	
	MyBinarySearchTree(Node root) {
		this.root = root;
	}
	
	public static void main(String args[]) {
		MyBinarySearchTree bst = new MyBinarySearchTree(new Node(4));
		bst.insert(2);
		bst.insert(1);
		bst.insert(3);
		bst.insert(5);
		bst.printTree();
		
		System.out.println(String.valueOf(bst.search(4)));
		System.out.println(String.valueOf(bst.search(6)));
	}
}
