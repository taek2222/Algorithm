import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayDeque<String[]> message = new ArrayDeque<>();
        HashMap<String, String> names = new HashMap<>();
        
        for(String rc : record) {
            String[] array = rc.split(" ");
            
            switch(array[0]) {
                case "Enter": message.add(array); names.put(array[1], array[2]); break;
                case "Leave" : message.add(array); break;
                default : names.put(array[1], array[2]); break;
            }
        }
        
        int size = message.size();
        String[] answer = new String[size];
        
        for(int i = 0; i < size; i++) {
            String[] array = message.poll();
            String name = names.get(array[1]);
            if(array[0].equals("Enter"))
                answer[i] = name + "님이 들어왔습니다.";
            else
                answer[i] = name + "님이 나갔습니다.";
        }
        
        
        return answer;
    }
}