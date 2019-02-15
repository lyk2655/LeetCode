package linyk2655;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 * 
 * Example 1:求最长有效括号
 * 
 * Input: "(()" Output: 2 Explanation: The longest valid parentheses substring is "()" Example 2:
 * 
 * Input: ")()())" Output: 4 Explanation: The longest valid parentheses substring is "()()"
 * 
 * @author linyk001
 * @date 2019/02/15
 */
public class P032_Longest_Valid_Parentheses {
    public static int longestValidParentheses(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int res = 0, start = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            // 如果遇到左括号，则将当前下标压入栈
            if (s.charAt(i) == '(') {
                stack.push(i);
                // 如果遇到右括号
            } else if (s.charAt(i) == ')') {
                // 如果当前栈为空,则将下一个坐标位置记录到start
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    // 如果栈不为空，则将栈顶元素取出，此时若栈为空，则更新结果和i - start + 1中的较大值，否则更新结果和i - 栈顶元素中的较大值
                    stack.pop();
                    if (stack.empty()) {
                        res = res > i - start + 1 ? res : i - start + 1;
                    } else {
                        res = res > i - stack.lastElement() ? res : i - stack.lastElement();
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
        System.out.println(longestValidParentheses("()()(()"));
        System.out.println(longestValidParentheses("()(()()"));
        System.out.println(longestValidParentheses("))))((()(("));
        System.out.println(longestValidParentheses(")()())"));
    }
}
