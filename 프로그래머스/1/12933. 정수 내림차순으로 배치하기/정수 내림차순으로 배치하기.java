import java.util.*;

class Solution {
    public long solution(long n) {
        String s = String.valueOf(n);
        String[] arr = s.split("");
        
        Arrays.sort(arr, Collections.reverseOrder());
        s = String.join("", arr);
        
        return Long.valueOf(s);
    }
}