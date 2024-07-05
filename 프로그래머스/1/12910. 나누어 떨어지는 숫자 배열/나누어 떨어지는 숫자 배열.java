import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        HashSet<Integer> remainArray = new HashSet<>();
        
        for(int i = 0; i < arr.length; i++) {
            int remain = arr[i] % divisor;
            
            if(!(remain == 0))
                continue;
            
            remainArray.add(arr[i]);
        }
        
        if(remainArray.size() == 0)
            remainArray.add(-1);
        
        int[] answer = remainArray.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
}