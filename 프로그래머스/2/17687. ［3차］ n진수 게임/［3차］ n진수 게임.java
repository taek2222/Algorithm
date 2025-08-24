import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        
        List<String> ans = new ArrayList<>();
        int number = 0;
        int manIndex = 1;
        
        while(t > ans.size()) {
            String num = Integer.toString(number, n).toUpperCase();
            for(int i = 0; i < num.length(); i++) {
                if(manIndex > m) manIndex = 1;
                
                if(manIndex == p) {
                    ans.add(String.valueOf(num.charAt(i)));
                    if(ans.size() == t) {
                        break;
                    }
                }
                
                manIndex++;
            }
            number++;
        }
        return String.join("", ans);
    }
}