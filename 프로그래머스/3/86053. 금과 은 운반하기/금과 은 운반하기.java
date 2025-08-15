class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long min = 1L;
        long max = 2_000_000_000L * 200_000L;
        
        long answer = max;
        while(max >= min) {
            long mid = (min + max) / 2;
            
            long goldTotal = 0;
            long silverTotal = 0;
            long total = 0;
            
            for(int i = 0; i < g.length; i++) {
                long cnt = 0;
                cnt += mid / (t[i] * 2);
                if(mid % (t[i] * 2) >= t[i]) cnt++;
                
                goldTotal += Math.min(g[i], cnt * w[i]);
                silverTotal += Math.min(s[i], cnt * w[i]);
                total += Math.min(g[i] + s[i], cnt * w[i]);
            }
            
            if(goldTotal >= a && silverTotal >= b && a + b <= total) {
                if(answer > mid) answer = mid;
                max = mid - 1;
                continue;
            }
            
            min = mid + 1;
        }
        
        return answer;
    }
}