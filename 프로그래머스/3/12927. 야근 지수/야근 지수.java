import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++) {
            queue.add(works[i]);
        }
        
        while(n > 0) {
            int number = queue.poll();
            if(number == 0) {
                break;
            }
            number--;
            n--;
            queue.offer(number);
        }
        
        long answer = 0;
        for(int work : queue) {
            answer += work * work;
        }
        
        return answer;
    }
}