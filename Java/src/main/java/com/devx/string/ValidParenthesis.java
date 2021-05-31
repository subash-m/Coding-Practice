package com.devx.string;

import java.util.Stack;

/**
 * @author I348618
 * @since 5/31/2021
 */
public class ValidParenthesis {

    boolean isValidParenthesis(String s) {
        if(s.length()%2!=0)
            return false;

        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()) {
            if(c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if(stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis v = new ValidParenthesis();
        System.out.println(v.isValidParenthesis("({[]()})") == true);
        System.out.println(v.isValidParenthesis("({") == false);
        System.out.println(v.isValidParenthesis("])") == false);
        System.out.println(v.isValidParenthesis("{]") == false);
        System.out.println(v.isValidParenthesis("()") == true);
        System.out.println(v.isValidParenthesis("][") == false);
    }
}
