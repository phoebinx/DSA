package DCT.Strings;

public class ValidPallindrome {
	public static void main(String args[]) {
		String str = "A man, a plan, a canal: Panama";
		System.out.println(isPallindrome(str.replaceAll(" ", "").toLowerCase()));
	}
	
	public static boolean isPallindrome(String str) {
		int start = 0;
		int end = str.length()-1;
		while(start<end) {
			if (!isAlphanumeric(str.charAt(start)))
				start++;
			if (!isAlphanumeric(str.charAt(end)))
				end--;
			if (str.charAt(start)!=str.charAt(end)) 
				return false;
			start++;
			end--;
		}
		return true;
	}
	
	public static boolean isAlphanumeric(char c) {
		if ((c>='a' && c<='z') || (c>='A' && c<='Z')) {
			return true;
		}
		return false;
	}
}
