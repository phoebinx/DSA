//if element in MXN matrix is 0 , its entire row and column is set to 0.
//maintian two arraylists one containing rows that have a 0 element and other with columns having a 0 element.


package StringsAndArrays;


import java.util.ArrayList;
import java.util.List;

public class ZeroMatrix {
public static void main(String args[])
{
	int [][] matrix  ={{1,0,5},{2,3,0},{3,5,5}}; 
	List<Integer> arrRow = new ArrayList<Integer>();
	List<Integer> arrColumn = new ArrayList<Integer>();
	for(int i = 0; i <matrix.length; i++)
	{
		for(int j = 0; j<matrix[i].length; j++)
		{
			if(matrix[i][j] == 0)
			{
				if(!arrRow.contains(i))
				{
				arrRow.add(i);
				}
				if(!arrColumn.contains(j))
				{
				//for column j, make all rows 0
				arrColumn.add(j);
				}
			}
		}
	}
	
	//replace with 0 for elements in row arrRow or column arrColumn
	for(int i = 0; i <matrix.length; i++)
	{
		for(int j = 0; j<matrix[i].length; j++)
		{
			if(arrRow.contains(i) || arrColumn.contains(j))
			{
				matrix[i][j] = 0;
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
