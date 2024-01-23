package stack_queue;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
public class Problem2 {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                Integer opnd1 = stack.pop();
                Integer opnd2 = stack.pop();
                char op = token.charAt(0);
                int rst = caculate(op, opnd2, opnd1);

                stack.push(rst);
            }
        }

        return stack.pop();
    }

    private static int caculate(char op, Integer opnd1, Integer opnd2) {
        if (op == '+') {
            return opnd1 + opnd2;
        } else if (op == '-') {
            return opnd1 - opnd2;
        } else if (op == '*') {
            return opnd1 * opnd2;
        } else {
            return opnd1 / opnd2;
        }
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}