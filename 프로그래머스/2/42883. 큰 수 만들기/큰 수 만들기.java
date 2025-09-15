import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String[] numbers = number.split("");
        
        Stack<String> stack = new Stack<>();
        int i = 0;
        int deleteCount = 0;
        
        while(i < numbers.length && deleteCount != k) {
            if(stack.isEmpty()) {
                stack.add(numbers[i]);
                i++;
                continue;
            }
            
            int num = Integer.parseInt(numbers[i]);
            while(Integer.parseInt(stack.peek()) < num) {
                stack.pop();
                deleteCount++;
                if(deleteCount == k || stack.isEmpty()) {
                    break;
                }
            }
            
            stack.add(numbers[i]);
            i++;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        sb.reverse();
        
        for(; i < numbers.length - (k - deleteCount); i++) {
            sb.append(numbers[i]);
        }
        
        return sb.toString().substring(0, numbers.length - k);
    }
}