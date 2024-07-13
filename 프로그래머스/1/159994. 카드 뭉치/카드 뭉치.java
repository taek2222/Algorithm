import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Queue<String> card1 = new ArrayDeque<>();
        Queue<String> card2 = new ArrayDeque<>();
        
        for(String card : cards1)
            card1.add(card);
        for(String card : cards2)
            card2.add(card);
        
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