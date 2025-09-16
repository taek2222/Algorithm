import java.util.*;

class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> queue = new PriorityQueue<>((n1, n2) -> Integer.compare(n2, n1));
        
        int answer = 0;
        for(; answer < enemy.length; answer++) {
            n -= enemy[answer];
            queue.add(enemy[answer]);
            
            if(n < 0) {
                int num = queue.poll();
                if(k == 0) {
                    break;
                }
                n += num;
                k--;
            }
        }
        
        return answer;
    }
}