import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> wantMap = new HashMap<>();
        HashMap<String, Integer> copyMap;

        for(int i = 0; i < want.length; i++)
            wantMap.put(want[i], number[i]);
        
        for(int i = 0; i <= discount.length - 10; i++) {
            copyMap = (HashMap<String, Integer>)wantMap.clone();
            
            for(int j = i; j < i + 10; j++) {
                if(!copyMap.containsKey(discount[j]))
                    break;

                int get = copyMap.get(discount[j]);
                get--;
                
                if(get == 0)
                    copyMap.remove(discount[j]);
                else
                    copyMap.put(discount[j], get);
                continue;
            }
            
            if(copyMap.isEmpty())
                answer++;
        }
        
        return answer;
    }
}