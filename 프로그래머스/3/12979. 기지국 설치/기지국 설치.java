class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = w * 2 + 1;
        int spread = 0;
        
        for(int station : stations) {
            int start = Math.max(1, station - w);
            int end = Math.min(n, station + w);
            
            if(start > spread) {
                int gap = start - spread - 1;
                answer += Math.ceil((double) gap / coverage);
            }
            
            spread = end;
        }
        
        if(spread < n) {
            int gap = n - spread;
            answer += Math.ceil((double) gap / coverage);
        }

        return answer;
    }
}