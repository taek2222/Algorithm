import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answerArray = new int[arr.length];
        
        int lastNumber = -1;
        int i = 0;
        
        for(int number : arr) {
            if(lastNumber == number)
                continue;
            answerArray[i] = number;
            lastNumber = number;
            i++;
        }
        
        int[] answer = new int[i];
        
        for(int j = 0; j < answer.length; j++)
            answer[j] = answerArray[j];
            

        return answer;
    }
}