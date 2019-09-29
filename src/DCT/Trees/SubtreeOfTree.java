package DCT.Trees;

//1) Find inorder and preorder traversals of T, store them in two auxiliary arrays inT[] and preT[].
//
//2) Find inorder and preorder traversals of S, store them in two auxiliary arrays inS[] and preS[].
//
//3) If inS[] is a subarray of inT[] and preS[] is a subarray preT[], then S is a subtree of T. Else not.


import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfTree {
	Node root;
	StringBuilder inOrderStr = new StringBuilder();
	StringBuilder preOrderStr = new StringBuilder();
	
	public static void main(String args []) {
		SubtreeOfTree tree1 = new SubtreeOfTree();
		//int arr1[] =  {3,4,5,1,2};
		int arr1[] =  {1,2,3,4,5};
		tree1.root=tree1.populateTree(tree1.root,arr1, 0);
		SubtreeOfTree tree2 = new SubtreeOfTree();
		//int arr2[] =  {4,1,2};
		int arr2[] =  {1,2,3,4};
		tree2.root=tree2.populateTree(tree2.root,arr2, 0);
		//System.out.println(tree1.isSubTree(tree1.root, tree2.root));
		
		tree1.inOrder(tree1.root);
		tree2.inOrder(tree2.root);
		tree1.preOrder(tree1.root);
		tree2.preOrder(tree2.root);
	
		if (tree1.inOrderStr.toString().contains(tree2.inOrderStr) && 
				tree1.preOrderStr.toString().contains(tree2.preOrderStr)) {
			System.out.println("Tree two is subtree of One");
		} else {
			System.out.println("Tree two isn't subtree of One");
		}
		
		
	}
	
	public void inOrder(Node root) {
		if (root == null) {
			this.inOrderStr.append("*");
			return;
		} 
		this.inOrder(root.left);
		this.inOrderStr.append(root.val);
		this.inOrder(root.right);
	}
	
	public void preOrder(Node root) {
		if (root == null) {
			this.preOrderStr.append("*");
			return;
		}
		this.preOrderStr.append(root.val);
		this.preOrder(root.left);
		this.preOrder(root.right);
	}
	
	public boolean isSubTree(Node a, Node b) {
		return false;
	}
	
	public Node populateTree(Node root, int arr[], int i) {
		if (i<arr.length) {
			root = new Node(arr[i]);
			root.left = populateTree(root.left,arr,2*i+1);
			root.right = populateTree(root.right,arr,2*i+2);
		}
		return root;
	}
	
	public void printLevelOrder(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			System.out.print(temp.val+" ");
			if (temp.left!=null)
				q.add(temp.left);
			if (temp.right!=null)
				q.add(temp.right);
		}
	}
	

}

