package DSA;

public class testArrRef {
	public static void main(String args[]) {
		boolean visited [][] = new boolean[2][2];
		printVisited(visited);
		changeVisited(visited);
		printVisited(visited);
	}
	
	public static void changeVisited(boolean visited[][]) {
		visited[0][1] = true;
 	}
	
	public static void printVisited(boolean visited[][]) {
		for (int i = 0; i<2; i++) {
			for (int j = 0; j<2; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
	}
}
