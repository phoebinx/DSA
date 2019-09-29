package DCT;

import java.util.ArrayList;
import java.util.PriorityQueue;

//timecomplexity is knLogk as priority queue is of size k (k=no of arrays) and insertion in priority queue is log n )
//https://www.youtube.com/watch?v=6bvnZzwiKzs
public class MergeKSortedArray {
	public class QueueNode implements Comparable<QueueNode> {
		int outerI;//the array being referenced
		int InnerJ;//index in array
		int value;
		
		QueueNode(int outerI,int InnerJ,int value) {
			this.outerI = outerI;
			this.InnerJ = InnerJ;
			this.value= value;
		}
		
		
		@Override
		public int compareTo(QueueNode o) {
			// TODO Auto-generated method stub
			if (this.value>o.value)
				return 1;
			if (this.value<o.value)
				return -1;
			return 0;
		}
		
	}
	
	public static void main(String args[]) {
		int arrays [][] = {{1,4,7},{2,5,8},{3,6,9}};
		printSortedList(arrays);
		
	}
	
	public static void printSortedList(int [][] arrays) {
		
		MergeKSortedArray obj=new  MergeKSortedArray();
		
		PriorityQueue<QueueNode> pq = new PriorityQueue<>();
		
		//populate pq with first item of all arrays
		for (int i=0;i<arrays.length;i++) {
			pq.add(obj.new QueueNode(i,0,arrays[i][0]));
		}
		
		ArrayList<Integer> results = new ArrayList<>();
		
		while(!pq.isEmpty()) {
			QueueNode temp = pq.poll();
			if (temp.InnerJ+1<arrays[temp.outerI].length) {
				pq.add(obj.new QueueNode(temp.outerI,temp.InnerJ+1,arrays[temp.outerI][temp.InnerJ+1]));
				results.add(temp.value);
			}
		}
		
		for(int i:results)
			System.out.print(i+" ");
	}

}
