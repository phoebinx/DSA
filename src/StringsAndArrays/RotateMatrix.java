package StringsAndArrays;

/*
* * * ^ * * *
* * * | * * *        
* * * | * * *
* * * | * * *

Rotating it by 90 degree 

* * * *
* * * *
* * * *
-- - - >
* * * *
* * * *
* * * * 

first row becomes last column
second row becomes second last column
..
last row becomes first column

transform each row of source to required column of final image

*/

public class RotateMatrix {
	public static void main(String args[])
	{
		System.out.println(sizeOf(int));
	}
}



//if element in MXN matrix is 0 , its entire row and column is set to 0.
//maintian two arraylists one containing rows that have a 0 element and other with columns having a 0 element.
//if an element is found to be zero, check if its row is already in arrRow, if not make all columns of that
//row 0, similarly for columns. Make sure to make two copies of matrices else 
//if an element is fo


package StringsAndArrays;


import java.util.ArrayList;
import java.util.List;

public class ZeroMatrix {
public static void main(String args[])
{
	int [][] matrix  ={{1,0,0},{2,3,1},{3,5,5}}; 
	int [][] matrix1  ={{1,0,0},{2,3,1},{3,5,5}}; 
	List<Integer> arrRow = new ArrayList<Integer>();
	List<Integer> arrColumn = new ArrayList<Integer>();
	for(int i = 0; i <matrix.length; i++)
	{
		for(int j = 0; j<matrix[i].length; j++)
		{
			if(matrix1[i][j] == 0)
			{
				if(!arrRow.contains(i))
				{
				arrRow.add(i);
				//for row i, make all columns 0
				int y =matrix[i].length-1;
				while(y>=0)
				{
					matrix[i][y]=0;
					y--;
				}
				}
				if(!arrColumn.contains(j))
				{
				//for column j, make all rows 0
				arrColumn.add(j);
				int x = matrix.length-1;
				while (x>=0)
				{
					matrix[x][j]=0;
					x--;
				}
			}
			}
		}
	}

//print array
for(int i = 0; i <matrix.length; i++)
{
	for(int j = 0; j<matrix[i].length; j++)
	{
		System.out.print(matrix[i][j]);
	}
	System.out.println();
}
}
}
