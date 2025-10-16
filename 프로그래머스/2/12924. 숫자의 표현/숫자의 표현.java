class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
            int total = 0;
            for(int j = i; j <= n; j++) {
                total += j;
                
                if(total > n) break;
                
                if(total == n) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}