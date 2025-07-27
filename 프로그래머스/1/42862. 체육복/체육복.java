import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        
        boolean[] reserves = new boolean[n + 2];
        for(int rsv : reserve) {
            reserves[rsv] = true;
        }
        
        for(int i = 0; i < lost.length; i++) {
            if(reserves[lost[i]]) {
                reserves[lost[i]] = false;
                answer++;
                lost[i] = 0;
            }
        }
        
        for(int l : lost) {
            if (l == 0) {
                continue;
            }
            
            if(reserves[l - 1]) {
                reserves[l - 1] = false;
                answer++;
                continue;
            }
            
            if(reserves[l + 1]) {
                reserves[l + 1] = false;
                answer++;
                continue;
            }
        }
        
        return answer;
    }
}