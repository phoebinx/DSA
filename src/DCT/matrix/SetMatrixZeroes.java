package DCT.matrix;

import java.util.HashSet;

public class SetMatrixZeroes {
	public static void main(String args[]) {
		int M[][] = { {0,1,2,0},
				  {3,4,5,2},
				  {1,3,1,5}};
		setZeros(M);
	}

	public static void setZeros(int[][] M) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				if (M[i][j] == 0) {
					hs.add(i);
					hs.add(j);
				}
			}
		}

		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				if (hs.contains(i) || hs.contains(j)) {
					M[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				System.out.print(M[i][j]);
			}
			System.out.println();
		}
	}
}
