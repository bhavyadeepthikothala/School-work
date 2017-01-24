package com.assignment2;

public class BalancedExpression {
	
    public static boolean isBalanced(String expresssion) {
        java.util.Stack<Character> stack  = new java.util.Stack<Character>();
        for(int i = 0; i < expresssion.length(); i++) {
            char c = expresssion.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty()) 
                	return false;
                if(stack.pop() != '[') 
                	return false;
            } else if(c == ')') {
                if(stack.isEmpty()) 
                	return false;
                if(stack.pop() != '(') 
                	return false;
            } else if(c == '}') {
                if(stack.isEmpty()) 
                	return false;
                if(stack.pop() != '{') 
                	return false;
            }
        }
        return stack.isEmpty();
    }
    
    public static void main(String args[]) {
        System.out.println(isBalanced("(){[()]}"));
    }

	
}
