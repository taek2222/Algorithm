import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> completed = new HashMap<>();
        int human;
        
        for(String name : participant) {
            human = 1;
            if(completed.containsKey(name)) {
                human = completed.get(name);
                human++;
            }
            completed.put(name, human);
        }

        for(String name : completion) {
            human = completed.get(name);
            if(human == 1) {
                completed.remove(name);
                continue;
            }
            
            human--;
            completed.put(name, human);
        }
        
        
            
        return completed.keySet().iterator().next();
    }
}