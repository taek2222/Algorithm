import java.util.*;

class Solution {
    
    static List<int[]> moves = new ArrayList<>();
    
    public int[][] solution(int n) {
        List<int[]> answer = new ArrayList<>();
        move(n, 1, 3, 2);
        int[][] ans = new int[moves.size()][2];
        
        for(int i = 0; i < moves.size(); i++) {
            ans[i] = moves.get(i);
        }
        
        return ans;
    }
    
    public void move(int n, int start, int to, int mid) {
        if (n == 1) {
            moves.add(new int[]{start, to});
            return;
        }
        
        move(n - 1, start, mid, to);
        moves.add(new int[]{start, to});
        move(n - 1, mid, to, start);
    }
}