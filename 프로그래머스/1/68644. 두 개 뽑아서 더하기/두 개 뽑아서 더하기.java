import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < numbers.length-1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                int num = numbers[i] + numbers[j];
                if(!list.contains(num))
                    list.add(num);
            }
        }
        
        Collections.sort(list);
        
        int[] result = list.stream()
            .mapToInt(i -> i)
            .toArray();
        
        return result;
    }
}