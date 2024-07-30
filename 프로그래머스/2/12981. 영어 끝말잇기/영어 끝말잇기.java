import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        LinkedHashSet<String> list = new LinkedHashSet<>();
        
        list.add(words[0]);
        
        int i;
        for(i = 1; i < words.length; i++) {
            String[] wordBefore = words[i - 1].split("");
            String[] word = words[i].split("");
            
            if(!wordBefore[wordBefore.length-1].equals(word[0]))
                break;
            
            if(list.contains(words[i]))
                break;
            
            list.add(words[i]);
        }
        
        if(i != words.length) {
            i++;
            answer[0] = (i % n == 0) ? n : i % n;
            answer[1] = (int)Math.ceil((double)i / n);
        }

        return answer;
    }
}