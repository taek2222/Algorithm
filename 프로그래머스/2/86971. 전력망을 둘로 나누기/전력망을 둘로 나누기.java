import java.util.*;

class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Integer>[] wire;
    
    public int solution(int n, int[][] wires) {
        wire = new ArrayList[n+1];
        
        for(int i = 0; i < n+1; i++)
            wire[i] = new ArrayList<>();
        
        // 정점에 연결 간선 연결
        for(int i = 0; i < n-1; i++) {
            wire[wires[i][0]].add(wires[i][1]);
            wire[wires[i][1]].add(wires[i][0]);
        }
        
        // 1 ~ n번째의 연결된 만큼 반복 시작
        for(int i = 1; i < n; i++)
            for(int number : wire[i])
                BFS(n, i, number);
        
        return answer;
    }
    
    public void BFS(int n, int cut, int start) {
        boolean[] visit = new boolean[n+1];
        visit[cut] = true;
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visit[start] = true;
        int count = 0;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            count++;
            
            for(int number : wire[now]) {
                if(visit[number])
                    continue;
                
                visit[number] = true;
                queue.add(number);
            }
        }
        
        int result = Math.abs(count-(n-count));
        
        if(result < answer)
            answer = result; 
    }
}