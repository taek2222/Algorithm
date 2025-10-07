import java.util.*;

class Solution {
    
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{1, -1, 0, 0};
    boolean[][] visit;
    int count;
    
    public int[] solution(int m, int n, int[][] picture) {
        visit = new boolean[m][n];
        
        int areaCount = 0;
        int maxSize = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visit[i][j] || picture[i][j] == 0) {
                    continue;
                }
                
                count = 1;
                visit[i][j] = true;
                dfs(picture, i, j);
                
                areaCount++;
                maxSize = Math.max(maxSize, count);
            }
        }
        
        return new int[]{areaCount, maxSize};
    }
    
    public void dfs(int[][] picture, int x, int y) {
        for(int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if(nextX < 0 || nextY < 0 || nextX >= picture.length || nextY >= picture[0].length) continue;
            if(picture[x][y] != picture[nextX][nextY] || visit[nextX][nextY]) continue;
            
            count++;
            visit[nextX][nextY] = true;
            dfs(picture, nextX, nextY);
        }
    }
}