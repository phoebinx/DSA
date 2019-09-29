package StringsAndArrays;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class CommonElementsLists {
	public static void main(String args[]) {
		ArrayList <String> s1 = new ArrayList<>();
		s1.add("cat");
		s1.add("bat");
		s1.add("rat");
		s1.add("fat");
		ArrayList <String> s2 = new ArrayList<>();
		s2.add("cat");
		s2.add("mat");
		s2.add("sat");
		s2.add("fat");
		
		ArrayList<String> s3 = commonElements(s1,s2);
		if(s3.size()>0) {
			System.out.println("Common elements are "+s3);
			
		} else {
			System.out.println("Zero common elements");
		}
	}
	
	public static ArrayList commonElements(ArrayList<String> s1, ArrayList<String> s2) {
		ArrayList<String> s3 = new ArrayList<>();
		Hashtable<String, Integer> h1 = new Hashtable<>();
		
		for (String str1 : s1) {
			if (!h1.containsKey(str1)) {
				h1.put(str1, 1);
			}
		}
		
		for (String str1 : s2) {
			if (h1.containsKey(str1)) {
				int val = h1.get(str1);
				h1.put(str1, val+1);
			} else {
				h1.put(str1, 1);
			}
		}
		
		Set<String> keys = h1.keySet();
		for(String k : keys) {
			System.out.println(k+" "+h1.get(k));
			if (h1.get(k) >1) {
				s3.add(k);
			}
		}
		return s3;
	}
}

//time complexity: O(n) 
// another simple way is to list1.retainAll(list2); 
