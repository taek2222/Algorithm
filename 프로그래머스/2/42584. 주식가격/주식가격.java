import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        int[] answer = new int[prices.length];
        
        for(int i = 1; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int i = stack.pop();
            answer[i] = (prices.length-1) - i;
        }
        
        return answer;
    }
}