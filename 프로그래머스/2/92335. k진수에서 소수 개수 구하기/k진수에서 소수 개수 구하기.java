class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] str = Integer.toString(n, k).split("0");
        
        for(String s : str) {
            if(s.isEmpty()) continue;
            
            long num = Long.parseLong(s, 10);      
            if(prime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean prime(long number) {
        if (number < 2) return false;
        for(long i = 2; i * i <= number; i++) {
            if(number % i == 0) {
                return false;
            } 
        }
        return true;
    } 
}