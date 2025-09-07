import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        
        Deque<Integer> serverTimes = new ArrayDeque<>();
        int answer = 0;
        
        for(int player : players) {
            int queueSize = serverTimes.size();
            
            for(int i = 0; i < queueSize; i++) {
                int serverTime = serverTimes.pop();
                serverTime--;
                if(serverTime == 0) {
                    continue;
                }
                
                serverTimes.add(serverTime);
            }
            
            if((m * (serverTimes.size() + 1)) <= player) {
                int serverCount = (player - (m * (serverTimes.size() + 1))) / m;
                serverCount++;
                
                 
                for(int i = 0; i < serverCount; i++) {
                    serverTimes.add(k);
                    answer++;            
                }
            }
            
        }
        
        return answer;
    }
}