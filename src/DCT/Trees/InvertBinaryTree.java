package DCT.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
	
	Node root;
	
	public static void main(String args[]) {
		int arr[] = {4,2,7,1,3,6,9};
		InvertBinaryTree tree = new InvertBinaryTree();
		Node n = tree.insertLevelOrder(arr, tree.root, 0);
		tree.printLevelOrderTraversal(n);
		System.out.println();
		tree.printLevelOrderTraversal(tree.invertTree(n));
		
	}
	
	public void printLevelOrderTraversal(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
		Node tempNode = queue.poll();
		System.out.print(tempNode.val+" ");
		if(tempNode.left!=null) {
			queue.add(tempNode.left);
		}
		if (tempNode.right!=null) {
			queue.add(tempNode.right);
		}
		}
	}
	
	public Node insertLevelOrder(int arr[], Node root, int i) {
		if (i<arr.length) {
		root = new Node (arr[i]);
		root.left = insertLevelOrder(arr, root.left, 2*i+1);
		root.right = insertLevelOrder(arr, root.right, 2*i+2);
		return root;
		}
		
		return null;
	}
	
	public Node invertTree(Node root) {
		if (root == null ) {
			return null;
		}
		Node temp = invertTree(root.right);
		root.right = invertTree(root.left);
		root.left = temp;
		return root;
	}
}
