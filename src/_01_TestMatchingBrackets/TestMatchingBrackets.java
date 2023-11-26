package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
	/*
	 * Use a Stack to complete the method for checking if every opening bracket
	 * has a matching closing bracket
	 */
	public static boolean doBracketsMatch(String b) {
		Stack<Character> opening= new Stack();

		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i)=='{') {
				opening.push(b.charAt(i));
			}
			
			if (b.charAt(i)=='}') {
				if(!opening.isEmpty()) {
				opening.pop();
				}else {
					return false;
				}
			}

			
			
		}
		if(opening.isEmpty()) {
		return true;
		}
		else {
			return false;
		}
	}
}
    