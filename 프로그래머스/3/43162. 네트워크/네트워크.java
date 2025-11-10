import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visit = new boolean[n];
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            if(visit[i])
                continue;
            
            answer++;
            
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            visit[i] = true;
            
            while(!queue.isEmpty()) {
                int nowCom = queue.poll();
            
                for(int j = 0; j < computers[i].length; j++) {
                    if(nowCom == j || visit[j] || computers[nowCom][j] == 0)
                        continue;
                    
                    visit[j] = true;
                    queue.add(j);
                }
            }
        }
        
        return answer;
    }
}