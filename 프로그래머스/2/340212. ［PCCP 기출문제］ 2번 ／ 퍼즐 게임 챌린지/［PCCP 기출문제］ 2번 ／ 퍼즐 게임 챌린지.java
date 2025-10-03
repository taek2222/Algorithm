class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int min = 1; int max = 1; 
        for(int i = 0; i < diffs.length; i++) max = Math.max(diffs[i], max);
        
        int mid = (min + max) / 2;
        while(min < max) {
            mid = (min + max) / 2;
            
            long time = calculate(mid, diffs, times);
            
            if(time <= limit) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        
        return min;
    }
    
    public long calculate(int level, int[] diffs, int[] times) {
        long time = 0;
        for(int i = 0; i < diffs.length; i++) {
            if(diffs[i] > level) {
                if(i > 0) {
                    time += (times[i] + times[i - 1]) * (diffs[i] - level) + times[i];
                } else {
                    time += times[i] * (diffs[i] - level) + times[i];
                }
            } else {
                time += times[i];
            }
        }
        return time;
    }
}