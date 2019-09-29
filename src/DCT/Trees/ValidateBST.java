package DCT.Trees;

import java.util.ArrayList;

public class ValidateBST {
	Node root;
	
	public static void main(String args[]) {
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.add(5);
		arr1.add(1);
		arr1.add(4);
		arr1.add(null);
		arr1.add(null);
		arr1.add(3);
		arr1.add(6);
		//int arr [] = {5,1,4,null,null,3,6};
		ValidateBST tree = new ValidateBST();
		tree.root = tree.insertLevelOrder(arr1, tree.root, 0);
		System.out.println(tree.validateTree(tree.root));
		
	}
	
	public boolean validateTree(Node root) {
		if (root == null) {
			return true;
		}
		boolean leftTrue=true;
		boolean rightTrue=true;
		
		if (root.left!=null)
			leftTrue = root.val>=root.left.val;
			
		if (root.left!=null)
			rightTrue = root.val<=root.right.val;
				
		return (leftTrue && rightTrue &&
				validateTree(root.left) && validateTree(root.right)); 
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
