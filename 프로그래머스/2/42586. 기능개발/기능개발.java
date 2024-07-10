import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>(); // 정답 배열
        ArrayDeque<Integer> deque = new ArrayDeque<>(); // 큐 생성
        
        for(int i = 0; i < progresses.length; i++) {
            int day =(int)Math.ceil((100.0 - progresses[i])/(double)speeds[i]); // 날짜 계산
            
            deque.addLast(day);
        }
        
        for(int i = 0; !deque.isEmpty(); i++) {
            int day = deque.pollFirst();
            int total = 1;
            
            for(Integer que : deque) {
                if(que > day)
                    break;
                
                deque.pollFirst();
                total++;
            }
            answer.add(total);
        }
        
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}