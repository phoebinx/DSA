package DCT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
	
	public static void main(String argsp[]) {
		String s = "catsandog";
		String arr[] = {"cats", "dog", "sand", "and", "cat"};
		List<String> wordDict = new ArrayList<String>(Arrays.asList(arr));
		System.out.println(wordBreak(s, wordDict));
		
	}
	
	public static boolean wordBreak(String s, List<String> wordDict) {
		StringBuilder sb = new StringBuilder(s);
		
		int start = 0;
		int end = 0;
			for (String str : wordDict) {
				while(sb.indexOf(str) != -1) {
					start = sb.indexOf(str);
					end = start+str.length();
					sb.replace(start, end, "");
				}
			}
 	        return sb.length()==0;
	       
    }
}
