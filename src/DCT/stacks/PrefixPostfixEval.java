package DCT.stacks;

import java.util.Stack;

//ASCII 0-> 48
//ASCII 9-> 57
public class PrefixPostfixEval {
	
	public static void main(String args[]) {
		String exprsn2 = "+9*26";
		String exprsn = "926*-";
        System.out.println(evalPostfix(exprsn));
        System.out.println(evalPrefix(exprsn2));
	}
	
	public static boolean isOperand(char c) {
		if (c>=48 && c<=57) {
			return true;
		}
		return false;
	}
	
	public static double evalPostfix(String exp) {
		//62- -> 6-2
		
		Stack<Double> post = new Stack<>();
		for (int i = 0;i<exp.length();i++) {
			if (isOperand(exp.charAt(i))) {
				post.add((double)exp.charAt(i)-48);
			} else {
				double op2 = post.peek();
				post.pop();
				double op1 = post.peek();
				post.pop();
				
				switch(exp.charAt(i)) {
				case '+':
					post.add(op1+op2);
					break;
				case '-':
					post.add(op1-op2);
					break;
				case '*':
					post.add(op1*op2);
					break;
				case '/':
					post.add(op1/op2);
					break;
				}
			}
		}
		return post.peek();
	}
	
	public static double evalPrefix(String exp) {
		//-62 -> 6-2
		
		Stack<Double> post = new Stack<>();
		for (int i = exp.length()-1;i>=0;i--) {
			if (isOperand(exp.charAt(i))) {
				post.add((double)exp.charAt(i)-48);
			} else {
				double op1 = post.peek();
				post.pop();
				double op2 = post.peek();
				post.pop();
				
				switch(exp.charAt(i)) {
				case '+':
					post.add(op1+op2);
					break;
				case '-':
					post.add(op1-op2);
					break;
				case '*':
					post.add(op1*op2);
					break;
				case '/':
					post.add(op1/op2);
					break;
				}
			}
		}
		return post.peek();
	}

}
