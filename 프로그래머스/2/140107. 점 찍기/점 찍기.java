import java.lang.Math; // Math 호출

class Solution {
    public long solution(int k, int d) {
        
//         1차 시도 (전체 탐색) - 시간 초과
//         long total = 0; // 총 갯수 값
        
//         for(int i = 0; i <= d; i += k) {
//             for(int j = 0; j <= d; j += k) {
//                 check = Math.sqrt(i*i + j*j);
                
//                 if(check > d)
//                     break;
                
//                 total++;
//             }
//         }
//         return total;
        
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