package DCT.Trees;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;


// Preorder traversal is actually the order of root when we do recursive calls
//i.e first call index is root, second is root of leftsub tree ...finally right
//inorder helps get the left and right of the pre order root to get rest of the tree.
//
//https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
//https://www.youtube.com/watch?v=PoBGyrIWisE

public class TreeFromInorderPreorder {
	
	class Node {
		char val;
		Node left;
		Node right;
		
		Node(char val) {
			this.val = val;
			this.left =null;
			this.right = null;
		}
	}

	Hashtable<Character, Integer> ht = new Hashtable<>();
	int preIndex=0;
	Node root;
	
	public static void main(String args []) {
		char in [] = {'D', 'B', 'E', 'A', 'F', 'C' }; 
		char pre[] = {'A', 'B', 'D', 'E', 'C', 'F' };
		TreeFromInorderPreorder tree = new TreeFromInorderPreorder();
		
		for (int i=0;i<in.length;i++) {
			tree.ht.put(in[i],i);
		}
 		
		tree.root = tree.buildTree(in, pre, 0, in.length-1); 
		tree.printTree(tree.root);
		
	}
	
	public Node buildTree(char in[], char pre[], int start, int end) {
		if (pre.length == 0 || in.length == 0)
			return null;
		
		if (start>end)
			return null;
		
		Node temp = new Node(pre[this.preIndex++]);
		
		if (start == end) 
			return temp;
		
		int tempIndex = ht.get(temp.val);
		temp.left =  buildTree(in,pre,start,tempIndex-1);
		temp.right =  buildTree(in,pre,tempIndex+1,end);
				
		return temp;
	}
	
	
	public void printTree(Node root) {
		Queue<Node> que = new LinkedList<>();
		if (root != null) {
			que.add(root);
		}
		
		while(!que.isEmpty()) {
			Node temp = que.poll();
			System.out.print(temp.val+" ");
			if (temp.left!=null)
				que.add(temp.left);
			if (temp.right!=null)
				que.add(temp.right);
		}
		
	}
}



