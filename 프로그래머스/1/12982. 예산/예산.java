import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        int count, arrayBudget;
        for(int i = 0; i < d.length; i++) {
            
            count = 1; // 물품(갯수)
            arrayBudget = d[i]; // 물품(총 예산)
            
            if(arrayBudget > budget) // 첫 숫자가 예산 초과시 종료
                break;
            
            for(int j = i+1; j < d.length; j++) {
                count++;
                arrayBudget += d[j];
                
                if(arrayBudget > budget) {
                    count--;
                    break;
                }
                   
            }
            if(answer < count)
                answer = count;
        }
        return answer;
    }
}