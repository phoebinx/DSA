package DCT.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaxPathSum {
	Node root;
	int max; 
	public int maxPath(Node root) {
		int maxBranchSingle = 0;
		int maxBranchTotal = 0;
		if (root == null) {
			return 0;
		}
		
		int l = maxPath(root.left);
		int r = maxPath(root.right);
		maxBranchSingle= Math.max(Math.max(l, r)+root.val, root.val);
		maxBranchTotal = Math.max(maxBranchSingle, l+r+root.val);
		max = Math.max(max, maxBranchTotal);
		return maxBranchSingle;
	}
	
	public Node insertLevelOrder(int arr[], int i) {
		if (i<arr.length) {
			Node temp = new Node(arr[i]);
			temp.left = insertLevelOrder(arr,2*i+1);
			temp.right = insertLevelOrder(arr,2*i+2);
			return temp;
		}
		return null;
			
	}
	
	public void printLevelOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		System.out.print("["+root.val+"]");
		while(!queue.isEmpty()) {
			Node tempNode = queue.poll();
			StringBuilder str = new StringBuilder();
			if(tempNode.left!=null) {
				queue.add(tempNode.left);
				str.append("["+tempNode.left.val);
			}
			if (tempNode.right!=null) {
				queue.add(tempNode.right);
				if (str.length()==0)
					str.append("["+tempNode.right.val);
				else
					str.append(" "+tempNode.right.val);
			}
			if (str.length()!=0)
				str.append("]");
			System.out.println("\n"+str);
		}
	}
	
	public static void main(String args[]) {
		BinaryTreeMaxPathSum tree = new BinaryTreeMaxPathSum();
		//int arr [] = {-10,9,20,Integer.MIN_VALUE,Integer.MIN_VALUE,15,7};
		int arr[] = {3,9,20,Integer.MIN_VALUE,Integer.MIN_VALUE,15,7};
		Node root = tree.insertLevelOrder(arr,0);
		tree.printLevelOrder(root);
		tree.maxPath(root);
		System.out.println(tree.max);
	}
}
