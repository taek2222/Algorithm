import java.util.*;

/*
    리팩토리 진행
    1. 기존 코드에서 ArrayList 방법으로 변환.
    2. stream 기능을 활용 ArrayList -> Int 배열로 전환.
*/
public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int lastNumber = -1;
        
        for(int number : arr)
            if(lastNumber != number) {
                result.add(number);
                lastNumber = number;
            }
    
        return result.stream().mapToInt(i -> i).toArray();
    }
}