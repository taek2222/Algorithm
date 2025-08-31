import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int index = A.length - 1;
        for(int i = A.length - 1; i >= 0; i--) {
            if (A[i] < B[index]) {
                answer++;
                index--;
            }
        }
        
        return answer;
    }
}