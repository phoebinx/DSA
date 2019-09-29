package DCT.Trees;

public class BinaryTreefromArray {
	Node root;
	public static void main(String args[]) {
		
		BinaryTreefromArray tree = new BinaryTreefromArray();
		int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 }; 
		tree.root = tree.insertLevelOrder(arr, 0);
		tree.inOrder(tree.root);
	}
	
	
	public Node insertLevelOrder(int arr[], int i) {
		Node temp = null;
		if (i<arr.length) {
			temp = new Node(arr[i]); 
			temp.left = insertLevelOrder(arr,  2*i+1);
			temp.right = insertLevelOrder(arr, 2*i+2);
		}
		return temp;
	}
	public void inOrder(Node root) {
		if (root!=null) {
			inOrder(root.left);
			System.out.print(root.val+" ");
			inOrder(root.right);
		}
	}
}
