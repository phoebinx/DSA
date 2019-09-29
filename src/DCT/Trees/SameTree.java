package DCT.Trees;

public class SameTree {
	Node root;
 public static void main(String args[]) {
	 int arr1[] = {1,2,1};
	 int arr2[] = {1,1,2};
	 
	 SameTree tree1 = new SameTree();
	 SameTree tree2 = new SameTree();
	 
	 Node n1= tree1.insertLevelOrder(arr1, tree1.root, 0);
	 Node n2 = tree1.insertLevelOrder(arr2, tree2.root, 0);
	 System.out.println("Trees are identical: "+tree1.identicalTrees(n1, n2));
	 
 }
 
 public Node insertLevelOrder(int arr[], Node root, int i) {
	 if (i<arr.length) {
		 Node temp = new Node(arr[i]);
		 root = temp;
		 root.left = insertLevelOrder(arr,root.left,2*i+1);
		 root.right = insertLevelOrder(arr,root.right,2*i+2);
		 return root;
	 }
	 return null;
 }
 
 public boolean identicalTrees(Node root1, Node root2) {
	 if (root1 == null && root2 == null) {
		 return true;
	 }
	 if (root1 != null && root2 != null) {
		 return (
				 root1.val == root2.val && 
				 identicalTrees(root1.left, root2.left) && 
						 identicalTrees(root1.right, root2.right));
	 } else {
		 return false;
	 }
 }
}
