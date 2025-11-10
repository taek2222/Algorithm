class Solution {
    
    boolean[] visit;
    public int solution(int n, int[][] computers) {
        visit = new boolean[computers.length];
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            dfs(i, computers);
            answer++;
        }
        return answer;
    }
    
    public void dfs(int pos, int[][] computers) {
        for(int i = 0; i < computers[pos].length; i++) {
            if(computers[pos][i] != 1 || visit[i]) {
                continue;
            }
            visit[i] = true;
            dfs(i, computers);
        }
    }
}