import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        int time = 0;
        
        List<String> cache = new LinkedList<>();
        for(String city : cities) {
            String str = city.toUpperCase();
            
            if(cache.remove(str)) {
                time++;
            } else {
                if(cache.size() >= cacheSize) {
                    cache.remove(0);
                }
                time += 5;
            }
            cache.add(str);
        }
        
        return time;
    }
}