import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        ArrayDeque<String> card1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> card2 = new ArrayDeque<>(Arrays.asList(cards2));
    
        
        for(String g : goal) {
            if(!card1.isEmpty() && card1.peek().equals(g)) {
                card1.poll();
                continue;
            } else if(!card2.isEmpty() && card2.peek().equals(g)) {
                card2.poll();
                continue;
            }
            
            return "No";
        }
        
        return "Yes";
    }
}