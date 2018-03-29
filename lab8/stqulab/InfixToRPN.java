package stqulab;

/**
 * InfixToRPN.java
 *
 * Program to convert a string from infix notation to
 * reverse polish notation.
 *
 * @author 
 * CSCI 245, Wheaton College, Spring 2008
 * March 17, 2008.
 * Lab 8 
 */


public class InfixToRPN {

    /**
     * Convert a string containing an arithmetic expression
     * in infix notation to an equivalent string in 
     * reverse polish (postfix) notation.
     * @param infix The given string, assumed to contain only
     * digits, operators, and parentheses
     * @return The string, now convered to RPN
     */
	public static String infixToRPN(String infix) {
		
		Stack<Character> op = new ListStack<Character>();
		boolean space = false;
		String operators = "+-*/";
		String out = "";
		String digits = "01223456789";
		for(int i = 0; i < infix.length(); i++) {
			if(infix.charAt(i) == ')'){
				out += " ";
				out += op.pop();
				space = true;
			} else if(operators.contains(infix.substring(i, i+1))) {
				op.push(infix.charAt(i));
				out+=" ";
				space = false;
			} else if(digits.contains(infix.substring(i, i+1))) {
				if(space) {
					out += " ";
					space = false;
				}
				out += infix.charAt(i);
			}
		}

	    return out;
	}
	
   public static void main(String[] args) {

       System.out.println(infixToRPN(args[0]));
   }
}

