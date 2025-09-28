import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int orderIndex = 0;
        for(int i = 1; i <= order.length; i++) {
            
            while(i <= order.length && order[orderIndex] == i) {
                answer++;
                orderIndex++;
                i++;
            }
            
            while(!stack.isEmpty() && stack.peek() == order[orderIndex]) {
                stack.pop();
                orderIndex++;
                answer++;
            }
            
            stack.add(i);
        }
        
        while(!stack.isEmpty() && orderIndex < order.length && stack.peek() == order[orderIndex]) {
            stack.pop();
            orderIndex++;
            answer++;
        }
        
        return answer;
    }
}