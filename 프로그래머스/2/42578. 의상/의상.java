import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> clotheMap = new HashMap<>();
        for(String[] clothe : clothes) {
            clotheMap.put(clothe[1], clotheMap.getOrDefault(clothe[1], 0) + 1);
        }
        
        for(String clothe : clotheMap.keySet()) {
            answer *= clotheMap.get(clothe) + 1;   
        }
        
        return answer - 1;
    }
}