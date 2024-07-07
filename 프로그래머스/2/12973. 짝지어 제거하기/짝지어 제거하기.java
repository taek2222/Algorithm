import java.util.*;

class Solution {
    Stack<Character> stack = new Stack<>();
    
    private void Check(char c) {
        if(!stack.isEmpty() && stack.peek().equals(c))
            stack.pop();
        else
            stack.push(c);
    }
    
    public int solution(String s) {
        char[] cArray = s.toCharArray();
        
        for(char c : cArray)
            Check(c);
        
        if(stack.isEmpty())
            return 1;

        return 0;
    }
}