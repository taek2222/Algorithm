import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        Map<Double, Integer> seesaws = new HashMap<>();
        
        for(int weight : weights) {
            double w1 = (double) weight;
            double w2 = ((double) weight * 2.0) / 3.0;
            double w3 = (double) weight / 2.0;
            double w4 = ((double) weight * 3.0) / 4.0;
            
            if(seesaws.containsKey(w1)) {
                answer += seesaws.get(w1);
            }
            
            if(seesaws.containsKey(w2)) {
                answer += seesaws.get(w2);
            }
            
            if(seesaws.containsKey(w3)) {
                answer += seesaws.get(w3);
            }
            
            if(seesaws.containsKey(w4)) {
                answer += seesaws.get(w4);
            }
            
            seesaws.put(w1, seesaws.getOrDefault(w1, 0) + 1);
        }
        
        return answer;
    }
}