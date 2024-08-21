import java.util.*;

class Solution {
    
    static int[] INFO;
    static int[] result = new int[11];
    static int resultValue = -1;
    static int[] score = new int[11];
    
    public int[] solution(int n, int[] info) { 
        INFO = info;
        
        DFS(0, n);
        
        if(resultValue == -1)
            return new int[] {-1};
        return result;
    }
    
    public void DFS(int depth, int arrow) {
        if(depth + 1 == INFO.length) {
            score[depth] = arrow;
            int value = check();
            if(value != -1 && value >= resultValue) {
                if(value > resultValue) {
                    resultValue = value;
                    result = score.clone();
                }
                else {
                    for(int i = 10; i > -1; i--) {
                        if(result[i] < score[i]) {
                            resultValue = value;
                            result = score.clone();
                            break;
                        } 
                        
                        if(result[i] > score[i])
                            break;
                    }
                }
            }
            return;
        }
        
        if(arrow > INFO[depth]) {
            score[depth] = INFO[depth] + 1;
            DFS(depth + 1, arrow - (INFO[depth] + 1));
            score[depth] = 0;
        }
        
        DFS(depth +1, arrow);
    }
    
    public int check() {
        int apeach = 0, ryan = 0;
        int sc = 10;
        
        for(int i = 0; i < INFO.length; i++) {        
            if(INFO[i] > score[i]) 
                apeach += sc;
            
            if(INFO[i] < score[i])
                ryan += sc;
                
            sc--;
        }
        
        if(ryan > apeach)
            return ryan - apeach;
        return -1;
        
    }
}