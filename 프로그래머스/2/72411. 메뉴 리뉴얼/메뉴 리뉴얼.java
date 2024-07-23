import java.util.*;

class Solution {
    
    static HashMap<Integer, HashMap<String, Integer>> order;
    
    public String[] solution(String[] orders, int[] course) {

        order = new HashMap<>();
        for(int i : course)
            order.put(i, new HashMap<>());
        
        for(String or : orders) {
            char[] chArray = or.toCharArray();
            Arrays.sort(chArray);
            combine(chArray, 0, "");
        }
        
        ArrayList<String> answer = new ArrayList<>();
        
        for(HashMap<String, Integer> count : order.values()) {
            count.values()
                .stream()
                .max(Comparator.comparingInt(o -> o))
                .ifPresent(cnt -> count.entrySet()
                          .stream()
                          .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                          .forEach(entry -> answer.add(entry.getKey())));
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    public static void combine(char[] ch, int idx, String st) {
        if(order.containsKey(st.length())) {
            HashMap<String, Integer> map = order.get(st.length());
            map.put(st, map.getOrDefault(st, 0) + 1);
        }
        
        for(int i = idx; i < ch.length; i++)
            combine(ch, i + 1, st + ch[i]);
    }
}