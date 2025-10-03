import java.util.*;

class Solution {
    public int solution(int[] cards) {
        
        List<Integer> groups = new ArrayList<>();
        boolean[] visit = new boolean[cards.length];
        for(int i = 0; i < cards.length; i++) {
            if(visit[i]) {
                continue;
            }
            
            int nextPos = i;
            int groupCount = 0;
            while(!visit[nextPos]) {
                visit[nextPos] = true;
                nextPos = cards[nextPos] - 1;
                groupCount++;
            }
            
            groups.add(groupCount);
        }
        
        Collections.sort(groups, Collections.reverseOrder());
        
        if(groups.size() < 2) {
            return 0;
        }
        
        return groups.get(0) * groups.get(1);
    }
}