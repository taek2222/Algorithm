import java.util.*;

class Solution {
    
    int[] xArray = new int[]{0, 0, -1, 1};
    int[] yArray = new int[]{1, -1, 0, 0};
    
    int[][] map;
    boolean[][] visit;
    int value;
    
    public int[] solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        visit = new boolean[maps.length][maps[0].length()];
        
        List<Integer> answers = new ArrayList<>();
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                char c = maps[i].charAt(j);
                if(c == 'X') map[i][j] = 0;
                else map[i][j] = c - '0';
            }
        }
        
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(visit[i][j] || map[i][j] == 0) {
                    continue;
                }
                
                value = 0;
                dfs(i, j);
                answers.add(value);
            }
        }
        
        int[] answer = answers.stream()
            .mapToInt(Integer::intValue)
            .sorted()
            .toArray();
        
        if(answers.size() == 0) {
            return new int[]{-1};
        }
        return answer;
    }
    
    private void dfs(int x, int y) {
        visit[x][y] = true;
        value += map[x][y];
        
        for(int i = 0; i < xArray.length; i++) {
            int nextX = x + xArray[i];
            int nextY = y + yArray[i];
            
            if(nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length) {
                continue;
            }
            
            if(visit[nextX][nextY] || map[nextX][nextY] == 0) {
                continue;
            }
            
            dfs(nextX, nextY);
        }
    }
}