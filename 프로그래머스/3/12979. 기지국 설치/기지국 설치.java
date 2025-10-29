class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = w * 2 + 1;
        int prevend = 0;
        
        for(int station : stations) {
            int start = Math.max(1, station - w);
            int end = Math.min(n, station + w);
            
            if(start > prevend + 1) {
                int gap = start - prevend - 1;
                answer += Math.ceil((double) gap / coverage);
            }
            
            prevend = end;
        }
        
        if(prevend < n) {
            int gap = n - prevend;
            answer += Math.ceil((double) gap / coverage);
        }

        return answer;
    }
}