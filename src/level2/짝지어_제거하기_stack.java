package src.level2;

import java.util.Stack;

public class 짝지어_제거하기_stack {
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()){
                stack.push(s.charAt(i));
            }else{
                if(stack.peek() == s.charAt(i)){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }

        answer = stack.empty() ? 1 : 0;
        return answer;
    }
}
