import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> nums = new ArrayList<>();
        for(int number : numbers) {
            nums.add(String.valueOf(number));
        }
        
        Collections.sort(nums, (n1, n2) -> {
            return (n2 + n1).compareTo(n1 + n2);
        });
        
        if(nums.get(0).equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String number : nums) {
            sb.append(number);
        }
        
        return sb.toString();
    }
}

/**
1. 문자열로 전부 치환
2. 정렬 후 하나씩
**/