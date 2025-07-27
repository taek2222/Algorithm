import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> deque = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));

        for(int scv : scoville) {
            deque.add(scv);
        }
        
        while(deque.peek() < K && deque.size() != 1) {
            int lowScovile = deque.poll();
            int secondScovile = deque.poll();
            
            deque.add(lowScovile + (secondScovile * 2));
            answer++;
        }
        
        if(deque.poll() >= K) {
            return answer;
        }
        return -1;
    }
}