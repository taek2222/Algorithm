import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        HashSet<Integer> numHash = new HashSet<>();
        
        for(int num : nums)
            numHash.add(num);
        
        int size = nums.length;
        
        if(numHash.size() < size / 2)
            return numHash.size();
        else return (size / 2);
    }
}