import java.util.*;

class Solution {
    
    int[][] pos = {
        {3, 1}, {0, 0}, {0, 1}, {0, 2},
        {1, 0}, {1, 1}, {1, 2},
        {2, 0}, {2, 1}, {2, 2},
    };
    
    int[][] dist = new int[10][10];
    
    int INF = 1_000_000;
    
    public int solution(String numbers) {        
        initDist();
        int length = numbers.length();
        
        int[][][] dp = new int[length+1][10][10];
        for(int i = 0; i <= length; i++) {
            for(int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }
        
        dp[0][4][6] = 0;
        
        for(int i = 0; i < length; i++)  {
            int number = numbers.charAt(i) - '0';
            
            for(int l = 0; l < 10; l++) {
                for(int r = 0; r < 10; r++) {
                    if(dp[i][l][r] == INF) {
                        continue;
                    }
                    
                    int cost = dp[i][l][r];
                    
                    if(number != r)
                        dp[i+1][number][r] = Math.min(dp[i+1][number][r], cost + dist[l][number]);
                    
                    if(number != l)
                        dp[i+1][l][number] = Math.min(dp[i+1][l][number], cost + dist[r][number]);
                }
            }
        }
        
        int answer = INF;
        for (int l = 0; l < 10; l++)
            for (int r = 0; r < 10; r++)
                answer = Math.min(answer, dp[length][l][r]);

        return answer;
    }
    
    public void initDist() {
        
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                dist[i][j] = (i == j) ? 0 : INF;
            }
        }
        
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(i == j) dist[i][j] = 1;
                else {
                    int dx = Math.abs(pos[i][0] - pos[j][0]);
                    int dy = Math.abs(pos[i][1] - pos[j][1]);
                    
                    if(dx + dy == 1) dist[i][j] = 2;
                    else if(dx == 1 && dy == 1) dist[i][j] = 3;
                }
            }
        }
        
        for(int k = 0; k < 10; k++) {
            for(int i = 0; i < 10; i++) {
                for(int j = 0; j < 10; j++) {
                    if(dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                    }
                }
            }
        }
    }
}