import java.lang.Math; // Math 호출

class Solution {
    public long solution(int k, int d) {
        long total = 0;
        int yMaxDistance;
        long xx, dd;
        
        for(int i = 0; i <= d; i += k) {
            xx = (long)Math.pow(i, 2);
            dd = (long)Math.pow(d, 2);
            yMaxDistance = (int)Math.sqrt(dd - xx);
            
            total += (long)(yMaxDistance / k) + 1;
        }
        
        return total;
    }
}