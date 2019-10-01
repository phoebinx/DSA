//package DCT;
//
//import java.util.Arrays;
//import java.util.HashSet;
//
//public class WordBreakWithAppendTag {
//	HashSet<String> has = new HashSet<>();
//	StringBuilder sb = new StringBuilder();
//	String open = "<b>";
//	String close = "</b>";
//	
//	public static void main(String args[]) {
//		String str = "applesandapples";
//		String arr[] = {"apples"};
//		WordBreakWithAppendTag obj= new WordBreakWithAppendTag();
//		obj.has.addAll(Arrays.asList(arr));
//		 obj.modifyString(str);
//		System.out.println(obj.sb.toString());
//		
//	}	
//	
//	public void modifyString(String str) {
//		if (has.contains(str)) {
//			sb.append(open);
//			sb.append(str);
//			sb.append(close);
//			
//		} else {
//			int i = 0;
//			for (i=1;i<str.length();i++) {
//				if (has.contains(str.substring(0,i))) {
//					sb.append(open);
//					sb.append(str.substring(0,i));
//					sb.append(close);
//					modifyString(str.substring(i,str.length()));
//				} else {
//					modifyString(str.substring(i,str.length()));
//				}
//			}
//			
//		}
//	}
//}
