package DCT.Strings;

public class ValidAnagram {
	public static void main(String args[]) {
		String str1 = "anagram";
		String str2 = "nagaram";
		System.out.println(isAnagram(str1,str2));
	}
	
	
}

//wrong
//public static boolean isAnagram(String str1,String str2) {
//	if (str1.length() != str2.length()) 
//		return false;
//	
//	int value = 0;
//	
//	for (int i=0;i<str1.length();i++) {
//		value = value^str1.charAt(i);
//		value = value^str2.charAt(i);
//	}
//	return value==0;
//}