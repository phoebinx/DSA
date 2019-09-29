package DCT.matrix;

public class SpiralMatrix {
	public static void main(String args[]) {
		int M[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printSpiral(M);
	}

	public static void printSpiral(int M[][]) {
		int k = 0, l = 0;
		int m = M.length-1;
		int n = M[0].length-1;

		//m,k,i row|| n,l,j -> col
		while (k<m && l<n) {
			//right, j varies
			for (int j=l;j<=n;j++) {
				System.out.print(M[k][j]+" ");
			}
			k++;
			//down i varies
			for (int i=k;i<=m;i++) {
				System.out.print(M[i][n]+" ");
			}
			n--;
			//left
			for (int j=n;j>=0;j--) {
				System.out.print(M[m][j]+" ");
			}
			m--;
			//up, i remains same
			for (int i=m;i>=0;i--) {
				System.out.print(M[i][l]+" ");
			}
			l++;
			
			
		}
	}
}
