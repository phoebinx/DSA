package DCT.Strings;

import java.util.Stack;

public class ValidParantheses {
	public static void main(String args[]) {
		String inStr = "()[]{}";
		System.out.println(isValidString(inStr));
	}

	public static boolean isValidString(String inStr) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < inStr.length(); i++) {
			char in = inStr.charAt(i);
			if (in == '(' || in == '[' || in == '{') {
				st.push(in);
			} else if (in == ')' || in == ']' || in == '}') {
				char out = st.pop();
				switch (in) {
				case ')':
					return out == '(';
				case '}':
					return out == '{';
				case ']':
					return out == '[';
				}
			}
		}
		return false;
	}
}