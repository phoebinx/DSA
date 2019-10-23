package DCT.Heap;
//https://www.programcreek.com/2014/05/leetcode-top-k-frequent-elements-java/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFreq {
	public static void main(String args[]) {
		int arr[] = {1,1,1,2,2,3};
		int k = 2;
		printTopFreq(arr,k);
	}
	
	public static void printTopFreq(int arr[], int k) {
		HashMap<Integer, Integer> hm = new HashMap();
		for (int i =0;i<arr.length;i++) {
			hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
		}
		//for max heap
		//PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparing(e->e.getValue())));
		PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(Comparator.comparing(e->e.getValue()));
		
		
		//populate pqueue of size k, remove head(smalest element to keep queue size k)
		for(Map.Entry<Integer, Integer> entry: hm.entrySet()) {
			queue.add(entry);
			if (queue.size()>k) {
				queue.poll();
				
			}
		}
		
		List<Integer> result = new ArrayList<>();
		while(queue.size()>0) {
			result.add(queue.poll().getKey());
		}
		
		Collections.reverse(result);
		
		for(int i:result) {
			System.out.print(i+" ");
		}
 	}
}
