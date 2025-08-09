class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(; left <= right; left++) {
            if(isDivisorEven(left)) {
                answer += left;
                continue;
            }
            answer -= left;
        }
        
        
        return answer;
    }
    
    private boolean isDivisorEven(int number) {
        int count = 0;
        for(int i = 1; i <= number; i++) {
            if(number % i == 0) {
                count++;
            }
        }
        return count % 2 == 0;
    }
}