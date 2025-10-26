import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skills) {
        int[][] sum = new int[board.length + 1][board[0].length + 1];
        for(int[] skill : skills) {
            int cost = skill[5];
            if(skill[0] == 1) {
                cost = -skill[5];
            }
            
            sum[skill[1]][skill[2]] += cost;
            sum[skill[3] + 1][skill[4] + 1] += cost;
            
            sum[skill[1]][skill[4] + 1] += -cost;
            sum[skill[3] + 1][skill[2]] += -cost;
        }
        
        for(int i = 0; i < sum.length; i++) {
            for(int j = 1; j < sum[0].length; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }
        
        for(int j = 0; j < sum[0].length; j++) {
            for(int i = 1; i < sum.length; i++) {
                sum[i][j] += sum[i - 1][j];
            }
        }
        
        int answer = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] += sum[i][j];
                if(board[i][j] >= 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}