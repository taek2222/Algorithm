class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        for(int i = n + 1; ; i++) {
            if(count == Integer.bitCount(i))
                return i;
        }
    }
}