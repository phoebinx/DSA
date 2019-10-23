package DCT.Strings;

public class ValidAnagram {
	public static void main(String args[]) {
		//String str1 = "anagram";
		//String str2 = "nagaram";
		String str1 = "tom marvolo riddle ";
		String str2 = "I am Lord Voldemort";
		System.out.println(isAnagram(str1,str2));
	}
	
	public static boolean isAnagram(String str1,String str2) {
		str1=str1.replace(" ", "").toLowerCase();
		str2=str2.replace(" ", "").toLowerCase();
		
		if (str1.length()!=str2.length())
			return false;
		
		int arr[] = new int[256];
		
		for(int i = 0;i<str1.length();i++) {
			arr[str1.charAt(i)]+=1;
			arr[str2.charAt(i)]-=1;
		}
		
		for(int i:arr) {
			if (i!=0)
				return false;
		}
		return true;
	}
}

