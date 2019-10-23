package DCT.Strings;
//https://www.programcreek.com/2014/04/leetcode-anagrams-java/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	public static void main(String args[]) {
		String arrSet []= {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = groupAnagrams(arrSet);
		for(List arrs : result) {
			for(int i = 0;i<arrs.size();i++) {
				System.out.print(arrs.get(i)+" ");
			}
			System.out.println();
		}
	}
	
	public static List<List<String>> groupAnagrams(String arrSet[]) {
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String,ArrayList<String>> hm = new HashMap<>();
		for (String str:arrSet) {
			char charSet[] = new char[26];
			for (int i =0;i<str.length();i++) {
				charSet[str.charAt(i)-'a']++;
				System.out.println(charSet[str.charAt(i)-'a']);
			}
			
			String keyStr = new String(charSet);
			if (hm.containsKey(keyStr)) {
				hm.get(keyStr).add(str);
			} else {
				ArrayList<String> al = new ArrayList<>();
				al.add(str);
				hm.put(keyStr,al);
			}
		}
		result.addAll(hm.values());
		return result;
	}

}
