package DCT.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//distance formula ={\sqrt  {(x_{{2}}-x_{{1}})^{{2}}+(y_{{2}}-y_{{1}})^{{2}}}}
//https://www.geeksforgeeks.org/path-rectangle-containing-circles/
public class PathInRectWithCircles {
	
	public static void main(String args[]) {
		int m =5, n = 5;
		int k = 2;
		int r = 1;
		//possible
		//int X[] = {1,3};
		//int Y[] = {3,3};
		//not possible
		int X[] = {1,1};
		int Y[] = {2,3};
		if (pathPossible(m,n,k,r,X,Y)) {
			System.out.println("PAth possible");
		} else {
			System.out.println("Path not possible");
		}
	}
	
	
	public static boolean pathPossible(int m, int n, int k, int r, int X[], int Y[]) {
		
		//to find non coordinates coming within the circles
		//create 2D array with all coordinates
		//assign coordinate falling in circle value -1, use distance formula
		//rest assign 0
		
		int res[][]=new int[m][n];
		for (int i = 0;i<m;i++) {
			for (int j=0;j<n;j++) {
				for(int p=0;p<k;p++) {
					//sub 1 coz our start and end is 1X1 and MXN but we are starting from index 0
					double a = Math.pow(X[p]-1-i, 2);
					double b = Math.pow(Y[p]-1-j, 2);
					if ((double)Math.sqrt(a+b)<=r) {
						res[i][j]=-1;
					}
				}
			}
		}
		
		printMatrix(res);
		//if starting cell comes within circle, return false
		if (res[0][0]==-1)
			return false;
		
		
		//we use bfs to find if there are any possible paths
		//initialize the queue that holds discovered cells whoes neighbors are not discovered yet
		int arr[] = {0,0};
		Queue<int[]> que = new LinkedList<>();
		que.add(arr);
		
		
		while(!que.isEmpty() ) {
			arr = que.poll();
			int eleX = arr[0];
			int eleY = arr[1];
			
			//Discover eight adjactent nodes, 
			// check top-left cell 
			if (eleX>0 && eleY>0 && res[eleX-1][eleY-1]==0) {
				res[eleX-1][eleY-1] = 1;
				int narr[] = {eleX-1,eleY-1};
				que.add(narr);
			}
			// check top cell
			if (eleX>0 && res[eleX-1][eleY]==0) {
				res[eleX-1][eleY] = 1;
				int narr[] = {eleX-1,eleY};
				que.add(narr);
			}
			// check top-right cell 
			if (eleX>0 && eleY<n-1 && res[eleX-1][eleY+1] == 0) {
				res[eleX-1][eleY+1] = 1;
				int narr[] = {eleX-1,eleY+1};
				que.add(narr);
			}
			// check left cell 
			if (eleY>0 && res[eleX][eleY-1]==0) {
				res[eleX][eleY-1] = 1;
				int narr[] = {eleX,eleY-1};
				que.add(narr);
			}
			// check right cell
			if (eleY<n-1 && res[eleX][eleY+1]==0) {
				res[eleX][eleY+1] = 1;
				int narr[] = {eleX,eleY+1};
				que.add(narr);
			}
			// check bottom-left cell 
			if (eleX<m-1 && eleY>0 && res[eleX+1][eleY-1]==0) {
				res[eleX+1][eleY-1] = 1;
				int narr[] = {eleX+1,eleY-1};
				que.add(narr);
			}
			
			// check bottom cell 
			if (eleX<m-1 && res[eleX+1][eleY]==0) {
				res[eleX+1][eleY] = 1;
				int narr[] = {eleX+1,eleY};
				que.add(narr);
			}
			
			// check bottom-right cell 
			if (eleX<m-1 && eleY<n-1 && res[eleX+1][eleY+1] == 0) {
				res[eleX+1][eleY+1] = 1;
				int narr[] = {eleX+1,eleY+1};
				que.add(narr);
			}	
		}
		printMatrix(res);
		return res[m-1][n-1]==1;
		
	}
	
	public static void printMatrix(int res[][]) {
		for(int i =0;i<res.length;i++) {
			for (int j=0;j<res[0].length;j++) {
				System.out.print(res[i][j]);
			}
			System.out.println();
		}
	}

}
