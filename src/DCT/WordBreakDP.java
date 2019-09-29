package DCT;

import java.util.Arrays;
import java.util.HashSet;

public class WordBreakDP {
	
	public static HashSet<String> hs = new HashSet<String>();
	public static HashSet<String> mems = new HashSet<String>();
	public static void main(String args[]) {
		long startTime = System.nanoTime();
		String arr[] = {"cats", "dog", "sand", "and", "cat", "apple", "pen"};
		hs.addAll(Arrays.asList(arr));
		long endTime = System.nanoTime();
		System.out.println(wordBreak("applepenapple"));
		System.out.println("Took "+(endTime - startTime) + " ns");
	}

	public static boolean wordBreak(String s) {
		if (hs.contains(s)) {
			return true;
		} else if (s.length() == 0) {
			return true;
		} else if (mems.contains(s)) {
			return true;
		} else {
			for (int i = 1; i<=s.length();i++) {
				if (hs.contains(s.substring(0,i)) && wordBreak(s.substring(i,s.length()))) {
					mems.add(s);
					return true;
				}
			}
		}
		return false;
	}
}
