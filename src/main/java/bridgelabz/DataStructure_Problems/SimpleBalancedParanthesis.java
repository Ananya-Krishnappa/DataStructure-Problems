/**
 * Purpose:ake an Arithmetic Expression such as 
(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3) where parentheses are used to order the performance of operations. Ensure parentheses must appear in a balanced fashion. 

 * @author Ananya K
 * @version 1.0
 * @since 16/06/2021
 * 
 */
package bridgelabz.DataStructure_Problems;

public class SimpleBalancedParanthesis {
	public static void main(String[] args) {
		SimpleBalancedParanthesis sbp = new SimpleBalancedParanthesis();
		String expr = "(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)";
		String expr1 = "[{()}]";
		sbp.checkIsBalanced(expr);
		sbp.checkIsBalanced(expr1);
	}

	/**
	 * To check if the string is balanced or not
	 * 
	 * @param expr string expression
	 */
	private void checkIsBalanced(String expr) {
		if (areBracketsBalanced(expr)) {
			System.out.println(expr + " is Balanced ");
		} else {
			System.out.println(expr + " is Not Balanced ");
		}
	}

	/**
	 * to push open parenthesis “(“ and pop closed parenthesis “)”. At the End of
	 * the Expression if the Stack is Empty then the Arithmetic Expression is
	 * Balanced.
	 * 
	 * @param expr
	 * @return
	 */
	private boolean areBracketsBalanced(String expr) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);
			if (x == '(' || x == '[' || x == '{') {
				stack.push(x);
				continue;
			}
			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;
			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;
			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}
		return (stack.isEmpty());
	}

}
