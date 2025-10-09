import java.util.*;

class Solution {
    
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{1, -1, 0, 0};
    boolean[][] visit;
    int count;
    
    
    public int solution(int[][] land) {
        Map<Integer, Integer> petroleum = new HashMap<>();
        visit = new boolean[land.length][land[0].length];
        
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[0].length; j++) {
                if(land[i][j] == 0 || visit[i][j]) {
                    continue;
                }
                visit[i][j] = true;
                count = 0;
                dfs(petroleum.size() + 1, land, i, j);
                
                petroleum.put(petroleum.size() + 1, count);
            }
        }
        
        int answer = 0;
        boolean[] checked;
        for(int i = 0; i < land[0].length; i++) {
            int total = 0;
            checked = new boolean[petroleum.size() + 1];
            for(int j = 0; j < land.length; j++) {
                int index = land[j][i];
                if(index == 0 || checked[index]) continue;
                
                checked[index] = true;
                total += petroleum.get(index);
            }
            answer = Math.max(answer, total);
        }
        
        return answer;
    }
    
    public void dfs(int index, int[][] land, int x, int y) {
        land[x][y] = index;
        count++;
        
        for(int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX < 0 || nextY < 0 || nextX >= land.length || nextY >= land[0].length) {
                continue;
            }
            
            if(visit[nextX][nextY] || land[nextX][nextY] == 0) {
                continue;
            }
            
            visit[nextX][nextY] = true;
            dfs(index, land, nextX, nextY);
        }
    }
}