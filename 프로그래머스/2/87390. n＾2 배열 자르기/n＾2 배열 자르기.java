import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {      
        int[] answer = new int[(int)(right-left) + 1];

        for(int i = 0, value; left <= right; left++, i++) {
            int x = (int)(left / (long)n);
            int y = (int)(left % (long)n);
            
            if(x >= y) value = x + 1;
            else value = y + 1;
            
            answer[i] = value;
        }
        
        return answer;
    }
}