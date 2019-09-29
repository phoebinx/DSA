package DCT.Strings;

public class printAllSubString {

	public static void main(String args[]) {
		String input = "baikomalkoko";
		String str[] = {"ko","a"};
		replaceStr(input, str);
	}
	
	public static void printSub(String input, String str) {
		
		StringBuilder sb = new StringBuilder();
		int start = 0;
		int end = 0;
		
		while(input.indexOf(str, end)!=-1) {
			start = input.indexOf(str, end);
			end = start+str.length();
			System.out.println(input.substring(start,end));
		}
	}
	
	public static void replaceStr(String input, String str[]) {
		String open = "<b>";
		String close = "</b>";
		StringBuilder sb = new StringBuilder();
		
		
		for (String ele:str) {
			int start = 0;
			int end = 0;
			sb.delete(0, sb.length());
			System.out.println(input);
			while(input.indexOf(ele, end)!=-1) {
				start = input.indexOf(ele, end);
				sb.append(input.substring(end,start));
				end = start+ele.length();
				sb.append(open);
				sb.append(input.substring(start,end));
				sb.append(close);
			}
			if (end<input.length()) {
				sb.append(input.substring(end,input.length()));
			}
			input = sb.toString();
		}
		System.out.println(sb.toString());
	}
}
