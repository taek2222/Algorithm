import java.util.*;

/*
    replace() 함수 : 문자열에서 치환.
    isBlank() 함수 : 문자열에 공백만 존재하는 지 체크.
*/

class Solution {
    public int solution(String[] babbling) {

        String[] enunciation = {"aya", "ye", "woo", "ma"};
        int count = 0;
        
        for(String s : babbling) {
            for(String e : enunciation) {
                s = s.replace(e, " ");
            }
            if(s.isBlank())
                count++;
        }
        
        return count;
    }
}