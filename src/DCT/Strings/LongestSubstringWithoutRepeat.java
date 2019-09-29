package DCT.Strings;

public class LongestSubstringWithoutRepeat {
	public static void main(String args[]) {
		String str = "pwwkpew";
		System.out.println(LongestSub(str));
	}
	
	public static int LongestSub(String str) {
		boolean[] chr = new boolean[26];
		int count=0,tempCount=0;
		for (int i=0;i<str.length();i++) {
			if (chr[str.charAt(i)-'a'] == true) {
				//chr[str.charAt(i)-'a'] = false;
				chr = new boolean[26];
				count = Math.max(count, tempCount);
				tempCount = 0;
			} else {
				chr[str.charAt(i)-'a'] = true;
				tempCount++;
			}
		}
		return Math.max(tempCount,count);
	}
}
