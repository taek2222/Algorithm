import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        
        Arrays.sort(info, (i1, i2) -> {
            double ratio1 = (double) i1[0] / i1[1];
            double ratio2 = (double) i2[0] / i2[1];
            return Double.compare(ratio2, ratio1);
        });
        
        int firstThief = 0;
        int secondThief = 0;
        for(int[] arr : info) {
            if(secondThief + arr[1] < m) {
                secondThief += arr[1];
                continue;
            }
            
            firstThief += arr[0];
        }
        
        if(firstThief >= n || secondThief >= m) {
            return -1;
        }
        
        return firstThief;
    }
}