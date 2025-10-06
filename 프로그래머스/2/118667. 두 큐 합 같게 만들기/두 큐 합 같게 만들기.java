import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long qTotal1 = 0;
        long qTotal2 = 0;
        
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        
        for(int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            qTotal1 += queue1[i];
        }
        
        for(int i = 0; i < queue2.length; i++) {
            q2.add(queue2[i]);
            qTotal2 += queue2[i];
        }
        
        for(int i = 0; i < queue1.length * 3; i++) {
            if(qTotal1 > qTotal2) {
                int value = q1.pop();
                q2.add(value);
                qTotal1 -= value;
                qTotal2 += value;
            } else if(qTotal1 < qTotal2) {
                int value = q2.pop();
                q1.add(value);
                qTotal2 -= value;
                qTotal1 += value;
            } else {
                break;
            }
            answer++;
        }
        
        if(qTotal1 == qTotal2) {
            return answer;
        }
        
        return -1;
    }
}