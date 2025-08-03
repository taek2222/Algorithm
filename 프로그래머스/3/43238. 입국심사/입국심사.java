import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        long max = times[times.length - 1];
        long min = times[0];
        
        max = max * n; 
        
        long answer = max;
        while(min <= max) {
            long mid = (max + min) / 2;
            
            long count = 0;
            for(int time : times) {
                count += mid / time;
            }
            
            if(count < n) {
                min = mid + 1;
            } else {
                answer = Math.min(answer, mid);
                max = mid - 1;
            }
        }
        
        return answer;
    }
}