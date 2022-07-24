package com.bracketBalancer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Objects;

public class bracketBalancer {

	/**
	 * as number of inputs is small, we can hardcode the brackets
	 */
	static String openingBrackets = "({[";
	static String closingBrackets = ")}]";

	static String balancedMsg = "The entered String has Balanced Brackets";
	static String unbalancedMsg = "The entered Strings do not contain Balanced Brackets";

	/**
	 * let us also create a hash map to store each bracket against its corresponding
	 * matching bracket (thus making the algorithm a little more flexible).
	 */
	static HashMap<Character, Character> bracketMatchMap = new HashMap<Character, Character>();

	/**
	 * let us create a stack to hold the brackets as they are received. Dequeue
	 * interface is used as the java documentation says that stack is legacy and
	 * deque should be preferred.
	 * https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
	 */
	Deque<Character> deque = new ArrayDeque<Character>();

	// populating the has map at runtime using constructor
	public bracketBalancer() {
		bracketMatchMap.put(')', '(');
		bracketMatchMap.put('}', '{');
		bracketMatchMap.put(']', '[');
	}

	/**
	 * function to parse input string and declare balanced or unbalanced logic is
	 * the following: - If opening brackets ({[ are received, insert into stack - If
	 * closing brackets are received, pop out 1 element from stack. - If popped
	 * bracket does not match closing brace, string not balanced. - If end of input
	 * the stack is not empty, the string is not balanced. - If neither of above
	 * conditions are true, then string must be balanced.
	 * 
	 * @param input - String received from calling function
	 */

	public void checkBrackets(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (openingBrackets.indexOf(input.charAt(i), 0) != -1)
				deque.addFirst(input.charAt(i));

			else if (closingBrackets.indexOf(input.charAt(i)) != -1) {
				if (Objects.isNull(deque.peekFirst())) {// case when closing brace is before even the first opening
														// brace
					System.out.println(unbalancedMsg);
					return;
				} else if (!bracketMatchMap.containsKey(input.charAt(i))) { // case when the closing brace is out of
																			// hash
																			// map
					System.out.println(unbalancedMsg);
					return;
				} else if (bracketMatchMap.get(input.charAt(i)) != deque.removeFirst()) { // case when the closing brace
																							// does not correspond to
																							// opening brace in hash map
					System.out.println(unbalancedMsg);
					return;
				}
			}
		}

		if (deque.size() != 0) { // case when the stack is still not empty after the loop has gone through all
									// characters of string (so dangling opening brackets are present)
			System.out.println(deque.toString());
			System.out.println("Trip 2 : The entered Strings do not contain Balanced Brackets");
		}

		else // if all the rejection criteria above did not occur, the string must be
				// balanced.
			System.out.println("The entered String has Balanced Brackets");
	}
}
