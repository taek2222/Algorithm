import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n][m];
        for(int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        dp[0][0] = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dp[i][j] == -1) continue;
                if(i == 0 && j == 0) continue;
                
                int left = 0;
                int top = 0;
                if(j > 0 && dp[i][j - 1] != -1) {
                    left = dp[i][j - 1];
                }
                
                if(i > 0 && dp[i - 1][j] != -1) {
                    top = dp[i - 1][j];
                }
                
                dp[i][j] = (left + top) % 1_000_000_007;
            }
        }
        
        // System.out.println(Arrays.deepToString(dp));
        
        return dp[n - 1][m - 1];
    }
}

/**
1. 2중 for문
2. 4방면 조사 (물 있는 지 확인)
3. 마지막 학교 답
**/