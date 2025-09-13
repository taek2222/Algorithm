import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, ((t1, t2) -> Integer.compare(t1[1], t2[1])));
        
        int pos = 0;
        for(int[] target : targets) {
            if(target[0] < pos) {
                continue;
            }
            
            pos = target[1];
            answer++;
        }
        
        return answer;
    }
}