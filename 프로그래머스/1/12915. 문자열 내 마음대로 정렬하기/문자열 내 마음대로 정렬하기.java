import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        Arrays.sort(strings);
        
        char c = 'a';
        
        for(int i = 0, k = 0; i < 26; i++) {
            for(String s : strings) {
                if(s.charAt(n) == c + i)
                    answer[k++] = s;
            }
        }
        
        return answer;
    }
}