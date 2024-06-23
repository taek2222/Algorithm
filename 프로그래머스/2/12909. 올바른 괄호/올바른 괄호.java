class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int check = 0;

        for(int i = 0; i < s.length(); i++) {
            
            if(s.charAt(i) == '(') check++;
            else check--;
            
            if(check < 0)
                break;
        }
        
        if(check == 0)
            return true;
        
        return answer;
    }
}