import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> mandarins = new HashMap<>();
        for(int tang : tangerine) {
            mandarins.put(tang, mandarins.getOrDefault(tang, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(mandarins.keySet());
        list.sort((o1, o2) -> mandarins.get(o2) - mandarins.get(o1));
        
        for (Integer key : list) {
            if(k <= 0) {
                break;
            }
            k -= mandarins.get(key);
            answer++;
        }
        
        return answer;
    }
}