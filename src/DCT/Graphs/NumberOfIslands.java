package DCT.Graphs;

public class NumberOfIslands {
	public static void main(String args[]) {
		int M[][] = {{ 1, 1, 0, 0, 0 }, 
					{ 0, 1, 0, 0, 1 }, 
					{ 1, 0, 0, 1, 1 }, 
					{ 0, 0, 0, 0, 0 }, 
					{ 1, 0, 1, 0, 1 } };
		NumberOfIslands obj = new NumberOfIslands();
		System.out.println(obj.countIslands(M));
	}
	
	
	public boolean isSafe(int [][] M, boolean[][] visited, int i, int j) {
		if (i>=0 && i<M.length && j>=0 && j<M[i].length && M[i][j] ==1 && !visited[i][j])
			return true;
		return false;
	}
	
	public void DFS(int [][] M, boolean[][] visited, int i, int j) {
		visited[i][j] = true;
		int rowNbr[] = {0,0,-1,-1,-1,1,1,1};
		int colNbr[] = {-1,1,-1,0,1,-1,0,1};
		
		for (int k = 0;k<8;k++) { //up down diagonal
			if (isSafe(M, visited, i+rowNbr[k], j+colNbr[k]))
				DFS(M, visited, i+rowNbr[k], j+colNbr[k]);
		}
	}
	
	public int countIslands(int [][] M) {
		if (M==null) {
			return 0;
		}
		int count = 0;
		boolean visited[][] = new boolean[M.length][M[0].length];
		
		for (int i =0;i<M.length;i++) {
			for (int j = 0; j<M[i].length;j++) {
				if (!visited[i][j] && M[i][j] == 1) {
					DFS(M,visited,i,j);
					count++;
				}
			}
		}
		return count;	
	}
}
