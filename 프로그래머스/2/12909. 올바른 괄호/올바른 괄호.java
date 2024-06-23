class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        char c;
        int check = 0;

        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            
            if(c == '(') check++;
            else check--;
            
            if(check < 0 || check - (s.length()-i) > 0)
                return false;
        }
        
        if(check == 0)
            return answer;
        else
            return false;
    }
}