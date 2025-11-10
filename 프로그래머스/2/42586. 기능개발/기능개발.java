import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] values = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++) {
            int gap = 100 - progresses[i];
            int value = gap / speeds[i];
            
            if(gap % speeds[i] != 0) {
                value++;
            }
            values[i] = value;
        }
        
        List<Integer> answers = new ArrayList<>();
        int maxValue = values[0];
        int count = 1;
        for(int i = 1; i < values.length; i++) {
            if(maxValue >= values[i]) {
                count++;
                continue;
            }
            answers.add(count);
            
            maxValue = values[i];
            count = 1;
        }
        answers.add(count);
        
        int[] answer = new int[answers.size()];
        for(int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);
        }
        
        return answer;
    }
}