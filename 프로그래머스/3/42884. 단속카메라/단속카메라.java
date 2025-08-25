import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, ((r1, r2) -> Integer.compare(r1[1], r2[1])));
        
        int cameraCount = 1;
        int cameraEndPos = routes[0][1];
        for(int[] route : routes) {
            if(cameraEndPos < route[0]) {
                cameraCount++;
                cameraEndPos = route[1];
            }
        }
        
        return cameraCount;
    }
}