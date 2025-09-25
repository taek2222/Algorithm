class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            int division = n % 3;
            n = n / 3;
            
            if(division == 0) {
                sb.append("4");
                n--;
            } else if(division == 1) {
                sb.append("1");
            } else {
                sb.append("2");
            }
        }
        
        return sb.reverse().toString();
    }
}