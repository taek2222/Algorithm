import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[] supoja2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoja3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            int check = answers[i];
            
            if((i % 5) + 1 == check) score[0]++;
            if(supoja2[(i%8)] == check) score[1]++;
            if(supoja3[(i%10)] == check) score[2]++;
        }
        
        int max = 0;
        
        for(int num : score)
            if(max < num) max = num;
        
        for(int i = 0; i < 3; i++)
            if(max == score[i]) answer.add(i+1);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}