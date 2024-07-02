import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[][] failArray = new int[N+1][2];
        
        for(int i = 0; i < stages.length; i++) {
            int failStage = stages[i] - 1; // 멈춘 스테이지
            
            for(int j = 0; j <= failStage; j++) {
                if(j == failStage) {
                    failArray[j][0]++;
                    failArray[j][1]++;
                    break;
                }
                failArray[j][0]++;
            } 
        }
        
        HashMap<Integer, Double> map = new HashMap<Integer, Double>();
        
        for(int i = 0; i < failArray.length - 1; i++) {
            if(failArray[i][0] == 0) {
                map.put(i, 0.0);
                continue;
            } 
            double fail = (double)failArray[i][1] / failArray[i][0];
            map.put(i, fail);
        }
        
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(map.entrySet());
        
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        
        for(int i = 0; i < failArray.length - 1; i++) {
            answer[i] = entryList.get(i).getKey() + 1;
        }
        
        return answer;
    }
}