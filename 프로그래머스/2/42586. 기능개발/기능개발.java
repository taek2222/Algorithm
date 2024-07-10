import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        ArrayDeque<Integer[]> deque = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++) {
            // deque.addLast(progresses[i]);
            Integer[] addArray = new Integer[2];
            int day =(int)Math.ceil((100.0 - progresses[i])/(double)speeds[i]);
            addArray[0] = progresses[i];
            addArray[1] = day;
            deque.addLast(addArray);
        }
        
        for(int i = 0; !deque.isEmpty(); i++) {
            Integer[] first = deque.pollFirst();
            int day = first[1];
            int total = 1;
            
            for(Integer[] que : deque)
                if(que[1] <= day) {
                    deque.pollFirst();
                    total++;
                } else {
                    break;
                }
            
            answer.add(total);
        }
        
        
        return answer;
    }
}