package DCT.Trees;
//LSR inorder for smallest and RSL reverse inorder for largest
import java.util.ArrayList;

public class KthSmallestInBST {
	Node root;
	int count = 0;
	int countL = 0;
	public static void main (String args []) {
		KthSmallestInBST tree1 = new KthSmallestInBST();
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.add(3);
		arr1.add(1);
		arr1.add(4);
		arr1.add(null);
		arr1.add(2);
		tree1.root=tree1.insertLevelOrder(arr1,tree1.root, 0);
		System.out.println(tree1.kSmall(tree1.root, 1));
		System.out.println(tree1.kLarge(tree1.root, 1));
	}
	
	public int kSmall(Node root, int k) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int left = kSmall(root.left,k);
		if (left!=Integer.MAX_VALUE)
			return left;
		
		this.count++;
		if (count == k) {
			return root.val;
		}
		
		return kSmall(root.right,k);
					
	}
	
	public int kLarge(Node root, int k) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int right = kLarge(root.right,k);
		if (right!=Integer.MIN_VALUE)
			return right;
		
		this.countL++;
		if (countL == k) {
			return root.val;
		}
		
		return kLarge(root.left,k);
					
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
