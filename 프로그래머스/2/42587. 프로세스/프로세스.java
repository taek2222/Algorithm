import java.util.*;

class Solution {
    
    class Process {
        int prioritie;
        int sequence;
        
        Process(int prioritie, int sequence) {
            this.prioritie = prioritie;
            this.sequence = sequence;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Deque<Process> deque = new ArrayDeque<>();
        List<Integer> pri = new ArrayList<>();
        
        for(int i = 0; i < priorities.length; i++) {
            deque.add(new Process(priorities[i], i));
            pri.add(priorities[i]);
        }
        
        Collections.sort(pri, Collections.reverseOrder());
        int index = 0;
        
        while(!deque.isEmpty()) {
            Process element = deque.pop();
            if(element.prioritie == pri.get(index)) {
                index++;
                if(element.sequence == location) {
                    return index;
                }
            } else {
                deque.add(element);
            }
        }
        
        return 0;
    }
}