import java.util.*;

class Solution {
    public int solution(int[] citations) {
        List<Integer> citationList = new ArrayList<>();
        for(int citation : citations) {
            citationList.add(citation);
        }
        
        citationList.sort(Collections.reverseOrder());
        
        int i = 0;
        for(;i < citations.length; i++) {
            if(i < citationList.get(i)) {
                continue;
            } else {
                return i;
            }
        }
        
        return i;
    }
}