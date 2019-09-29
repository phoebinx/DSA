//Infix to prefix -> 
//reverse infix string and (-> ) and )-> (
//postfix on reversed string
// reverse postfix output

package DCT.stacks;

import java.util.Stack;

public class InfixToPostfix {
	public static void main(String args[]) {
		String infixExp = "(a-b/c)*(a/k-l)";
		StringBuilder infixForPrefix = new StringBuilder(infixExp).reverse();

		for (int i = 0; i < infixForPrefix.length(); i++) {
			if (infixForPrefix.charAt(i) == '(') {
				infixForPrefix.setCharAt(i, ')');
			} else if (infixForPrefix.charAt(i) == ')') {
				infixForPrefix.setCharAt(i, '(');
			}
		}

		System.out.println(postfix(infixForPrefix.toString()));
		System.out.println("prefix:" + new StringBuilder(postfix(infixForPrefix.toString())).reverse().toString());
	}
	
	public static boolean isOperand(char c) {
		if (c>='a' && c<='z') 
			return true;
		return false;
	}
	
	static int Prec(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        } 
        return -1; 
    } 
	
	public static boolean isHigherPres(char o1, char o2) {
		
		
		return Prec(o1)>=Prec(o2);
	}
	
	public static boolean isOpenBrac(char c) {
		if (c=='(')
			return true;
		return false;
	}
	
	public static boolean isCloseBrac(char c) {
		if (c==')')
			return true;
		return false;
	}
	
	public static String postfix(String exp) {
		Stack<Character> chr = new Stack<>();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i<exp.length();i++) {
			if (isOperand(exp.charAt(i))) {
				str.append(exp.charAt(i));
			} else if (isOpenBrac(exp.charAt(i))) {
				chr.push(exp.charAt(i));
			} else if (isCloseBrac(exp.charAt(i))) {
				while (!chr.isEmpty() && !isOpenBrac(chr.peek())) {
					str.append(chr.peek());
					chr.pop();
				}
				chr.pop();
			} else { //exp[i] is operator , not (), pop till stack has higher pres then push
				while (!chr.isEmpty() && !isOpenBrac(chr.peek()) && isHigherPres(chr.peek(), exp.charAt(i))) {
					str.append(chr.peek());
					chr.pop();
				}
				chr.push(exp.charAt(i));
				
			}
		}
		while (!chr.isEmpty()) {
			str.append(chr.peek());
			chr.pop();
		}
		return str.toString();
	}
}
