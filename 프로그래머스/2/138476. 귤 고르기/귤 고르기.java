import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> mandarins = new HashMap<>();
        for(int tang : tangerine) {
            int value = mandarins.getOrDefault(tang, 0);
            value++;
            mandarins.put(tang, value);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(mandarins.entrySet());
        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        
        for (Map.Entry<Integer, Integer> entry : list) {
            if(k <= 0) {
                break;
            }
            k -= entry.getValue();
            answer++;
        }
        
        return answer;
    }
}