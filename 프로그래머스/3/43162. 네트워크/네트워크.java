import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        
        ArrayList<Integer>[] connect = new ArrayList[n];
        
        for(int i = 0; i < n; i++)
            connect[i] = new ArrayList<>();
        
        for(int i = 0; i < computers.length; i++)
            for(int j = 0; j < computers[0].length; j++) {
                if(i == j)
                    continue;
                if(computers[i][j] == 1)
                    connect[i].add(j);
            }
        
        boolean[] visit = new boolean[n];
        int answer = 0;
        
        for(int i = 0; i < visit.length; i++) {
            if(visit[i])
                continue;
            
            answer++;
            visit[i] = true;
            
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            
            while(!queue.isEmpty()) {
                int nowCom = queue.poll();
                
                ArrayList<Integer> array = connect[nowCom];
                
                for(int com : array) {
                    if(visit[com])
                        continue;
                    
                    visit[com] = true;
                    queue.add(com);
                }
            }
        }
        
        return answer;
    }
}