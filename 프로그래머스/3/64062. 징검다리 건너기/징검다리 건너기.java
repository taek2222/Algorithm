import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        int[] answers = new int[stones.length];
        
        for(int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            
            while(!deque.isEmpty() && stones[deque.peekLast()] <= stone) {
                deque.pollLast();
            }
            
            deque.add(i);
            
            if(deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            
            if(i >= k - 1) {
                answers[i - (k - 1)] = stones[deque.peekFirst()];
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 0; stones.length - (k - 1) > i; i++) {
            answer = Math.min(answer, answers[i]);
        }
        
        return answer;
    }
}