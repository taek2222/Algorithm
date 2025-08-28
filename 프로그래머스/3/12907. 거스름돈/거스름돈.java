class Solution {
    public int solution(int n, int[] moneys) {
        int division = 1_000_000_007;
        
        int[] answer = new int[n + 1];
        answer[0] = 1;
        
        for(int money : moneys) {
            for(int i = money; i <= n; i++) {
                answer[i] += answer[i-money] % division;
            }
        }
        
        return answer[n];
    }
}
