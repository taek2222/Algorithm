import java.util.*;

class Solution {
    public int solution(int[] toppings) {
        Map<Integer, Integer> brother = new HashMap<>();
        Map<Integer, Integer> younger = new HashMap<>();
        
        int answer = 0;
        
        for(int topping : toppings) {
            younger.put(topping, younger.getOrDefault(topping, 0) + 1);
        }
        
        for(int topping : toppings) {
            int value = younger.get(topping);
            
            if(value == 1) {
                younger.remove(topping);
            } else {
                value--;
                younger.put(topping, value);
            }
            
            brother.put(topping, brother.getOrDefault(topping, 0) + 1);
            
            if(brother.size() == younger.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}