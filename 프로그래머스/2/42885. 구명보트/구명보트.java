import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int left = 0;
        int rigth = people.length - 1;
        
        while(left <= rigth) {
            if(people[left] + people[rigth] <= limit) {
                left++;
            }
            rigth--;
            answer++;
        }
        
        return answer;
    }
}