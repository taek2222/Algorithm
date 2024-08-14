import java.util.*;

class Solution {
    
    static int[][] Dungeons;
    static boolean[] visit;
    static int result = Integer.MIN_VALUE;

        
    public int solution(int k, int[][] dungeons) {
        Dungeons = dungeons;
        visit = new boolean[dungeons.length];
        
        backTracking(k, 1);
        return result;
    }
    
    public void backTracking(int k, int cnt) { // 남은 피로도 | 던전 횟수
        
        for(int i = 0; i < Dungeons.length; i++) {
            
            if(!visit[i] && k >= Dungeons[i][0]) {
                visit[i] = true;
                
                backTracking(k - Dungeons[i][1], cnt + 1);
                result = Math.max(result, cnt);
                visit[i] = false;
            }
        }
    }
}