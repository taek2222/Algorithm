import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) return new int[]{-1};
        
        int base = s / n;
        int r = s % n;
        
        int[] ans = new int[n];
        Arrays.fill(ans, base);
        
        for (int i = n - r; i < n; i++) ans[i]++;
        
        return ans;
    }
}