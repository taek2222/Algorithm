import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        
        HashSet<Integer> numHash = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        
        int size = nums.length / 2;
        
        return Math.min(size, numHash.size());
    }
}