import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        
        for(String operation : operations) {
            String[] split = operation.split(" ");
            if(split[0].equals("I")) {
                maxQueue.add(Integer.parseInt(split[1]));
                minQueue.add(Integer.parseInt(split[1]));
                continue;
            }
            
            if (maxQueue.isEmpty()) {
                continue;
            }
            
            if(split[1].equals("1")) {
                int number = maxQueue.poll();
                minQueue.remove(number);
            } else {
                int number = minQueue.poll();
                maxQueue.remove(number);
            }
        }
        
        if(maxQueue.isEmpty()) {
            return new int[]{0, 0};
        }
        
        return new int[]{maxQueue.peek(), minQueue.peek()};
    }
}