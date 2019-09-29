package DCT.Trees;

public class MaxDepthTreeIpArray {
	public static void main(String args[]) {
		MaxDepthTreeIpArray tree = new MaxDepthTreeIpArray();
		int arr[] = {3,9,20,Integer.MIN_VALUE,Integer.MIN_VALUE,15,7};
		System.out.println("\nResult:"+tree.maxDepth(arr, 0));
	}
	
	public int maxDepth(int [] arr, int i) {
		System.out.print(i+" ");
		if (i<arr.length && 2*i+1<=arr.length) {
			int lDepth = maxDepth(arr, 2*i+1);
			int rDepth = maxDepth(arr, 2*i+2);
			return Math.max(lDepth,rDepth)+1;
		}
		return 0;
	}
}
