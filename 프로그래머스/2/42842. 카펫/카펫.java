import java.util.*;

class Solution {
    
    public int[] solution(int brown, int yellow) {
        List<int[]> ans = new ArrayList<>();
        
        int total = brown + yellow;
        for(int i = 1; i < total; i++) {
            if(total % i == 0) {
                int x = total / i;
                if(i > x) break;
                
                ans.add(new int[]{x, i});
            }
        }
        
        for(int i = 0; i < ans.size(); i++) {
            int[] current = ans.get(i);
            int bCount = 0;
            int yCount = 0;
            
            for(int j = 1; j <= current[0]; j++) {
                for(int k = 1; k <= current[1]; k++) {
                    if(j == 1 || k == 1 || j == current[0] || k == current[1]) {
                        bCount++;
                        continue;
                    }
                    yCount++;
                }
            }
            
            if(bCount == brown && yCount == yellow) {
                return current;
            }
        }
        
        return null;
    }
}