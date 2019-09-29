package DCT.Trees;

import java.util.ArrayList;

public class LowestCommonAncestorBST {
	Node root;
	public static void main(String args[]) {
		LowestCommonAncestorBST tree1 = new LowestCommonAncestorBST();
		ArrayList<Integer> arr1 = new ArrayList<>();
		 //[6,2,8,0,4,7,9,null,null,3,5]
		arr1.add(6);
		arr1.add(2);
		arr1.add(8);
		arr1.add(0);
		arr1.add(4);
		arr1.add(7);
		arr1.add(9);
		arr1.add(null);
		arr1.add(null);
		arr1.add(3);
		arr1.add(5);
		tree1.root=tree1.insertLevelOrder(arr1,tree1.root, 0);
		System.out.println(tree1.LCA(tree1.root, 2,4).val);
	}

	public Node LCA(Node root, int p, int q) {
		while(root!=null) {
			if (root.val >p && root.val>q) {
				root = root.left;
			}
			
			else if (root.val<p && root.val<q) {
				root = root.right;
			} 
			else break;
		}
		return root;
	}
	
	public Node insertLevelOrder(ArrayList<Integer> arr, Node root, int i) {
		if (i<arr.size() && arr.get(i)!=null) {
			Node temp = new Node(arr.get(i)); 
			root = temp;
			root.left = insertLevelOrder(arr, root.left, 2*i+1);
			root.right = insertLevelOrder(arr, root.right, 2*i+2);
		}
		return root;
	}
}
