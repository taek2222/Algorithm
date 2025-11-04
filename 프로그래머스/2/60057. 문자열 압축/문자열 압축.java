import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);
            int count = 1;
            
            for(int j = i; j + i <= s.length(); j += i) {
                String next;
                if (j + i <= s.length()) {
                    next = s.substring(j, j + i);
                } else {
                    next = s.substring(j);
                }
                
                if(prev.equals(next)) {
                    count++;
                } else {
                    if(count > 1) sb.append(count);
                    sb.append(prev);
                    prev = next;
                    count = 1;
                }
            }
            if(count > 1) sb.append(count);
            sb.append(prev);
            
            if(s.length() % i != 0) {
                sb.append(s.substring(s.length() - s.length() % i));
            }
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}