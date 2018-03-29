package stqulab;

/**
 * VerifyNested.java
 *
 * Program to determine whether a string contains
 * proper nesting of grouping symbols. For example, 
 * the line "( a ( {b & 6 } [ 1 t ^] ~ ) )" is 
 * properly nested; "( a ( {b & 6 ) [ 1 t ^] ~ ) }" is 
 * not.
 *
 * @author Joel Armstrong and Mitchell Smith
 * CSCI 245, Wheaton College, Spring 2008
 * March 29, 2018
 * Lab 8 
 */


public class VerifyNested {

    /**
     * Determine whether the delimiters that appear in a given
     * string are properly nested.
     * @param s The given string
     * @return True if the delimiters are properly nested, false otherwise
     */
	public static boolean verifyNested(String s) {
		Stack<Character> st = new ListStack<Character>();
		String leftSymbols = "({[<";
		String rightSymbols =")}]>";
		for(int i = 0; i < s.length(); i++){
			if (leftSymbols.contains(s.substring(i,i+1))) 
				st.push(s.charAt(i));
			else if(rightSymbols.contains(s.substring(i,i+1))) {
				if(rightSymbols.indexOf(s.charAt(i)) != leftSymbols.indexOf(st.pop()))
						return false;
			}
		}
		if (st.empty()) return true;
		return false;
	}
	
   public static void main(String[] args) {
	   if (verifyNested(args[0]))
		   System.out.println("Yes");
	   else
		   System.out.println("No");

   }
}
