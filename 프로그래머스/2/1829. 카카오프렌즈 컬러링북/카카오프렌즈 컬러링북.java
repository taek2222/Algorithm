import java.util.*;

class Solution {
    
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{1, -1, 0, 0};
    boolean[][] visit;
    int count;
    
    public int[] solution(int m, int n, int[][] picture) {
        
        List<Integer> number = new ArrayList<>();
        visit = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visit[i][j] || picture[i][j] == 0) {
                    continue;
                }
                
                count = 1;
                visit[i][j] = true;
                dfs(picture, i, j);
                
                number.add(count);
            }
        }
        
        Collections.sort(number, Collections.reverseOrder());
        int[] answer = new int[2];
        answer[0] = number.size();
        answer[1] = number.get(0);
        
        return answer;
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